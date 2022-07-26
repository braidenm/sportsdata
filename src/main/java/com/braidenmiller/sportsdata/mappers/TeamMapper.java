package com.braidenmiller.sportsdata.mappers;

import com.braidenmiller.sportsdata.entity.TeamEntity;
import com.braidenmiller.sportsdata.model.TeamDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface TeamMapper {
    TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);

    @Mapping(target = "stadium.id", source = "stadiumId")
    TeamEntity toEntity(TeamDTO teamDTO);

    @Mapping(target = "stadiumId", source = "stadium.id")
    TeamDTO fromEntity(TeamEntity team);
}
