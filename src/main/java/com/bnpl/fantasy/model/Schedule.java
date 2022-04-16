package com.bnpl.fantasy.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Schedule {
	
	@Id
	private int gameId;
	private int team1;
	private int team2;
	private Date scheduleTime;
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public int getTeam1() {
		return team1;
	}
	public void setTeam1(int team1) {
		this.team1 = team1;
	}
	public int getTeam2() {
		return team2;
	}
	public void setTeam2(int team2) {
		this.team2 = team2;
	}
	public Date getScheduleTime() {
		return scheduleTime;
	}
	public void setScheduleTime(Date scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
	
	

}
