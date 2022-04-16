package com.bnpl.fantasy.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Team {

	@Id
	private int teamId;
	
	private String teamName;
	
	//private List<Player> players;
	
	/*
	public Team(int teamId, String teamName, List<Player> players) {
		this.teamId = teamId;
		this.teamName = teamName;
		this.players = players;
	}*/
	
	public Team() {
		
	}
	
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


}
