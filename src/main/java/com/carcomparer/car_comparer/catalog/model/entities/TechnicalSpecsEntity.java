package com.carcomparer.car_comparer.catalog.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;

@Entity
@Builder
@Getter
public class TechnicalSpecsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Engine and performance
    private String engine_type;
    private double hp;
    private double cc;
    private double power_engine_ratio;
    private double max_torque;
    private double max_velocity;
    private double aceleration;
    private String aspiration;
    
    //Transmission and Drivetrain
    private String transmission_type;
    private short speeds;
    private String drivetrain;
    private double lsd;

    //Dimesions and Capacities
    private double weight;
    private double wheelbase;
    private double length;
    private double width;
    private double heigth;
    private double ground_clearance;
    private double trunk;
    private double fuel_tank;
    private short seats;

    //Fuel Economy
    private double city_kmpl;
    private double highway_kmpl;
    private double combined_kmpl;
    private double range;

    //Chassis, Suspension and Safety
    private String braking_system;
    private String FR_suspension;
    private short Airbags;
    private String ADAS;

    @OneToOne(mappedBy = "technicalSpecs")
    private CarEntity car;

}
