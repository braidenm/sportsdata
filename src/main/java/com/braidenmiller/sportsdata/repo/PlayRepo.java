package com.braidenmiller.sportsdata.repo;

import com.braidenmiller.sportsdata.entity.GameEntity;
import com.braidenmiller.sportsdata.entity.PlayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayRepo extends JpaRepository<PlayEntity, Long> {
}
