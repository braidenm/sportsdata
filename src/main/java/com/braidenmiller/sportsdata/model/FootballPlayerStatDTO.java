package com.braidenmiller.sportsdata.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FootballPlayerStatDTO {
    @JsonProperty("PlayStatID")
    private Long id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Team")
    private Long teamCode;

    @JsonProperty("PlayID")
    private Long playId;

//    @JsonProperty("GameKey")
//    private String position;

    @JsonProperty("PassingYards")
    private Integer passingYards;

    @JsonProperty("PassingTouchdowns")
    private Integer passingTouchdowns;

    @JsonProperty("PassingInterceptions")
    private Integer passingInterceptions;

    @JsonProperty("RushingYards")
    private Integer rushingYards;

    @JsonProperty("RushingTouchdowns")
    private Integer rushingTouchdowns;

    @JsonProperty("ReceivingYards")
    private Integer receivingYards;

    @JsonProperty("ReceivingTouchdowns")
    private Integer receivingTouchdowns;

    @JsonProperty("PuntReturnYards")
    private Integer puntReturnYards;

    @JsonProperty("PuntReturnTouchdowns")
    private Integer puntReturnTouchdowns;

    @JsonProperty("KickReturnYards")
    private Integer kickReturnYards;

    @JsonProperty("KickReturnTouchdowns")
    private Integer kickReturnTouchdowns;

    @JsonProperty("PuntYards")
    private Integer puntYards;

    @JsonProperty("FieldGoalsAttempted")
    private Integer fieldGoalAttempt;

    @JsonProperty("FieldGoalsMade")
    private Integer fieldGoalMade;

    @JsonProperty("InterceptionReturnYards")
    private Integer interceptionYardReturn;

    @JsonProperty("InterceptionReturnTouchdowns")
    private Integer interceptionTouchdown;

    @JsonProperty("SoloTackles")
    private Integer soloTackles;

    @JsonProperty("AssistedTackles")
    private Integer assistedTackles;
}
