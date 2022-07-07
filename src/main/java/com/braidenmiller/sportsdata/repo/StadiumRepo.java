package com.braidenmiller.sportsdata.repo;

import com.braidenmiller.sportsdata.entity.StadiumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StadiumRepo extends JpaRepository<StadiumEntity, Long> {
}
