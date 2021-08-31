package com.audriuskumpis.cognizantChallenge.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Vehicle {

    @Id
    @JsonProperty("_id")
    private Integer id;

    private String make;

    private String model;

    @JsonProperty("year_model")
    private int yearModel;

    private double price;

    private boolean licensed;

    @JsonProperty("date_added")
    private String dateAdded;
}
