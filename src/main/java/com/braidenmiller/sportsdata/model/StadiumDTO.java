package com.braidenmiller.sportsdata.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StadiumDTO {
    @JsonProperty("StadiumID")
    private Long id;
    @JsonProperty("Active")
    private boolean active;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Dome")
    private boolean dome;
    @JsonProperty("City")
    private String city;
    @JsonProperty("State")
    private String state;
    @JsonProperty("GeoLat")
    private String geoLat;
    @JsonProperty("GeoLong")
    private String geoLong;
}
