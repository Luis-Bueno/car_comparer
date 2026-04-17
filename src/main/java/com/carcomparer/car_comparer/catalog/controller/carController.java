package com.carcomparer.car_comparer.catalog.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carcomparer.car_comparer.catalog.model.dtos.CarRequestDTO;
import com.carcomparer.car_comparer.catalog.model.dtos.CarResponseDTO;
import com.carcomparer.car_comparer.catalog.model.dtos.ResponseDTO;
import com.carcomparer.car_comparer.catalog.service.CarService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/carcomparer")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping("/{id}")
    public ResponseDTO<CarResponseDTO> getCarByID(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @GetMapping
    public ResponseDTO<List<CarResponseDTO>> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping
    public ResponseDTO<CarResponseDTO> createCar(@RequestBody CarRequestDTO car) {
        return carService.createCar(car);
    }
}

