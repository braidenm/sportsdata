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
    private boolean active;
    private String name;
    private boolean dome;
    private String city;
    private String state;
    private String geoLat;
    private String geoLong;
}
