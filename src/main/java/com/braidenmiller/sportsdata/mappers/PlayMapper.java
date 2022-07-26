package com.braidenmiller.sportsdata.mappers;

import com.braidenmiller.sportsdata.entity.PlayEntity;
import com.braidenmiller.sportsdata.model.GameDTO;
import com.braidenmiller.sportsdata.model.PlayDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {PlayStatMapper.class, WeatherMapper.class, GameMapper.class})
public interface PlayMapper {
    PlayMapper INSTANCE = Mappers.getMapper(PlayMapper.class);

    @Mapping(target = "weather", ignore = true)
    @Mapping(target = "game", ignore = true)
    @Mapping(target = "id", source = "playDTO.id")
    @Mapping(target = "dateTime", source = "playDTO.dateTime")
    PlayEntity toEntity(PlayDTO playDTO);

    @Mapping(target = "weatherDTO", source = "weather")
    PlayDTO fromEntity(PlayEntity play);
}
