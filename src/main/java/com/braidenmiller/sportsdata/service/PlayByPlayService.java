package com.braidenmiller.sportsdata.service;

import com.braidenmiller.sportsdata.client.SportsIOClient;
import com.braidenmiller.sportsdata.entity.TeamEntity;
import com.braidenmiller.sportsdata.mappers.TeamMapper;
import com.braidenmiller.sportsdata.model.PlayByPlay;
import com.braidenmiller.sportsdata.model.TeamDTO;
import com.braidenmiller.sportsdata.repo.TeamRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PlayByPlayService {
    private final SportsIOClient sportsIOClient;
    private final GameService gameService;

    public PlayByPlay savePlayByPlay(String season, Integer week, String homeTeamCode) {
        PlayByPlay playByPlay = sportsIOClient.getPlayByPlay(season, week, homeTeamCode);
        return gameService.saveGame(playByPlay);
    }
}
