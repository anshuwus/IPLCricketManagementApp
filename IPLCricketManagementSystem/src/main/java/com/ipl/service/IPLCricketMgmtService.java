package com.ipl.service;

import java.util.List;

import com.ipl.binding.IPLPlayerForm;
import com.ipl.entity.IPLPlayer;

public interface IPLCricketMgmtService {
	
	public boolean registerPlayer(IPLPlayerForm form);//for INSERT operation
	
	public IPLPlayerForm getPlayerById(Integer id);//for SELECT operation by specific player ID
	
	public List<IPLPlayer> getDashboardData();//for SELECT operation( get all players info)

	public boolean updatePlayer(IPLPlayerForm form, Integer id);//for UPDATE operation
	
	public void deletePlayer(int playerId);//for DELETE operation

	public void playerStaticDataLoader(List<IPLPlayer> playerList);
	
}
