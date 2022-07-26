package com.braidenmiller.sportsdata.service;

import com.braidenmiller.sportsdata.client.SportsIOClient;
import com.braidenmiller.sportsdata.client.WeatherClient;
import com.braidenmiller.sportsdata.mappers.ScheduleMapper;
import com.braidenmiller.sportsdata.mappers.WeatherMapper;
import com.braidenmiller.sportsdata.model.ScheduleDTO;
import com.braidenmiller.sportsdata.model.WeatherDTO;
import com.braidenmiller.sportsdata.repo.ScheduleRepo;
import com.braidenmiller.sportsdata.repo.WeatherRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherClient weatherClient;
    private final WeatherMapper weatherMapper = WeatherMapper.INSTANCE;
    private final WeatherRepo weatherRepo;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<WeatherDTO> getAllWeather() {
        return weatherRepo.findAll().stream()
                .map(weatherMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public WeatherDTO saveWeather(String latLong, String localDateTime) {
        return weatherMapper.fromEntity(
                weatherRepo.save(
                        weatherMapper.toEntity(
                                weatherClient.getWeather(latLong, localDateTime)
                        )
                )
        );
    }
}
