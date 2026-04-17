package com.carcomparer.car_comparer.catalog.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.carcomparer.car_comparer.catalog.model.entities.CarEntity;
import com.carcomparer.car_comparer.catalog.model.entities.FeatureEntity;
import com.carcomparer.car_comparer.catalog.model.entities.TechnicalSpecsEntity;
import com.carcomparer.car_comparer.catalog.repository.CarRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CarRepository carRepository;

    @Override
    public void run(String... args) {
        if (carRepository.count() > 0) {
            return;
        }

        FeatureEntity features = new FeatureEntity();
        features.setHasAppleCarPlay(true);
        features.setHasAndroidAuto(true);
        features.setSoundSystemBrand("Bose");
        features.setInteriorMaterial("Leather");
        features.setHasSunroof(true);
        features.setClimateZones(2);
        features.setHasAdaptiveCruiseControl(true);
        features.setHasBlindSpotMonitor(true);

        TechnicalSpecsEntity technicalSpecs = new TechnicalSpecsEntity();
        technicalSpecs.setEngine_type("Hybrid");
        technicalSpecs.setHp(180.0);
        technicalSpecs.setCc(1800.0);
        technicalSpecs.setPower_engine_ratio(0.1);
        technicalSpecs.setMax_torque(220.0);
        technicalSpecs.setMax_velocity(210.0);
        technicalSpecs.setAceleration(8.5);
        technicalSpecs.setAspiration("Turbo");
        technicalSpecs.setTransmission_type("CVT");
        technicalSpecs.setSpeeds((short) 1);
        technicalSpecs.setDrivetrain("FWD");
        technicalSpecs.setLsd(0.0);
        technicalSpecs.setWeight(1320.0);
        technicalSpecs.setWheelbase(2700.0);
        technicalSpecs.setLength(4630.0);
        technicalSpecs.setWidth(1775.0);
        technicalSpecs.setHeigth(1455.0);
        technicalSpecs.setGround_clearance(140.0);
        technicalSpecs.setTrunk(470.0);
        technicalSpecs.setFuel_tank(43.0);
        technicalSpecs.setSeats((short) 5);
        technicalSpecs.setCity_kmpl(16.0);
        technicalSpecs.setHighway_kmpl(20.0);
        technicalSpecs.setCombined_kmpl(18.0);
        technicalSpecs.setRange(770.0);
        technicalSpecs.setBraking_system("ABS");
        technicalSpecs.setFR_suspension("MacPherson");
        technicalSpecs.setAirbags((short) 8);
        technicalSpecs.setADAS("Lane Assist");

        CarEntity car = new CarEntity();
        car.setBrand("Toyota");
        car.setModel("Corolla");
        car.setYear(2024);
        car.setUserId(123L);
        car.setFeatures(features);
        car.setTechnicalSpecs(technicalSpecs);

        carRepository.save(car);
    }
}
