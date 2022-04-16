package com.bnpl.fantasy.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnpl.fantasy.model.FantasyTeam;
import com.bnpl.fantasy.model.Player;
import com.bnpl.fantasy.model.Schedule;
import com.bnpl.fantasy.model.Team;
import com.bnpl.fantasy.model.User;
import com.bnpl.fantasy.repository.TeamRepository;
import com.bnpl.fantasy.service.FantasyTeamService;
import com.bnpl.fantasy.service.GameService;
import com.bnpl.fantasy.service.PlayerService;
import com.bnpl.fantasy.service.TeamService;
import com.bnpl.fantasy.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/fantasy")
public class FantasyController {

	@Autowired
	TeamService teamService;
	
	@Autowired
	PlayerService playerService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	FantasyTeamService fantasyTeamService;
	
	@Autowired
	GameService gameService;
	
	@GetMapping("/teams")
	public List<Team> getTeams() {
		return teamService.retrieveTeams();
	}
	
	@GetMapping("/team/{teamId}")
	public Optional<Team> getTeam(@PathVariable("teamId") int teamId) {
		return teamService.retrieveTeam(teamId);
	}
	
	@GetMapping("/team/{teamId}/players")
	public List<Player> getTeamPlayers(@PathVariable("teamId") int teamId) {
		return playerService.retrieveTeamPlayers(teamId);
	}
	
	@GetMapping("/players/{role}")
	public List<Player> getPlayersByRole(@PathVariable("role") String role) {
		return playerService.retrievePlayersByRole(role);
	}
	
	@GetMapping("/players/game/{gameId}")
	public List<Player> getPlayersByGameId(@PathVariable("gameId") int gameId) {
		return playerService.retrievePlayersByGameId(gameId);
	}
	
	@PostMapping("/create/user")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		try {
			userService.createUser(user);
			return ResponseEntity.status(HttpStatus.OK).body(user);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(user);
		}
	}
	
	@PostMapping("/validate/user")
	public Optional<User> validateuser(@RequestBody User user) {
		return userService.validateUser(user);
	}
	
	@PostMapping("/submit/team")
	public ResponseEntity<FantasyTeam> createFantasyTeam(@RequestBody FantasyTeam team) {
		try {
			fantasyTeamService.createFantasyTeam(team);
			return ResponseEntity.status(HttpStatus.OK).body(team);
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(team);
		}
	}
	
	@GetMapping("/games/future")
	public Optional<List<Schedule>> getFutureGameIds() {
		return gameService.retrieveFutureGameIds();
	}
	
	
	/*
	@GetMapping("/teams")
	public List<Team> getTeams() {
		return Arrays.asList(
		  new Team(1, "CICA Legends", 
				    Arrays.asList(new Player("Damu","Reddy","All-Rounder",null,null),
				    		      new Player("Nagnath","Naga","Bowler",null,null)		
				    )
				  ),
		  new Team(2, "ARV Archers", 
				    Arrays.asList(new Player("Naga","Damela","Bowler",null,null),
    		                      new Player("Shekar","Reddy","Bowler",null,null)		
                    )
                  ),
		  new Team(3, "Techie brains", 
				    Arrays.asList(new Player("Ganesh","Anbhule","All-Rounder",null,null),
		                      new Player("Vivek","Gangadhar","Batsman",null,null)		
                    )
                  ),
		  new Team(4, "GNR Lions", 
				    Arrays.asList(new Player("Sharath","Rojanalla","Batsman",null,null),
		                      new Player("Ayushkant","Rout","Batsman",null,null)		
                    )
                  ),
		  new Team(5, "GPT Shers", 
				    Arrays.asList(new Player("Shahab","Qadari","All-Rounder",null,null),
		                      new Player("Hafeez","Shekh","All-Rounder",null,null)		
                    )
                  )
		  );
	}
	
	@GetMapping("/team/{teamId}")
	public Team getTeam(@PathVariable("teamId") int teamId) {
		List<Team> teams = this.getTeams();
		Team team = 
				teams
				.stream()
				.filter(t -> t.getTeamId() == teamId)
				.findAny()
				.orElse(null);
		return team;
	}
	
	@GetMapping("teams/role/{role}")
	public List<Player> getPlayersWithSpecificRole(@PathVariable("role") String role) {
		List<Team> teams = this.getTeams();
		Predicate<Team> condition = new Predicate<Team>() {
			
			@Override
			public boolean test(Team t) {
				List<Player> players = t.getPlayers();
				for(Player player: players) {
					if(role.equals(player.getRole())) {
						return true;
					}
				}
				return false;
			}
		};
		List<Player> players = new ArrayList<Player>();
		teams
			.stream()
			.filter(condition)
			.forEach(team -> {
				List<Player> pls = team.getPlayers();
				pls
				  .stream()
				  .forEach(pl -> {
						  if(role.equals(pl.getRole()))
						    players.add(pl);
						  }
				  );
				
			});
		
		return players;
	}
	
	@GetMapping("teams/role1/{role}")
	public List<Player> getPlayersWithSpecificRole1(@PathVariable("role") String role) {
		List<Team> teams = this.getTeams();
		
		List<Player> players = teams
			.stream()
			.flatMap(team -> team.getPlayers().stream())
			.filter(player -> role.equals(player.getRole()))
			.collect(Collectors.toList());
		
		return players;
	}
	*/
}
