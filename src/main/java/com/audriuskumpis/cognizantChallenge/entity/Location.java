package com.audriuskumpis.cognizantChallenge.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    private String lat;

    @JsonProperty("long")
    private String lon;
}
