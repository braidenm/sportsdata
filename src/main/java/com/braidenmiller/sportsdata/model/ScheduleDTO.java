package com.braidenmiller.sportsdata.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScheduleDTO {
    @JsonProperty("GameKey")
    private Long gameId;
    @JsonProperty("GlobalAwayTeamID")
    private Integer awayTeamId;
    @JsonProperty("GlobalHomeTeamID")
    private Integer homeTeamId;
    @JsonProperty("StadiumID")
    private Integer stadiumId;
    @JsonProperty("Date")
    private LocalDateTime dateTime;
    private String sport;
}
