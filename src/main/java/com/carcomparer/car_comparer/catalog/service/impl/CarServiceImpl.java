package com.carcomparer.car_comparer.catalog.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.carcomparer.car_comparer.catalog.model.dtos.CarRequestDTO;
import com.carcomparer.car_comparer.catalog.model.dtos.CarResponseDTO;
import com.carcomparer.car_comparer.catalog.model.dtos.FeatureRequestDTO;
import com.carcomparer.car_comparer.catalog.model.dtos.FeatureResponseDTO;
import com.carcomparer.car_comparer.catalog.model.dtos.ResponseDTO;
import com.carcomparer.car_comparer.catalog.model.dtos.TechnicalSpecsRequestDTO;
import com.carcomparer.car_comparer.catalog.model.dtos.TechnicalSpecsResponseDTO;
import com.carcomparer.car_comparer.catalog.model.entities.CarEntity;
import com.carcomparer.car_comparer.catalog.model.entities.FeatureEntity;
import com.carcomparer.car_comparer.catalog.model.entities.TechnicalSpecsEntity;
import com.carcomparer.car_comparer.catalog.repository.CarRepository;
import com.carcomparer.car_comparer.catalog.service.CarService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Override
    @Transactional
    public ResponseDTO<CarResponseDTO> createCar(CarRequestDTO carDTO) {
        if (Objects.isNull(carDTO)) {
            return ResponseDTO.<CarResponseDTO>builder()
                    .message("El objeto a insertar no puede ser vacío")
                    .data(null)
                    .build();
        }

        CarEntity carEntity = mapToEntity(carDTO);
        CarEntity savedCar = carRepository.save(carEntity);
        return mapToResponseDTO(mapToDTO(savedCar), "El carro se guardó correctamente");
    }

    private CarEntity mapToEntity(CarRequestDTO request) {
        FeatureEntity features = null;
        TechnicalSpecsEntity technicalSpecs = null;

        if (request.getFeatures() != null) {
            FeatureRequestDTO featureRequest = request.getFeatures();
            features = FeatureEntity.builder()
                    .hasAppleCarPlay(featureRequest.getHasAppleCarPlay())
                    .hasAndroidAuto(featureRequest.getHasAndroidAuto())
                    .soundSystemBrand(featureRequest.getSoundSystemBrand())
                    .interiorMaterial(featureRequest.getInteriorMaterial())
                    .hasSunroof(featureRequest.getHasSunroof())
                    .climateZones(featureRequest.getClimateZones())
                    .hasAdaptiveCruiseControl(featureRequest.getHasAdaptiveCruiseControl())
                    .hasBlindSpotMonitor(featureRequest.getHasBlindSpotMonitor())
                    .build();
        }

        if (request.getTechnicalSpecs() != null) {
            TechnicalSpecsRequestDTO specsRequest = request.getTechnicalSpecs();
            technicalSpecs = TechnicalSpecsEntity.builder()
                    .engine_type(specsRequest.getEngine_type())
                    .hp(specsRequest.getHp())
                    .cc(specsRequest.getCc())
                    .power_engine_ratio(specsRequest.getPower_engine_ratio())
                    .max_torque(specsRequest.getMax_torque())
                    .max_velocity(specsRequest.getMax_velocity())
                    .aceleration(specsRequest.getAceleration())
                    .aspiration(specsRequest.getAspiration())
                    .transmission_type(specsRequest.getTransmission_type())
                    .speeds(specsRequest.getSpeeds())
                    .drivetrain(specsRequest.getDrivetrain())
                    .lsd(specsRequest.getLsd())
                    .weight(specsRequest.getWeight())
                    .wheelbase(specsRequest.getWheelbase())
                    .length(specsRequest.getLength())
                    .width(specsRequest.getWidth())
                    .heigth(specsRequest.getHeigth())
                    .ground_clearance(specsRequest.getGround_clearance())
                    .trunk(specsRequest.getTrunk())
                    .fuel_tank(specsRequest.getFuel_tank())
                    .seats(specsRequest.getSeats())
                    .city_kmpl(specsRequest.getCity_kmpl())
                    .highway_kmpl(specsRequest.getHighway_kmpl())
                    .combined_kmpl(specsRequest.getCombined_kmpl())
                    .range(specsRequest.getRange())
                    .braking_system(specsRequest.getBraking_system())
                    .FR_suspension(specsRequest.getFR_suspension())
                    .Airbags(specsRequest.getAirbags())
                    .ADAS(specsRequest.getADAS())
                    .build();
        }

        return CarEntity.builder()
                .brand(request.getBrand())
                .model(request.getModel())
                .year(request.getYear())
                .userId(request.getUserId())
                .features(features)
                .technicalSpecs(technicalSpecs)
                .build();
    }

    private FeatureResponseDTO mapToFeatureDTO(FeatureEntity feature) {
        if (feature == null) {
            return null;
        }

        return FeatureResponseDTO.builder()
                .hasAppleCarPlay(feature.getHasAppleCarPlay())
                .hasAndroidAuto(feature.getHasAndroidAuto())
                .soundSystemBrand(feature.getSoundSystemBrand())
                .interiorMaterial(feature.getInteriorMaterial())
                .hasSunroof(feature.getHasSunroof())
                .climateZones(feature.getClimateZones())
                .hasAdaptiveCruiseControl(feature.getHasAdaptiveCruiseControl())
                .hasBlindSpotMonitor(feature.getHasBlindSpotMonitor())
                .build();
    }

    private TechnicalSpecsResponseDTO mapToSpecsDTO(TechnicalSpecsEntity specs) {
        if (specs == null) {
            return null;
        }

        return TechnicalSpecsResponseDTO.builder()
                .engine_type(specs.getEngine_type())
                .hp(specs.getHp())
                .cc(specs.getCc())
                .power_engine_ratio(specs.getPower_engine_ratio())
                .max_torque(specs.getMax_torque())
                .max_velocity(specs.getMax_velocity())
                .aceleration(specs.getAceleration())
                .aspiration(specs.getAspiration())
                .transmission_type(specs.getTransmission_type())
                .speeds(specs.getSpeeds())
                .drivetrain(specs.getDrivetrain())
                .lsd(specs.getLsd())
                .weight(specs.getWeight())
                .wheelbase(specs.getWheelbase())
                .length(specs.getLength())
                .width(specs.getWidth())
                .heigth(specs.getHeigth())
                .ground_clearance(specs.getGround_clearance())
                .trunk(specs.getTrunk())
                .fuel_tank(specs.getFuel_tank())
                .seats(specs.getSeats())
                .city_kmpl(specs.getCity_kmpl())
                .highway_kmpl(specs.getHighway_kmpl())
                .combined_kmpl(specs.getCombined_kmpl())
                .range(specs.getRange())
                .braking_system(specs.getBraking_system())
                .FR_suspension(specs.getFR_suspension())
                .Airbags(specs.getAirbags())
                .ADAS(specs.getADAS())
                .build();
    }

    private CarResponseDTO mapToDTO(CarEntity car) {
        if (car == null) {
            return null;
        }

        return CarResponseDTO.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .year(car.getYear())
                .userId(car.getUserId())
                .features(mapToFeatureDTO(car.getFeatures()))
                .technicalSpecs(mapToSpecsDTO(car.getTechnicalSpecs()))
                .build();
    }

    @Override
    public ResponseDTO<List<CarResponseDTO>> getAllCars() {
        List<CarResponseDTO> cars = carRepository.findAll().stream()
                .map(this::mapToDTO)
                .toList();
        return mapToResponseDTO(cars, "Listado completo");
    }

    @Override
    public ResponseDTO<CarResponseDTO> getCarById(Long id) {
        CarResponseDTO car = carRepository.findById(id)
                .map(this::mapToDTO)
                .orElse(null);

        return mapToResponseDTO(car, car != null ? "Vehículo encontrado" : "Vehículo no encontrado");
    }

    private <T> ResponseDTO<T> mapToResponseDTO(T data, String message) {
        return ResponseDTO.<T>builder()
                .message(message != null ? message : "Operación exitosa")
                .data(data)
                .build();
    }
}

