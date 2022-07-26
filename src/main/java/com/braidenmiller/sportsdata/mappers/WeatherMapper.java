package com.braidenmiller.sportsdata.mappers;

import com.braidenmiller.sportsdata.entity.WeatherEntity;
import com.braidenmiller.sportsdata.model.WeatherDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface WeatherMapper {
    WeatherMapper INSTANCE = Mappers.getMapper(WeatherMapper.class);

    @Mapping(target = "play", ignore = true)
    @Mapping(target = "windSpeed", source = "currentConditions.windspeed")
    @Mapping(target = "windGust", source = "currentConditions.windgust")
    @Mapping(target = "windDirection", source = "currentConditions.winddir")
    @Mapping(target = "temperature", source = "currentConditions.temp")
    @Mapping(target = "precipitationInInches", source = "currentConditions.precip")
    @Mapping(target = "feelsLike", source = "currentConditions.feelslike")
    @Mapping(target = "id", ignore = true)
    WeatherEntity toEntity(WeatherDTO weatherDTO);

    @Mapping(target = "currentConditions.windspeed", source = "windSpeed")
    @Mapping(target = "currentConditions.windgust", source = "windGust")
    @Mapping(target = "currentConditions.winddir", source = "windDirection")
    @Mapping(target = "currentConditions.temp", source = "temperature")
    @Mapping(target = "currentConditions.precip", source = "precipitationInInches")
    @Mapping(target = "currentConditions.feelslike", source = "feelsLike")
    WeatherDTO fromEntity(WeatherEntity weather);
}
