package com.braidenmiller.sportsdata.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeatherCurrentConditions {
    private String temp;
    private String feelslike;
    private String winddir;
    private String windspeed;
    private String windgust;
    private String precip;
    private String conditions;
}

