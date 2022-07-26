package com.braidenmiller.sportsdata.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "weather_stat")
public class WeatherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "play_id", referencedColumnName = "id")
    private PlayEntity play;
    private String temperature;
    private String feelsLike;
    private String windDirection;
    private String windSpeed;
    private String windGust;
    @Column(name = "precipitation")
    private String precipitationInInches;
    private String latitude;
    private String longitude;


}
