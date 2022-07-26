package com.braidenmiller.sportsdata.mappers;

import com.braidenmiller.sportsdata.entity.ScheduleEntity;
import com.braidenmiller.sportsdata.entity.StadiumEntity;
import com.braidenmiller.sportsdata.model.ScheduleDTO;
import com.braidenmiller.sportsdata.model.StadiumDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface ScheduleMapper {
    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);

    @Mapping(target = "stadium.id", source = "stadiumId")
    @Mapping(target = "homeTeam.id", source = "homeTeamId")
    @Mapping(target = "awayTeam.id", source = "awayTeamId")
    ScheduleEntity toEntity(ScheduleDTO scheduleDTO);

    @Mapping(target = "stadiumId", source = "stadium.id")
    @Mapping(target = "homeTeamId", source = "homeTeam.id")
    @Mapping(target = "awayTeamId", source = "awayTeam.id")
    ScheduleDTO fromEntity(ScheduleEntity scheduleEntity);
}
