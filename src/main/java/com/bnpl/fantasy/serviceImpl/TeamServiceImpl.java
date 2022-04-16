package com.bnpl.fantasy.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.bnpl.fantasy.model.Team;
import com.bnpl.fantasy.model.User;
import com.bnpl.fantasy.repository.TeamRepository;
import com.bnpl.fantasy.service.TeamService;
import com.bnpl.fantasy.service.UserService;

@Component
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamRepository teamRepo;;
	
	@Autowired
	private Logger logger;
	
	@Value("${rdsSchema}")
	private static String schema;
	
	
	@Override
	public List<Team> retrieveTeams() {
		List<Team> teams = new ArrayList<>();
		teamRepo.findAll().forEach(teams :: add);
		
		return teams;
	}
	
	@Override
	public Optional<Team> retrieveTeam(int teamId) {
		return teamRepo.findById(teamId);
	}
	
	
}
