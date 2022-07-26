package com.braidenmiller.sportsdata.service;

import com.braidenmiller.sportsdata.client.SportsIOClient;
import com.braidenmiller.sportsdata.entity.StadiumEntity;
import com.braidenmiller.sportsdata.entity.TeamEntity;
import com.braidenmiller.sportsdata.mappers.StadiumMapper;
import com.braidenmiller.sportsdata.mappers.TeamMapper;
import com.braidenmiller.sportsdata.model.StadiumDTO;
import com.braidenmiller.sportsdata.model.TeamDTO;
import com.braidenmiller.sportsdata.repo.StadiumRepo;
import com.braidenmiller.sportsdata.repo.TeamRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepo teamRepo;
    private final SportsIOClient sportsIOClient;
    private final TeamMapper teamMapper = TeamMapper.INSTANCE;
    private final StadiumService stadiumService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public TeamDTO getTeam(Long id) {
        return teamRepo.findById(id)
                .map(teamMapper::fromEntity)
                .orElse(null);
    }

    public List<TeamDTO> getAllTeams() {
        return teamRepo.findAll().stream()
                .map(teamMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public List<TeamDTO> saveAllTeams() {
        return teamRepo.saveAll(sportsIOClient.getAllTeams().stream()
                        .map(teamMapper::toEntity)
                        .map(this::populateStadium)
                        .collect(Collectors.toList()))
                .stream()
                .map(teamMapper::fromEntity)
                .collect(Collectors.toList());
    }

    private <T> void printObject(List<T> obj) {
        try {
            System.out.println(objectMapper.writeValueAsString(obj));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private <T> void printObject(T obj) {
        try {
            System.out.println(objectMapper.writeValueAsString(obj));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private TeamEntity populateStadium(TeamEntity team) {
        if (team.getStadium().getId() != null) {
            team.setStadium(stadiumService.getStadiumEntity(team.getStadium().getId()));
        } else {
            team.setStadium(null);
        }
        return team;
    }

    public TeamEntity getTeamEntity(Long id) {
        return teamRepo.findById(id)
                .orElse(null);
    }

    public TeamEntity getTeamEntityByCode(String code) {
        return teamRepo.findByTeamCode(code).stream().findFirst().orElse(null);
    }

}
