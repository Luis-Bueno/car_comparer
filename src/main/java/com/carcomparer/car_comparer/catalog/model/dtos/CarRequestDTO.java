package com.carcomparer.car_comparer.catalog.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarRequestDTO {

    private String brand;
    private String model;
    private int year;
    private Long userId;
    private TechnicalSpecsRequestDTO technicalSpecs;
    private FeatureRequestDTO features;

} 
