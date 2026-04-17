package com.carcomparer.car_comparer.catalog.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TechnicalSpecsResponseDTO {
    private String engine_type;
    private double hp;
    private double cc;
    private double power_engine_ratio;
    private double max_torque;
    private double max_velocity;
    private double aceleration;
    private String aspiration;

    private String transmission_type;
    private short speeds;
    private String drivetrain;
    private double lsd;

    private double weight;
    private double wheelbase;
    private double length;
    private double width;
    private double heigth;
    private double ground_clearance;
    private double trunk;
    private double fuel_tank;
    private short seats;

    private double city_kmpl;
    private double highway_kmpl;
    private double combined_kmpl;
    private double range;

    private String braking_system;
    private String FR_suspension;
    private short Airbags;
    private String ADAS;
}
