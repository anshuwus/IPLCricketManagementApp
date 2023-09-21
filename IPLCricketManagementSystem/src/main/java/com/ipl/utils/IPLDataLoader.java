package com.ipl.utils;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ipl.entity.IPLPlayer;
import com.ipl.entity.IPLTeam;
import com.ipl.repository.IPLTeamRepository;


public class IPLDataLoader{

	
	public List<IPLPlayer> loadIPLPlayer() {
	
		//insert static data in IPLPlayer table
		IPLPlayer p1=new IPLPlayer();
		p1.setPlayerName("Virat Kohli");
		p1.setAge(45);
		p1.setMatchesPlayed(5);
		p1.setRole("captain");
		p1.setWicketsTaken(1);
		p1.setRunsScored(90);
		
		IPLPlayer p2=new IPLPlayer();
		p2.setPlayerName("Rohit Sharma");
		p2.setAge(42);
		p2.setMatchesPlayed(6);
		p2.setRole("all-rounder");
		p2.setWicketsTaken(3);
		p2.setRunsScored(78);
	
		IPLPlayer p3=new IPLPlayer();
		p3.setPlayerName(" Sanju Samson");
		p3.setAge(37);
		p3.setMatchesPlayed(3);
		p3.setRole("wicket-keeper");
		p3.setWicketsTaken(4);
		p3.setRunsScored(58);
	
		IPLPlayer p4=new IPLPlayer();
		p4.setPlayerName("Kuldeep Yadav");
		p4.setAge(39);
		p4.setMatchesPlayed(5);
		p4.setRole("bowler");
		p4.setWicketsTaken(2);
		p4.setRunsScored(66);
		p4.setTeam(null);
	
		IPLPlayer p5=new IPLPlayer();
		p5.setPlayerName("MS Dhoni");
		p5.setAge(33);
		p5.setMatchesPlayed(3);
		p5.setRole("captain");
		p5.setWicketsTaken(3);
		p5.setRunsScored(92);
	
		IPLPlayer p6=new IPLPlayer();
		p6.setPlayerName("Dwayne Bravo");
		p6.setAge(41);
		p6.setMatchesPlayed(4);
		p6.setRole("player");
		p6.setWicketsTaken(2);
		p6.setRunsScored(40);
	
		IPLPlayer p7=new IPLPlayer();
		p7.setPlayerName("Tushar Deshpande");
		p7.setAge(36);
		p7.setMatchesPlayed(3);
		p7.setRole("wicket-keeper");
		p7.setWicketsTaken(4);
		p7.setRunsScored(82);
	
		IPLPlayer p8=new IPLPlayer();
		p8.setPlayerName("Deepak Chahar");
		p8.setAge(32);
		p8.setMatchesPlayed(4);
		p8.setRole("Batsman");
		p8.setWicketsTaken(3);
		p8.setRunsScored(56);
		
		List<IPLPlayer> asList = Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8);	
		return asList;
		
	}
	
	public List<IPLTeam> loadStaticData(){
		//insert static data in IPLTeam table
				IPLTeam t1=new IPLTeam();
				t1.setTeamName("Mumbai Indians");
				t1.setCaptain("Rohit Sharma");
				t1.setOwnerName("Nita Ambani");
				t1.setTotalMatchesPlayed(17);
				t1.setTotalMatchesWon(11);
				
				IPLTeam t2=new IPLTeam();
				t2.setTeamName("Chennai Super Kings");
				t2.setCaptain("MS Dhoni");
				t2.setOwnerName("N Srinivasan");
				t2.setTotalMatchesPlayed(10);
				t2.setTotalMatchesWon(5);
				
				IPLTeam t3=new IPLTeam();
				t3.setTeamName("Royal Challengers Bangalore");
				t3.setCaptain("Faf du Plessis");
				t3.setOwnerName("Prathmesh Mishra ");
				t3.setTotalMatchesPlayed(7);
				t3.setTotalMatchesWon(5);
				
				IPLTeam t4=new IPLTeam();
				t4.setTeamName("Delhi Capitals");
				t4.setCaptain("David Warner");
				t4.setOwnerName("Kiran Kumar Grandhi");
				t4.setTotalMatchesPlayed(7);
				t4.setTotalMatchesWon(5);
				
				IPLTeam t5=new IPLTeam();
				t5.setTeamName("Kolkata Knight Riders");
				t5.setCaptain("	MS Dhoni");
				t5.setOwnerName("Shah Rukh Khan");
				t5.setTotalMatchesPlayed(7);
				t5.setTotalMatchesWon(5);
				
				IPLTeam t6=new IPLTeam();
				t6.setTeamName("Rajasthan Royals");
				t6.setCaptain("Sanju Samson");
				t6.setOwnerName("Manoj Badale");
				t6.setTotalMatchesPlayed(7);
				t6.setTotalMatchesWon(5);

				IPLTeam t7=new IPLTeam();
				t7.setTeamName("Punjab Kings");
				t7.setCaptain("Shikhar Dhawan");
				t7.setOwnerName("Mohit Burman ");
				t7.setTotalMatchesPlayed(10);
				t7.setTotalMatchesWon(7);

				IPLTeam t8=new IPLTeam();
				t8.setTeamName("Sunrisers Hyderabad");
				t8.setCaptain("Aiden Markrami");
				t8.setOwnerName("Kalanithi Maran");
				t8.setTotalMatchesPlayed(10);
				t8.setTotalMatchesWon(5);
			
				IPLTeam t9=new IPLTeam();
				t9.setTeamName("Lucknow Super Giants");
				t9.setCaptain("KL Rahul");
				t9.setOwnerName("Sanjiv Goenka");
				t9.setTotalMatchesPlayed(10);
				t9.setTotalMatchesWon(3);
				
				IPLTeam t10=new IPLTeam();
				t10.setTeamName("Gujarat Titans");
				t10.setCaptain("Hardik Pandya");
				t10.setOwnerName("Siddharth Patel ");
				t10.setTotalMatchesPlayed(7);
				t10.setTotalMatchesWon(5);
				List<IPLTeam> asList = Arrays.asList(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10);

				return asList;
	}

}
