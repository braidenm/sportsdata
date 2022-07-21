package com.braidenmiller.sportsdata.repo;

import com.braidenmiller.sportsdata.entity.FootballPlayerStatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballPlayerStatRepo extends JpaRepository<FootballPlayerStatEntity, Long> {
}
