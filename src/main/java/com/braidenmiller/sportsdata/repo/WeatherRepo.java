package com.braidenmiller.sportsdata.repo;

import com.braidenmiller.sportsdata.entity.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepo extends JpaRepository<WeatherEntity, Long> {
}
