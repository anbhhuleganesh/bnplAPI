package com.bnpl.fantasy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.bnpl.fantasy.model.Team;


@Component
public interface TeamService {

	List<Team> retrieveTeams();
	
	Optional<Team> retrieveTeam(int teamId);

}
