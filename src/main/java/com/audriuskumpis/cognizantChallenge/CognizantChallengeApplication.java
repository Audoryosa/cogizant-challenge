package com.audriuskumpis.cognizantChallenge;

import com.audriuskumpis.cognizantChallenge.entity.Warehouse;
import com.audriuskumpis.cognizantChallenge.service.WarehouseService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class CognizantChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CognizantChallengeApplication.class, args);
	}

	// imports data from given .json file to repository on application start
	@Bean
	CommandLineRunner runner(WarehouseService warehouseService) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Warehouse>> typeReference = new TypeReference<>() {};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/warehouses.json");
			try {
				List<Warehouse> warehouses = mapper.readValue(inputStream, typeReference);
				warehouseService.saveAll(warehouses);
				System.out.println("Warehouses saved!");
			} catch (IOException e) {
				System.err.println("Unable to load warehouses: " + e.getMessage());
			}
		};
	}
}
