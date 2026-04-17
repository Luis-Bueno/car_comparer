package com.carcomparer.car_comparer.catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carcomparer.car_comparer.catalog.service.AIService;

@RestController
public class AITestController {

    @Autowired
    AIService assistant;

    @GetMapping("/chat")
    public String chat(String message) {
        return assistant.chat(message);
    }

}
