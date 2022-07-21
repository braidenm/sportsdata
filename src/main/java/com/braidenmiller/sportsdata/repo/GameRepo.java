package com.braidenmiller.sportsdata.repo;

import com.braidenmiller.sportsdata.entity.FootballPlayerStatEntity;
import com.braidenmiller.sportsdata.entity.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepo extends JpaRepository<GameEntity, Long> {
}
