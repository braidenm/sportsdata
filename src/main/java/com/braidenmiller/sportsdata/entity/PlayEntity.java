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
@Table(name = "team")
public class PlayEntity {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "game_id")
    private GameEntity game;
    @Column(name = "date_time")
    private Date dateTime;
    private String description;
    @OneToOne(mappedBy = "play")
    private WeatherEntity weather;
    @OneToMany(mappedBy = "play")
    private List<FootballPlayerStatEntity> playerStats;
}
