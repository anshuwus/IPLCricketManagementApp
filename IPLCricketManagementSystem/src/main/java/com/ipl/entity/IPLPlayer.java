package com.ipl.entity;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="IPL_PLAYER_INFO")
@Setter
@Getter
public class IPLPlayer implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer playerId;
	
	@Column(length = 30)
	private String playerName;
	
	private Integer age;
	
	@Column(length=20)
	private String role;
	
	private Integer matchesPlayed;
	
	private Integer runsScored;
	
	private Integer wicketsTaken;
		
	@CreationTimestamp
	private LocalDate createdOn;
	
	@UpdateTimestamp
	private LocalDate updatedOn;
	
	//Association mapping (many players belong to one team)
	@ManyToOne(targetEntity = IPLTeam.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id",referencedColumnName ="teamId")//for FK column cfg
	private IPLTeam team;
	
	//0-param constructor
	public IPLPlayer() {
		System.out.println("IPLPlayer :: 0-param constructor");
	}

	//toString()
	@Override
	public String toString() {
		return "IPLPlayer [playerId=" + playerId + ", playerName=" + playerName + ", age=" + age + ", role=" + role
				+ ", matchesPlayed=" + matchesPlayed + ", runsScored=" + runsScored + ", wicketsTaken=" + wicketsTaken
				+ "]";
	}
}
