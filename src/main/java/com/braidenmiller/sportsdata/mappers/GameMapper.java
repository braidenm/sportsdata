package com.braidenmiller.sportsdata.mappers;

import com.braidenmiller.sportsdata.entity.GameEntity;
import com.braidenmiller.sportsdata.entity.PlayEntity;
import com.braidenmiller.sportsdata.entity.StadiumEntity;
import com.braidenmiller.sportsdata.model.GameDTO;
import com.braidenmiller.sportsdata.model.PlayByPlay;
import com.braidenmiller.sportsdata.model.StadiumDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {PlayMapper.class, DateMapper.class})
public abstract class GameMapper {
    public static GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);

    @Mapping(target = "week", source = "gameDetails.week")
    @Mapping(target = "status", source = "gameDetails.status")
    @Mapping(target = "season", source = "gameDetails.season")
    @Mapping(target = "id", source = "gameDetails.id")
    @Mapping(target = "homeTeamScore", source = "gameDetails.homeTeamScore")
    @Mapping(target = "dateTime", source = "gameDetails.dateTime")
    @Mapping(target = "closed", source = "gameDetails.closed")
    @Mapping(target = "awayTeamScore", source = "gameDetails.awayTeamScore")
    @Mapping(target = "stadium", ignore = true)
    @Mapping(target = "plays", source = "plays")
    @Mapping(target = "homeTeam", ignore = true)
    @Mapping(target = "awayTeam", ignore = true)
    public abstract GameEntity toEntity(PlayByPlay playByPLay);

    @Mapping(target = "gameDetails", ignore = true)
    public abstract PlayByPlay fromEntity(GameEntity gameEntity, List<PlayEntity> plays);
}
