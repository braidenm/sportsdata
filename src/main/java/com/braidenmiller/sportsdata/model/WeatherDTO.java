package com.braidenmiller.sportsdata.model;

import com.braidenmiller.sportsdata.entity.PlayEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeatherDTO {
    private PlayEntity play;
    private Integer temperature;
    private String temperatureFormat;
    private String windDirection;
    private String windSpeed;
    private String precipitationInInches;
}
