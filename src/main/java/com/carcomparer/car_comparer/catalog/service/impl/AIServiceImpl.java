package com.carcomparer.car_comparer.catalog.service.impl;

import java.nio.file.Path;

import org.springframework.stereotype.Service;

import com.carcomparer.car_comparer.catalog.model.entities.CarEntity;
import com.carcomparer.car_comparer.catalog.service.AIService;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.parser.apache.pdfbox.ApachePdfBoxDocumentParser;


@Service
public class AIServiceImpl {

    private final AIService aiService = null;

    public CarEntity PDFparser(Path rutaPDF) {
        ApachePdfBoxDocumentParser parser = new ApachePdfBoxDocumentParser();
        Document document = FileSystemDocumentLoader.loadDocument(rutaPDF, parser);

        String PDFparsed = document.text();

        return aiService.specsExtractor(PDFparsed);
    }
    
}
