package com.braidenmiller.sportsdata.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "stadium")
public class StadiumEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long stadiumID;
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
