package com.bnpl.fantasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnpl.fantasy.model.FantasyTeam;

@Repository
public interface FantasyTeamRepository extends JpaRepository<FantasyTeam, Integer> {

}
