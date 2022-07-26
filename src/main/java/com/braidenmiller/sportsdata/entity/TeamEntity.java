package com.braidenmiller.sportsdata.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "team")
public class TeamEntity {
    @Id
    private Long id;
    private String name;
    private String teamCode;
    @ManyToOne
    @JoinColumn(name="stadium_id")
    private StadiumEntity stadium;
}
