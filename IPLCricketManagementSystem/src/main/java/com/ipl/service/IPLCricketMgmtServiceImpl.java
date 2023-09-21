package com.ipl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipl.binding.IPLPlayerForm;
import com.ipl.entity.IPLPlayer;
import com.ipl.repository.IPLPlayerRepository;
import com.ipl.repository.IPLTeamRepository;

@Service
public class IPLCricketMgmtServiceImpl implements IPLCricketMgmtService{

	@Autowired
	private IPLPlayerRepository playerRepo;

	@Autowired
	private IPLTeamRepository teamRepo;
	
	@Override
	public boolean registerPlayer(IPLPlayerForm form) {
		boolean status=false;
		//for save IPLPlayer object
		if(null!=form) {
			IPLPlayer entity=new IPLPlayer();
		    //copy binding class object to entity class object 
			BeanUtils.copyProperties(form, entity);
			playerRepo.save(entity);
			status=true;
		}
		return status;
	}

	@Override
	public IPLPlayerForm getPlayerById(Integer id) {
		//create binding class object to capture data from entity
		IPLPlayerForm form=new IPLPlayerForm();
		if(null!=id) {
			Optional<IPLPlayer> opt = playerRepo.findById(id);
			if(opt.isPresent()) {
				IPLPlayer entity = opt.get();
				//copy entity class data to binding object
				BeanUtils.copyProperties(entity, form);
			}
		}
		return form;
	}

	@Override
	public List<IPLPlayer> getDashboardData() {
		List<IPLPlayer> list = playerRepo.findAll();
		return list;
	}

	@Override
	public boolean updatePlayer(IPLPlayerForm form, Integer id) {
		boolean status=false;	
		System.out.println("IPLCricketMgmtServiceImpl.updatePlayer()"+form);
		if(null!=id) {
			Optional<IPLPlayer> opt = playerRepo.findById(id);
			if(opt.isPresent()) {
				IPLPlayer entity = opt.get();
				//copy entity class data to binding object
				BeanUtils.copyProperties(form, entity);
				playerRepo.save(entity);
				status=true;
			}
		}
		return status;
	}

	@Override
	public void deletePlayer(int playerId) {
		playerRepo.deleteById(playerId);
		//return false;
	}

	@Override
	public void playerStaticDataLoader(List<IPLPlayer> playerList) {
		playerRepo.saveAll(playerList);
		
	}

	
}
