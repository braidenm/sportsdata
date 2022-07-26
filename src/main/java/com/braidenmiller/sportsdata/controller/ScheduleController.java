package com.braidenmiller.sportsdata.controller;

import com.braidenmiller.sportsdata.model.ScheduleDTO;
import com.braidenmiller.sportsdata.model.StadiumDTO;
import com.braidenmiller.sportsdata.service.ScheduleService;
import com.braidenmiller.sportsdata.service.StadiumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @GetMapping("/schedules")
    public List<ScheduleDTO> getSchedule() {
        return scheduleService.getAllFootballSchedule();
    }

    @PostMapping(value = "/schedules", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ScheduleDTO> populateSchedule() {
        return scheduleService.saveAllFootballSchedule();
    }
}

