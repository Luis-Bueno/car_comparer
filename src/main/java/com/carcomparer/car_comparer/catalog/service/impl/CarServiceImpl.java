package com.carcomparer.car_comparer.catalog.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.carcomparer.car_comparer.catalog.model.dtos.CarResponseDTO;
import com.carcomparer.car_comparer.catalog.model.dtos.ResponseDTO;
import com.carcomparer.car_comparer.catalog.model.entities.CarEntity;
import com.carcomparer.car_comparer.catalog.model.entities.FeatureEntity;
import com.carcomparer.car_comparer.catalog.model.entities.TechnicalSpecsEntity;
import com.carcomparer.car_comparer.catalog.repository.CarRepository;
import com.carcomparer.car_comparer.catalog.service.CarService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService{
    private final CarRepository carRepository;

    private TechnicalSpecsEntity specs = null;
    private FeatureEntity features = null;

    @Override
    @Transactional
    public ResponseDTO<CarEntity> createCar(CarEntity carDTO) {
        if (Objects.isNull(carDTO)){
            System.err.println("El objeto a insertar no puede ser vacio");
            return null;
        }

        CarEntity car = CarEntity.builder()
                .brand(carDTO.getBrand())
                .model(carDTO.getModel())
                .year(carDTO.getYear())
                .userId(carDTO.getUserId())
                .build();
        
        specs = TechnicalSpecsEntity.builder()
                // Engine and performance
                .engine_type(specs.getEngine_type())
                .hp(specs.getHp())
                .cc(specs.getCc())
                .power_engine_ratio(specs.getPower_engine_ratio())
                .max_torque(specs.getMax_torque())
                .max_velocity(specs.getMax_velocity())
                .aceleration(specs.getAceleration())
                .aspiration(specs.getAspiration())
                // Transmission and Drivetrain
                .transmission_type(specs.getTransmission_type())
                .speeds(specs.getSpeeds())
                .drivetrain(specs.getDrivetrain())
                .lsd(specs.getLsd())
                // Dimensions and Capacities
                .weight(specs.getWeight())
                .wheelbase(specs.getWheelbase())
                .length(specs.getLength())
                .width(specs.getWidth())
                .heigth(specs.getHeigth())
                .ground_clearance(specs.getGround_clearance())
                .trunk(specs.getTrunk())
                .fuel_tank(specs.getFuel_tank())
                .seats(specs.getSeats())
                // Fuel Economy
                .city_kmpl(specs.getCity_kmpl())
                .highway_kmpl(specs.getHighway_kmpl())
                .combined_kmpl(specs.getCombined_kmpl())
                .range(specs.getRange())
                // Chassis, Suspension and Safety
                .braking_system(specs.getBraking_system())
                .FR_suspension(specs.getFR_suspension())
                .Airbags(specs.getAirbags())
                .ADAS(specs.getADAS())
                .car(car) // Relación bidireccional
                .build();

        features = FeatureEntity.builder()
                // Connectivity
                .hasAppleCarPlay(features.getHasAppleCarPlay())
                .hasAndroidAuto(features.getHasAndroidAuto())
                .soundSystemBrand(features.getSoundSystemBrand())
                // Comfort
                .interiorMaterial(features.getInteriorMaterial())
                .hasSunroof(features.getHasSunroof())
                .climateZones(features.getClimateZones())
                // Safety (ADAs)
                .hasAdaptiveCruiseControl(features.getHasAdaptiveCruiseControl())
                .hasBlindSpotMonitor(features.getHasBlindSpotMonitor())
                .car(car) // Relación bidireccional
                .build();

        car.setFeatures(features);
        car.setTechnicalSpecs(specs);
        CarEntity savedCar = carRepository.createCar(car);

        return mapToResponseDTO(savedCar, "El carro se guardo correctamente");
    }

    @Override
    public ResponseDTO<List<CarResponseDTO>> getAllCars() {
        List<CarResponseDTO> cars = carRepository.getAllCars();
        return mapToResponseDTO(cars, "Listado completo");
    }

    @Override
    public ResponseDTO<CarResponseDTO> getCarById(Long id) {
        CarResponseDTO car = carRepository.getCarById(id);
        return mapToResponseDTO(car, "Vehiculo encontrado");
    }

    private <T> ResponseDTO<T> mapToResponseDTO(T data, String message) {
    return ResponseDTO.<T>builder()
            .message(message != null ? message : "Operación exitosa")
            .data(data)
            .build();
    }

}
