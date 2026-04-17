package com.carcomparer.car_comparer.catalog.controller;

import org.springframework.http.HttpHeaders;

import java.net.MalformedURLException;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.carcomparer.car_comparer.catalog.service.FileStorageService;
import com.carcomparer.car_comparer.catalog.utils.StorageException;
import com.carcomparer.car_comparer.catalog.utils.StorageFileNotFoundException;

import org.springframework.ui.Model;

@Controller
public class FileUploadController {

    private final FileStorageService storageService;

    public FileUploadController(FileStorageService storageService){
        this.storageService = storageService;
    }

    @GetMapping("/fileupload/")
    public String listUploadedFiles(Model model){
        model.addAttribute("files", storageService.loadAll().map(
            path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                "saveFile", path.getFileName().toString()).build().toUri().toString())
            .collect(Collectors.toList()));
        return "uploadForm";
    }

    @GetMapping("/fileupload/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> saveFile(@PathVariable String filename) throws MalformedURLException{
        Resource file = storageService.loadAsResource(filename);

        if(file == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
            "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/fileupload/")
public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
    try {
        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
            "¡Archivo subido con éxito: " + file.getOriginalFilename() + "!");
    } catch (StorageException e) {
        redirectAttributes.addFlashAttribute("message", "Error: " + e.getMessage());
    }
    return "redirect:/fileupload/";
}

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc){
        return ResponseEntity.notFound().build();
    }
    
}
