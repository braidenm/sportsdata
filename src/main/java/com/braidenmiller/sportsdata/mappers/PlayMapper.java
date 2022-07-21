package com.braidenmiller.sportsdata.mappers;

import com.braidenmiller.sportsdata.entity.PlayEntity;
import com.braidenmiller.sportsdata.model.PlayDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {PlayStatMapper.class})
public abstract class PlayMapper {
    public static PlayMapper INSTANCE = Mappers.getMapper(PlayMapper.class);

    @Mapping(target = "weather", ignore = true)
    @Mapping(target = "game", ignore = true)
    public abstract PlayEntity toEntity(PlayDTO playDTO);

    public abstract PlayDTO fromEntity(PlayEntity play);
}
