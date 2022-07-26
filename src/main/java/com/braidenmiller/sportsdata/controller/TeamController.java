package com.braidenmiller.sportsdata.controller;

import com.braidenmiller.sportsdata.model.TeamDTO;
import com.braidenmiller.sportsdata.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @GetMapping("/teams")
    public List<TeamDTO> getAllStadiums() {
        return teamService.getAllTeams();
    }

    @PostMapping(value = "/teams", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TeamDTO> populateTeams() {
        return teamService.saveAllTeams();
    }
}