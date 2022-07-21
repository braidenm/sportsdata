package com.braidenmiller.sportsdata.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayByPlay {
    @JsonProperty("Score")
    private GameDTO gameDetails;
    @JsonProperty("Plays")
    private List<PlayDTO> plays;
}
