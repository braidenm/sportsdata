package com.braidenmiller.sportsdata.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "game")
public class GameEntity {
    @Id
    private Long id;
    private Integer season;
    private Integer week;
    private String status;
    private Date dateTime;
    @ManyToOne
    @JoinColumn(name = "away_team_id")
    private TeamEntity awayTeam;
    @ManyToOne
    @JoinColumn(name = "home_team_id")
    private TeamEntity homeTeam;
    private Integer awayTeamScore;
    private Integer homeTeamScore;
    @ManyToOne
    @JoinColumn(name = "stadium_id")
    private StadiumEntity stadium;
    private boolean isClosed;
    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PlayEntity> plays;
}
