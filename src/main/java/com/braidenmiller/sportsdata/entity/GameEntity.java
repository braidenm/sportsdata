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
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "game")
public class GameEntity {
    @Id
    private Long id;
    private Integer season;
    private Integer week;
    private String status;
    @Column(name = "date_time")
    private Date dateTime;
    @Column(name = "away_team")
    private String awayTeamName;
    @Column(name = "home_team")
    private String homeTeamName;
    @ManyToOne
    @JoinColumn(name = "away_team_id")
    private TeamEntity awayTeam;
    @ManyToOne
    @JoinColumn(name = "home_team_id")
    private TeamEntity homeTeam;
    @Column(name = "away_team_score")
    private Integer awayTeamScore;
    @Column(name = "home_team_score")
    private Integer homeTeamScore;
    @ManyToOne
    @JoinColumn(name = "stadium_id")
    private StadiumEntity stadium;
    @Column(name = "is_closed")
    private boolean isClosed;
    @OneToMany(mappedBy = "game")
    private List<PlayEntity> plays;
}
