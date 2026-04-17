package com.carcomparer.car_comparer.catalog.service.impl;

import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.web.multipart.MultipartFile;

import com.carcomparer.car_comparer.catalog.service.PdfProcessingService;

public class PdfProcessingServiceImpl implements PdfProcessingService {

    @Override
    public String extractTextFromPdf(MultipartFile file) throws IOException {
       try (PDDocument document = Loader.loadPDF(file.getBytes())) {
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(document);
        }
    }
    
}
