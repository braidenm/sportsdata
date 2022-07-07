package com.braidenmiller.sportsdata.mappers;

import com.braidenmiller.sportsdata.entity.StadiumEntity;
import com.braidenmiller.sportsdata.model.StadiumDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface StadiumMapper {
    StadiumMapper INSTANCE = Mappers.getMapper(StadiumMapper.class);

    StadiumEntity toEntity(StadiumDTO stadiumDTO);

    StadiumDTO fromEntity(StadiumEntity stadiumEntity);
}
