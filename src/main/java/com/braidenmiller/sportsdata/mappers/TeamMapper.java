package com.braidenmiller.sportsdata.mappers;

import com.braidenmiller.sportsdata.entity.PlayEntity;
import com.braidenmiller.sportsdata.entity.TeamEntity;
import com.braidenmiller.sportsdata.model.PlayDTO;
import com.braidenmiller.sportsdata.model.TeamDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper()
public abstract class TeamMapper {
    public static TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);

    @Mapping(target = "stadium", ignore = true)
    public abstract TeamEntity toEntity(TeamDTO teamDTO);

    @Mapping(target = "stadiumId", source = "stadium.id")
    public abstract TeamDTO fromEntity(TeamEntity team);
}
