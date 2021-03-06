package com.braidenmiller.sportsdata.controller;

import com.braidenmiller.sportsdata.model.PlayByPlay;
import com.braidenmiller.sportsdata.model.StadiumDTO;
import com.braidenmiller.sportsdata.service.PlayByPlayService;
import com.braidenmiller.sportsdata.service.StadiumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlayByPlayController {
    private final PlayByPlayService playByPlayService;

    @PostMapping(value = "/playByPlay/{season}/{week}/{teamCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PlayByPlay savePlayByPlay(@PathVariable String season, @PathVariable String teamCode, @PathVariable Integer week) {
        return playByPlayService.savePlayByPlay(season, week, teamCode);
    }

    @GetMapping(value = "/playByPlay", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PlayByPlay> getAllPlayByPlays() {
        return playByPlayService.getAllPlayByPlays();
    }
}

