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
@Table(name = "team")
public class WeatherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "play_id", referencedColumnName = "id")
    private PlayEntity play;
    private Integer temperature;
    @Column(name = "temperature_format")
    private String temperatureFormat;
    @Column(name = "wind_direction")
    private String windDirection;
    @Column(name = "wind_speed")
    private String windSpeed;
    @Column(name = "precipitation")
    private String precipitationInInches;


}
