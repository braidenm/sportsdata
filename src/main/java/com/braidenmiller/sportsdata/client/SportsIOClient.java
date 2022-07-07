package com.braidenmiller.sportsdata.client;

import com.braidenmiller.sportsdata.config.SportsIOClientConfig;
import com.braidenmiller.sportsdata.model.StadiumDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(
        name = "sportsdata.io",
        url = "https://api.sportsdata.io/v3/cfb/scores/json",
        configuration = SportsIOClientConfig.class
)
public interface SportsIOClient {
    @GetMapping(path = "/Stadiums",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<StadiumDTO> getStadiums();
}
