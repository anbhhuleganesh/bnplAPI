package com.bnpl.fantasy.serviceImpl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bnpl.fantasy.model.Schedule;
import com.bnpl.fantasy.repository.ScheduleRepository;
import com.bnpl.fantasy.service.GameService;

@Component
public class GameServiceImpl implements GameService {

	@Autowired
	ScheduleRepository scheduleRepo;
	
	@Override
	public Optional<List<Schedule>> retrieveFutureGameIds() {
		//LocalDateTime localDateTime = LocalDateTime.now();
		//ZoneId zone = ZoneId.of("USA/Chicago");
		Date currentDate = Date.from(Instant.now());
		System.out.println(currentDate);
		return scheduleRepo.findByScheduleTimeGreaterThan(currentDate);
	}

}
