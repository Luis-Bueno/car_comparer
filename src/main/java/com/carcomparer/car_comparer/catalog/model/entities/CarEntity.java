package com.carcomparer.car_comparer.catalog.model.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    @Column(name = "`year`")
    private int year;

    private Long userId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "technical_spec_id")
    private TechnicalSpecsEntity technicalSpecs;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_feature_id")
    private FeatureEntity features;
}
