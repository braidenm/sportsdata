package com.braidenmiller.sportsdata.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayDTO {
    @JsonProperty("PlayID")
    private Long id;
    @JsonProperty("PlayTime")
    private Date dateTime;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("PlayStats")
    private List<FootballPlayerStatDTO> playerStats;
}
