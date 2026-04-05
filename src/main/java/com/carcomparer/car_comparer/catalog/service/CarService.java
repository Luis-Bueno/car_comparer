package com.carcomparer.car_comparer.catalog.service;

import java.util.List;

import com.carcomparer.car_comparer.catalog.model.dtos.CarResponseDTO;
import com.carcomparer.car_comparer.catalog.model.dtos.ResponseDTO;
import com.carcomparer.car_comparer.catalog.model.entities.CarEntity;

public interface CarService {
    ResponseDTO<CarEntity>  createCar(CarEntity carDTO);
    ResponseDTO<List<CarResponseDTO>> getAllCars();
    ResponseDTO<CarResponseDTO> getCarById(Long id);
}
