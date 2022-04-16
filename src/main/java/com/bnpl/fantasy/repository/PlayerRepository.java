package com.bnpl.fantasy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnpl.fantasy.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

	List<Player> findByTeamId(int teamId);
	List<Player> findByRole(String role);
	
}
