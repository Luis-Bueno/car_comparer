package com.carcomparer.car_comparer.catalog.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface PdfProcessingService {

    String extractTextFromPdf(MultipartFile file) throws IOException;

}
