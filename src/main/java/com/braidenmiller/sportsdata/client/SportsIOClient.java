package com.braidenmiller.sportsdata.client;

import com.braidenmiller.sportsdata.config.SportsIOClientConfig;
import com.braidenmiller.sportsdata.model.PlayByPlay;
import com.braidenmiller.sportsdata.model.StadiumDTO;
import com.braidenmiller.sportsdata.model.TeamDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "sportsdata.io",
        url = "https://api.sportsdata.io/v3/nfl/",
        configuration = SportsIOClientConfig.class
)
public interface SportsIOClient {
    @GetMapping(path = "scores/json/Stadiums",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<StadiumDTO> getStadiums();

    @GetMapping(path = "scores/json/AllTeams",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<TeamDTO> getAllTeams();

    @GetMapping(path = "pbp/json/PlayByPlay/{season}/{week}/{teamCode}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    PlayByPlay getPlayByPlay(@PathVariable String season,
                             @PathVariable Integer week,
                             @PathVariable String teamCode);
}
