package com.braidenmiller.sportsdata.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "football_player_stat")
public class FootballPlayerStatEntity {
    @Id
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamEntity team;
    @ManyToOne
    @JoinColumn(name = "play_id")
    private PlayEntity play;
    private String position;
    private Integer passingYards;
    private Integer passingTouchdowns;
    private Integer passingInterceptions;
    private Integer rushingYards;
    private Integer rushingTouchdowns;
    private Integer receivingYards;
    private Integer receivingTouchdowns;
    private Integer puntReturnYards;
    private Integer puntReturnTouchdowns;
    private Integer kickReturnYards;
    private Integer kickReturnTouchdowns;
    private Integer puntYards;
    private Integer fieldGoalAttempted;
    private Integer fieldGoalMade;
    private Integer interceptionYardReturn;
    private Integer interceptionTouchdowns;

    private Integer soloTackles;
    private Integer assistedTackles;
    private Integer sacks;
    private Integer passesDefended;
    private Integer fumblesRecovered;
    private Integer fumbleReturnTouchdown;
    private Integer quarterbackHurries;
    private Integer fumbles;
    private Integer fumblesLost;
}
