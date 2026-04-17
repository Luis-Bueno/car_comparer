package com.carcomparer.car_comparer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.carcomparer.car_comparer.catalog.model.StorageProperties;
import com.carcomparer.car_comparer.catalog.service.FileStorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class CarComparerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarComparerApplication.class, args);
	}

	@Bean
	CommandLineRunner init(FileStorageService storageService) {
		return (args) -> {
		storageService.deleteAll();
		storageService.init();
		};
	}
}
 