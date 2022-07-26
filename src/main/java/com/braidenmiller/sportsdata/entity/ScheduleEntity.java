package com.braidenmiller.sportsdata.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "schedule")
public class ScheduleEntity {
    @Id
    private Integer gameId;
    @ManyToOne
    @JoinColumn(name = "away_team_id")
    private TeamEntity awayTeam;
    @ManyToOne
    @JoinColumn(name = "home_team_id")
    private TeamEntity homeTeam;
    @ManyToOne
    @JoinColumn(name = "stadium_id")
    private StadiumEntity stadium;
    private Date dateTime;
    private String sport;
}
