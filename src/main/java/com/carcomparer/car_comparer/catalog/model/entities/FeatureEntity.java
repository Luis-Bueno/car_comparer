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
public class FeatureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Connectivity
    private Boolean hasAppleCarPlay;
    private Boolean hasAndroidAuto;
    private String soundSystemBrand;

    // Comfort
    private String interiorMaterial;
    private Boolean hasSunroof;
    private Integer climateZones;

    // Safety (ADAs)
    private Boolean hasAdaptiveCruiseControl;
    private Boolean hasBlindSpotMonitor;

    @OneToOne(mappedBy = "features")
    private CarEntity car;

}
