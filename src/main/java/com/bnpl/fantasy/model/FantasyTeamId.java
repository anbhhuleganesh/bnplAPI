package com.bnpl.fantasy.model;

import java.io.Serializable;

public class FantasyTeamId implements Serializable {

	private int userId;
	private int gameId;
	
	public FantasyTeamId() {
		
	}
	public FantasyTeamId(int userId, int gameId) {
		super();
		this.userId = userId;
		this.gameId = gameId;
	}
	
	
}
