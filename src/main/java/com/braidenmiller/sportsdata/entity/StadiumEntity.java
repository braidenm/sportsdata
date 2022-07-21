package com.braidenmiller.sportsdata.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "stadium")
public class StadiumEntity {
    @Id
    private Long id;
    @Column(name = "active")
    private boolean active;
    @Column(name = "name")
    private String name;
    @Column(name = "dome")
    private boolean dome;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "geo_lat")
    private String geoLat;
    @Column(name = "geo_long")
    private String geoLong;
}
