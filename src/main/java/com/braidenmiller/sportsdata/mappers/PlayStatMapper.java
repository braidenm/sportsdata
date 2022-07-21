package com.braidenmiller.sportsdata.mappers;

import com.braidenmiller.sportsdata.entity.FootballPlayerStatEntity;
import com.braidenmiller.sportsdata.entity.PlayEntity;
import com.braidenmiller.sportsdata.model.FootballPlayerStatDTO;
import com.braidenmiller.sportsdata.model.PlayDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper()
public abstract class PlayStatMapper {
    public static PlayStatMapper INSTANCE = Mappers.getMapper(PlayStatMapper.class);

    @Mapping(target = "team.teamCode", source = "statDTO.teamCode")
    @Mapping(target = "position", ignore = true)
    @Mapping(target = "play", ignore = true)
    public abstract FootballPlayerStatEntity toEntity(FootballPlayerStatDTO statDTO);

    @Mapping(target = "teamCode", source = "team.teamCode")
    @Mapping(target = "playId", source = "play.id")
    public abstract FootballPlayerStatDTO fromEntity(FootballPlayerStatEntity playerStatEntity);
}
