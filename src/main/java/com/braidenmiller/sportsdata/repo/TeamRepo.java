package com.braidenmiller.sportsdata.repo;

import com.braidenmiller.sportsdata.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepo extends JpaRepository<TeamEntity, Long> {
    List<TeamEntity> findByTeamCode(String code);
}
