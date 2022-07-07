package com.braidenmiller.sportsdata.controller;

import com.braidenmiller.sportsdata.entity.StadiumEntity;
import com.braidenmiller.sportsdata.model.StadiumDTO;
import com.braidenmiller.sportsdata.service.StadiumService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StadiumController {
    private final StadiumService stadiumService;

    public StadiumController(StadiumService stadiumService) {
        this.stadiumService = stadiumService;
    }

    @GetMapping("/stadiums")
    public List<StadiumDTO> getAllStadiums() {
        return stadiumService.getAllStadiums();
    }

    @PostMapping(value = "/stadiums", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StadiumDTO> populateStadiums() {
        return stadiumService.populateAllStadiums();
    }
}

