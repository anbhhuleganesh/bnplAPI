package com.bnpl.fantasy.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bnpl.fantasy.model.FantasyTeam;
import com.bnpl.fantasy.repository.FantasyTeamRepository;
import com.bnpl.fantasy.service.FantasyTeamService;

@Component
public class FantasyTeamServiceImpl implements FantasyTeamService {

	@Autowired
	FantasyTeamRepository fantasyTeamRepo;
	
	@Override
	public void createFantasyTeam(FantasyTeam team) {
		fantasyTeamRepo.save(team);
	}

	
}
