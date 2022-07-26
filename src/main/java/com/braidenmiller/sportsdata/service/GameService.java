package com.braidenmiller.sportsdata.service;

import com.braidenmiller.sportsdata.client.SportsIOClient;
import com.braidenmiller.sportsdata.entity.GameEntity;
import com.braidenmiller.sportsdata.entity.PlayEntity;
import com.braidenmiller.sportsdata.entity.WeatherEntity;
import com.braidenmiller.sportsdata.mappers.GameMapper;
import com.braidenmiller.sportsdata.mappers.WeatherMapper;
import com.braidenmiller.sportsdata.model.GameDTO;
import com.braidenmiller.sportsdata.model.PlayByPlay;
import com.braidenmiller.sportsdata.model.WeatherDTO;
import com.braidenmiller.sportsdata.repo.GameRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class GameService {
    private final SportsIOClient sportsIOClient;
    private final GameRepo gameRepo;
    private final TeamService teamService;
    private final StadiumService stadiumService;
    private final WeatherService weatherService;
    private final GameMapper gameMapper = GameMapper.INSTANCE;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    public PlayByPlay saveGame(PlayByPlay playByPlay) {
        GameEntity gameEntity = gameMapper.toEntity(playByPlay);
        populateSubObjects(gameEntity, playByPlay);
        return gameMapper.fromEntityToPlayByPlay(gameRepo.save(gameEntity));
    }

    public List<PlayByPlay> getAllGamesAsPlayByPlay() {
        return gameRepo.findAll().stream()
                .map(gameMapper::fromEntityToPlayByPlay)
                .collect(Collectors.toList());
    }

    private void populateSubObjects(GameEntity gameEntity, PlayByPlay playByPlay) {
        GameDTO gameDTO = playByPlay.getGameDetails();
        gameEntity.setStadium(stadiumService.getStadiumEntity(gameDTO.getStadiumId()));
        gameEntity.setAwayTeam(teamService.getTeamEntity(gameDTO.getAwayTeamId()));
        gameEntity.setHomeTeam(teamService.getTeamEntity(gameDTO.getHomeTeamId()));
        populatePlayStatTeam(gameEntity);
    }

    private void populatePlayStatTeam(GameEntity gameEntity) {
        gameEntity.getPlays().forEach(play -> {
                    play.setGame(gameEntity);
                    String latLong = gameEntity.getStadium().getGeoLat() +", " + gameEntity.getStadium().getGeoLong();
                    setWeather(play, latLong);
                    play.getPlayerStats().forEach(playerStatEntity ->
                            playerStatEntity.setTeam(teamService.getTeamEntityByCode(playerStatEntity.getTeam().getTeamCode()))
                    );
                }
        );
    }

    private void setWeather(PlayEntity play, String latLong) {
        WeatherDTO weather = weatherService.saveWeather(latLong, sdf.format(play.getDateTime()));
        WeatherEntity weatherEntity = WeatherMapper.INSTANCE.toEntity(weather);
        weatherEntity.setPlay(play);
        play.setWeather(weatherEntity);
    }
}
