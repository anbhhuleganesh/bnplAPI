package com.bnpl.fantasy.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnpl.fantasy.model.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

	Optional<List<Schedule>> findByScheduleTimeGreaterThan(Date localDateTime);

}
