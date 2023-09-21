package com.ipl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ipl.entity.IPLTeam;

public interface IPLTeamRepository extends JpaRepository<IPLTeam, Integer>{
	
	@Query("SELECT teamId,teamName FROM IPLTeam")
	List<Object[]> getTeamIdAndTeamName();
}
