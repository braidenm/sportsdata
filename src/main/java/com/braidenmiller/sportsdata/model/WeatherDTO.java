package com.braidenmiller.sportsdata.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeatherDTO {
    private String latitude;
    private String longitude;
    private WeatherCurrentConditions currentConditions;
}

