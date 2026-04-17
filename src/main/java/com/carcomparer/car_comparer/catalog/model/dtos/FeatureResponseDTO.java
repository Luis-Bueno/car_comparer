package com.carcomparer.car_comparer.catalog.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeatureResponseDTO {
    private Boolean hasAppleCarPlay;
    private Boolean hasAndroidAuto;
    private String soundSystemBrand;

    private String interiorMaterial;
    private Boolean hasSunroof;
    private Integer climateZones;

    private Boolean hasAdaptiveCruiseControl;
    private Boolean hasBlindSpotMonitor;
}
