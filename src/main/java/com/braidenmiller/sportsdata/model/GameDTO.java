package com.braidenmiller.sportsdata.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameDTO {
    @JsonProperty("GameKey")
    private Long id;
    @JsonProperty("Season")
    private Integer season;
    @JsonProperty("Week")
    private Integer week;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("DateTime")
    private LocalDateTime dateTime;
    @JsonProperty("AwayTeamID")
    private Long awayTeamId;
    @JsonProperty("HomeTeamID")
    private Long homeTeamId;
    @JsonProperty("AwayScore")
    private Integer awayTeamScore;
    @JsonProperty("HomeScore")
    private Integer homeTeamScore;
    @JsonProperty("StadiumID")
    private Long stadiumId;
    @JsonProperty("IsOver")
    private boolean isClosed;
}
