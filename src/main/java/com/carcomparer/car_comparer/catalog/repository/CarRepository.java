package com.carcomparer.car_comparer.catalog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.carcomparer.car_comparer.catalog.model.dtos.CarResponseDTO;
import com.carcomparer.car_comparer.catalog.model.entities.CarEntity;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer>{
    List<CarResponseDTO> getAllCars();
    CarResponseDTO getCarById(Long id);
    
    @Modifying
    @Transactional
    CarEntity createCar(CarEntity carDTO);
}
