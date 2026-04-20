package com.carcomparer.car_comparer.catalog.service;

import com.carcomparer.car_comparer.catalog.model.entities.CarEntity;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface AIService {

    @SystemMessage("""
        Eres un experto en datos automotrices. 
        Analiza el texto y extrae la información técnica estrictamente.
        Debes devolver los datos necesarios para llenar un objeto CarEntity.
        Si un valor numérico no existe, usa 0.
        """)

    CarEntity specsExtractor(String PDFparsed);

}