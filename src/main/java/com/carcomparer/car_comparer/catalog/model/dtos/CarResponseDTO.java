package com.carcomparer.car_comparer.catalog.model.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter 
public class CarResponseDTO {
    private long id;

    private String brand;
    private String model;
    private int year;

    private int userId;

}
