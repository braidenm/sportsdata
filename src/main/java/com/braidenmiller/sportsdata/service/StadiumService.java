package com.braidenmiller.sportsdata.service;

import com.braidenmiller.sportsdata.client.SportsIOClient;
import com.braidenmiller.sportsdata.entity.StadiumEntity;
import com.braidenmiller.sportsdata.mappers.StadiumMapper;
import com.braidenmiller.sportsdata.model.StadiumDTO;
import com.braidenmiller.sportsdata.repo.StadiumRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class StadiumService {
    private final StadiumRepo stadiumRepo;
    private final SportsIOClient sportsIOClient;
    private final StadiumMapper stadiumMapper = StadiumMapper.INSTANCE;

    StadiumService(StadiumRepo stadiumRepo,
                   SportsIOClient sportsIOClient) {
        this.stadiumRepo = stadiumRepo;
        this.sportsIOClient = sportsIOClient;
    }

    public List<StadiumDTO> getAllStadiums() {
        return stadiumRepo.findAll().stream()
                .map(stadiumMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public StadiumDTO getStadium(Long id) {
        return stadiumRepo.findById(id)
                .map(stadiumMapper::fromEntity)
                .orElse(null);
    }

    public StadiumEntity getStadiumEntity(Long id) {
        return stadiumRepo.findById(id)
                .orElse(null);
    }

    public List<StadiumDTO> populateAllStadiums() {
        return stadiumRepo.saveAll(sportsIOClient.getStadiums().stream()
                        .map(stadiumMapper::toEntity)
                        .collect(Collectors.toList())).stream()
                .map(stadiumMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
