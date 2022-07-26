package com.braidenmiller.sportsdata.service;

import com.braidenmiller.sportsdata.client.SportsIOClient;
import com.braidenmiller.sportsdata.entity.TeamEntity;
import com.braidenmiller.sportsdata.mappers.ScheduleMapper;
import com.braidenmiller.sportsdata.mappers.TeamMapper;
import com.braidenmiller.sportsdata.model.ScheduleDTO;
import com.braidenmiller.sportsdata.model.TeamDTO;
import com.braidenmiller.sportsdata.repo.ScheduleRepo;
import com.braidenmiller.sportsdata.repo.TeamRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
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
public class ScheduleService {
    private final SportsIOClient sportsIOClient;
    private final ScheduleMapper scheduleMapper = ScheduleMapper.INSTANCE;
    private final ScheduleRepo scheduleRepo;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<ScheduleDTO> getSchedule(Date dateTime) {
        //TODO
        return null;
    }

    public List<ScheduleDTO> getAllFootballSchedule() {
        return scheduleRepo.findAll().stream()
                .map(scheduleMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public List<ScheduleDTO> saveAllFootballSchedule() {
        return scheduleRepo.saveAll(sportsIOClient.getAllSchedules(LocalDateTime.now().getYear()).stream()
                        .map(scheduleMapper::toEntity)
                        .collect(Collectors.toList()))
                .stream()
                .map(scheduleMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
