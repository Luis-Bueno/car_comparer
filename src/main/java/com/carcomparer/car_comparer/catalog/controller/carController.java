package com.carcomparer.car_comparer.catalog.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.carcomparer.car_comparer.catalog.model.dtos.CarResponseDTO;
import com.carcomparer.car_comparer.catalog.model.dtos.ResponseDTO;
import com.carcomparer.car_comparer.catalog.model.entities.CarEntity;
import com.carcomparer.car_comparer.catalog.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class carController {
    private final CarService carService = null;

    @GetMapping("/carcomparer/{id}")
    public ResponseDTO<CarResponseDTO> getCarByID(@RequestParam Long id) {
        return carService.getCarById(id);
    }

    @GetMapping("/carcomparer")
    public ResponseDTO<List<CarResponseDTO>> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping("/carcomparer")
    public ResponseDTO<CarEntity> createCar(@RequestBody CarEntity car) {
        return carService.createCar(car);
    }
    
    
}
