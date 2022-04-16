package com.bnpl.fantasy.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bnpl.fantasy.model.Player;
import com.bnpl.fantasy.model.Schedule;
import com.bnpl.fantasy.repository.PlayerRepository;
import com.bnpl.fantasy.repository.ScheduleRepository;
import com.bnpl.fantasy.service.PlayerService;

@Component
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	PlayerRepository playerRepo;
	
	@Autowired
	ScheduleRepository scheduleRepo;
	
	@Override
	public List<Player> retrieveTeamPlayers(int teamId) {
		return playerRepo.findByTeamId(teamId);
	}
	
	@Override
	public List<Player> retrievePlayersByRole(String role) {
		return playerRepo.findByRole(role);
	}

	@Override
	public List<Player> retrievePlayersByGameId(int gameId) {
		List<Player> players = new ArrayList<>();
		Optional<Schedule> schedule = scheduleRepo.findById(gameId);
		if(schedule != null) {
			players.addAll(this.retrieveTeamPlayers(schedule.get().getTeam1()));
			players.addAll(this.retrieveTeamPlayers(schedule.get().getTeam2()));
		}
		return players;
	}
	
}
