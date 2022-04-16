package com.bnpl.fantasy.service;

import org.springframework.stereotype.Component;

import com.bnpl.fantasy.model.FantasyTeam;

@Component
public interface FantasyTeamService {

	void createFantasyTeam(FantasyTeam team);
}
