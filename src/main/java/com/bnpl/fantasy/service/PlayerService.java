package com.bnpl.fantasy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.bnpl.fantasy.model.Player;

@Component
public interface PlayerService {
	List<Player> retrieveTeamPlayers(int teamId);
	List<Player> retrievePlayersByRole(String role);
	List<Player> retrievePlayersByGameId(int gameId);

}
