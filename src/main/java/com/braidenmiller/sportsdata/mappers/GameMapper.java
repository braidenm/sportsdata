package com.braidenmiller.sportsdata.mappers;

import com.braidenmiller.sportsdata.entity.GameEntity;
import com.braidenmiller.sportsdata.model.GameDTO;
import com.braidenmiller.sportsdata.model.PlayByPlay;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {PlayMapper.class, DateMapper.class})
public interface GameMapper {
    GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);

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
    GameEntity toEntity(PlayByPlay playByPLay);

    @Mapping(target = "gameDetails", source = "gameEntity")
    PlayByPlay fromEntityToPlayByPlay(GameEntity gameEntity);

    @Mapping(target = "stadiumId", source = "stadium.id")
    @Mapping(target = "homeTeamId", source = "homeTeam.id")
    @Mapping(target = "awayTeamId", source = "awayTeam.id")
    GameDTO fromEntityToDTO(GameEntity gameEntity);
}
