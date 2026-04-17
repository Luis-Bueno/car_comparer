package com.carcomparer.car_comparer.catalog.service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    void init();
    void store(MultipartFile file);
    Stream<Path> loadAll();
    Path load(String filename);
    Resource loadAsResource(String filename) throws MalformedURLException;
    void deleteAll();
    
}
