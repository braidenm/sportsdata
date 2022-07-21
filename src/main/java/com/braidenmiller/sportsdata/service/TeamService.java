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

    public TeamDTO getTeam(Long id) {
        return teamRepo.findById(id)
                .map(teamMapper::fromEntity)
                .orElse(null);
    }

    public TeamEntity getTeamEntity(Long id) {
        return teamRepo.findById(id)
                .orElse(null);
    }

    public TeamEntity getTeamEntityByCode(String code) {
        return teamRepo.findByTeamCode(code).stream().findFirst().orElse(null);
    }

}
