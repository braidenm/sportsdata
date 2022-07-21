package com.braidenmiller.sportsdata.service;

import com.braidenmiller.sportsdata.client.SportsIOClient;
import com.braidenmiller.sportsdata.entity.GameEntity;
import com.braidenmiller.sportsdata.entity.PlayEntity;
import com.braidenmiller.sportsdata.mappers.GameMapper;
import com.braidenmiller.sportsdata.mappers.StadiumMapper;
import com.braidenmiller.sportsdata.model.GameDTO;
import com.braidenmiller.sportsdata.model.PlayByPlay;
import com.braidenmiller.sportsdata.model.StadiumDTO;
import com.braidenmiller.sportsdata.repo.GameRepo;
import com.braidenmiller.sportsdata.repo.StadiumRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class GameService {
    private final SportsIOClient sportsIOClient;
    private final GameRepo gameRepo;
    private final TeamService teamService;
    private final StadiumService stadiumService;
    private final GameMapper gameMapper = GameMapper.INSTANCE;


    public PlayByPlay saveGame(PlayByPlay playByPlay) {
        GameEntity gameEntity = gameMapper.toEntity(playByPlay);
        populateSubObjects(gameEntity, playByPlay);
        return null;
    }

    private void populateSubObjects(GameEntity gameEntity, PlayByPlay playByPlay) {
        GameDTO gameDTO = playByPlay.getGameDetails();
        gameEntity.setStadium(stadiumService.getStadiumEntity(gameDTO.getStadiumId()));
        gameEntity.setAwayTeam(teamService.getTeamEntity(gameDTO.getAwayTeamId()));
        gameEntity.setHomeTeam(teamService.getTeamEntity(gameDTO.getHomeTeamId()));
        populatePlayStatTeam(gameEntity.getPlays());
    }

    private void populatePlayStatTeam(List<PlayEntity> plays) {
        plays.forEach(play ->
                play.getPlayerStats().forEach(playerStatEntity ->
                        playerStatEntity.setTeam(teamService.getTeamEntityByCode(playerStatEntity.getTeam().getTeamCode()))
                )
        );
    }
}
