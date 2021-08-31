package com.audriuskumpis.cognizantChallenge.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "warehouse")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Warehouse {

    @Id
    @JsonProperty("_id")
    private Integer id;

    private String name;

    private Location location;

    private Cars cars;

}
