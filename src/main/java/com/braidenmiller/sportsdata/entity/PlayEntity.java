package com.braidenmiller.sportsdata.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "play")
public class PlayEntity {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "game_id")
    private GameEntity game;
    private Date dateTime;
    private String description;
    @OneToOne(mappedBy = "play", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private WeatherEntity weather;
    @OneToMany(mappedBy = "play", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<FootballPlayerStatEntity> playerStats;
}
