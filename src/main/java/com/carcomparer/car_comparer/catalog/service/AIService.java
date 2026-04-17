package com.carcomparer.car_comparer.catalog.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface AIService {

    @SystemMessage("You are a polite assistant")
    String chat(String userMessage);
    
}