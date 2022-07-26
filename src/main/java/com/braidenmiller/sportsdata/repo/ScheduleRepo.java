package com.braidenmiller.sportsdata.repo;

import com.braidenmiller.sportsdata.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepo extends JpaRepository<ScheduleEntity, Long> {

}
