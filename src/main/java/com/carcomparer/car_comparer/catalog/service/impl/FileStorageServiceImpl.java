package com.carcomparer.car_comparer.catalog.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.carcomparer.car_comparer.catalog.model.StorageProperties;
import com.carcomparer.car_comparer.catalog.service.FileStorageService;
import com.carcomparer.car_comparer.catalog.utils.StorageException;
import com.carcomparer.car_comparer.catalog.utils.StorageFileNotFoundException;

@Service
public class FileStorageServiceImpl implements FileStorageService{

    private Path rootLocation;

    @Autowired
    public void FileStorageService(StorageProperties properties){
        if(properties.getLocation().trim().length() == 0){
            throw new StorageException("File upload location cant be Empty");
        }
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public void store(MultipartFile file) {
        try {
            if(file.isEmpty()){
                throw new StorageException("Failed to store empty file");
            }

            String contentType = file.getContentType();
            if (contentType == null || !contentType.equals("application/pdf")) {
                throw new StorageException("Solo se permiten archivos PDF. Tipo actual: " + contentType);
            }

            Path destinationFile = this.rootLocation.resolve(
                Paths.get(file.getOriginalFilename()))
                .normalize().toAbsolutePath();
            if(!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
                throw new StorageException(
                    "Cannot store file outside current directory");
            }
            try(InputStream inputStream = file.getInputStream()){
                Files.copy(inputStream, destinationFile, 
                    StandardCopyOption.REPLACE_EXISTING);
            }
        }catch(IOException e){
            throw new StorageException("Failed to store file.", e);
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
            .filter(path -> !path.equals(this.rootLocation))
            .map(this.rootLocation::relativize);
        }catch(IOException e){
            throw new StorageException("Failed to read stored files", e);
        }
    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) throws MalformedURLException {
        try{
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }else{
                throw new StorageFileNotFoundException(
                    "Could not read file: " + filename);
            }
        }catch(MalformedURLException e){
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        }catch(IOException e){
            throw new StorageException("Could not initialize storage", e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    
    
}
