package com.bnpl.fantasy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.bnpl.fantasy.model.Schedule;

@Component
public interface GameService {

	Optional<List<Schedule>> retrieveFutureGameIds();
}
