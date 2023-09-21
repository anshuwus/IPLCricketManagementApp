package com.ipl.binding;

import java.io.Serializable;

import com.ipl.entity.IPLTeam;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class IPLPlayerForm implements Serializable{
		
	private String playerName;
	
	private Integer age;
	
	private String role;
	
	private Integer matchesPlayed;
	
	private Integer runsScored;
	
	private Integer wicketsTaken;
		
	private IPLTeam team;
	
	//0-param constructor
	public IPLPlayerForm() {
		System.out.println("IPLPlayerForm :: 0-param constructor");
	}

	@Override
	public String toString() {
		return "IPLPlayerForm [playerName=" + playerName + ", age=" + age + ", role=" + role + ", matchesPlayed="
				+ matchesPlayed + ", runsScored=" + runsScored + ", wicketsTaken=" + wicketsTaken + "]";
	}

	
}
