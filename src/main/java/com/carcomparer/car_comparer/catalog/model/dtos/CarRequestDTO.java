package com.carcomparer.car_comparer.catalog.model.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarRequestDTO {

    private String brand;
    private String model;
    private int year;
    
}
