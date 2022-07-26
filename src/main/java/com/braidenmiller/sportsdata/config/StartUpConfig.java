package com.braidenmiller.sportsdata.config;

import com.braidenmiller.sportsdata.service.ScheduleService;
import com.braidenmiller.sportsdata.service.StadiumService;
import com.braidenmiller.sportsdata.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Profile("!test")
public class StartUpConfig {
    private final ScheduleService scheduleService;
    private final TeamService teamService;
    private final StadiumService stadiumService;

    @EventListener(ApplicationReadyEvent.class)
    public void seedData() {
        stadiumService.populateAllStadiums();
        teamService.saveAllTeams();
//        scheduleService.saveAllFootballSchedule();
    }
}
