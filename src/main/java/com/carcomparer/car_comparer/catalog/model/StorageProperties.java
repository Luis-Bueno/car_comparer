package com.carcomparer.car_comparer.catalog.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties("storage")
public class StorageProperties {

    private String location = "src/main/resources/uploads";

}
