package com.ipl.entity;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="IPL_TEAM_INFO")
@Setter
@Getter
public class IPLTeam implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer teamId;
	
	@Column(length=30)
	private String teamName;
	
	@Column(length=30)
	private String captain;
	
	@Column(length=30)
	private String OwnerName;
	
	private Integer totalMatchesPlayed;
	
	private Integer totalMatchesWon;
	
	private Integer totalMatchesLost;
	
	@CreationTimestamp
	private LocalDate createdOn;
		
	//0-param constructor
	public IPLTeam() {
		System.out.println("IPLTeam:: 0-param constructor");
	}
	
	//toString()
	@Override
	public String toString() {
		return "IPLTeam [teamId=" + teamId + ", teamName=" + teamName + ", captain=" + captain + ", OwnerName="
				+ OwnerName + ", totalMatchesPlayed=" + totalMatchesPlayed + ", totalMatchesWon=" + totalMatchesWon
				+ ", totalMatchesLost=" + totalMatchesLost + "]";
	}
}
