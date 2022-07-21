package com.braidenmiller.sportsdata.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamDTO {
    @JsonProperty("TeamID")
    private Long id;
    @JsonProperty("FullName")
    private String name;
    @JsonProperty("Key")
    private String teamCode;
    @JsonProperty("StadiumID")
    private Long stadiumId;
}
