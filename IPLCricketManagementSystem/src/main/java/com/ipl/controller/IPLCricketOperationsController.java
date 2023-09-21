package com.ipl.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ipl.MyCollection;
import com.ipl.binding.IPLPlayerForm;
import com.ipl.entity.IPLPlayer;
import com.ipl.entity.IPLTeam;
import com.ipl.repository.IPLTeamRepository;
import com.ipl.service.IPLCricketMgmtService;
import com.ipl.utils.IPLDataLoader;

@Controller
public class IPLCricketOperationsController {

	@Autowired
	private IPLCricketMgmtService service;
	@Autowired
	private IPLTeamRepository teamRepo;
	
	@GetMapping("/")
	public String indexPage(Model model) {
		return "index";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		System.out.println("PostController.dashboard()");
		//send all players info to UI
		List<IPLPlayer> list = service.getDashboardData();
		//for static data loading in DB is list is empty
		if(list.isEmpty())
			playerDataLoader();
		model.addAttribute("playerList", list);
		return "dashboardPage";
	}
	
	@GetMapping("/addPlayer")
	public String registerPlayer(@ModelAttribute("player") IPLPlayerForm form, Model model) {
		dynamicCommonUI(model);
		//for launching form page
		return "addPlayerPage";
	}
	
	@PostMapping("/addPlayer")
	public String registerPlayerProcess(@ModelAttribute("player") IPLPlayerForm form,RedirectAttributes attr) {
		System.out.println("IPLCricketOperationsController.registerPlayerProcess()");
		if(null!=form) {
			boolean status = service.registerPlayer(form);
			if(status)
				return "redirect:dashboard";
			else
				attr.addFlashAttribute("errMsg","Player not added");
		}//if
		return "redirect:addPlayer";
	}
	
	@GetMapping("/edit")
	public String editPlayer(@ModelAttribute("player")IPLPlayerForm form, @RequestParam(name="playerId",required=false)Integer playerId , Model model) {
		System.out.println("IPLCricketOperationsController.editPlayer()"+form+"....."+playerId);

		if(null!=playerId) {
			//for editForm binding
			IPLPlayerForm player = service.getPlayerById(playerId);
			//dropdown data
			dynamicCommonUI(model);
			model.addAttribute("player", player);
			model.addAttribute("playerId", playerId);
		}
		return "editPlayerPage";
	}
	
	@PostMapping("/edit")
	public String updatePlayer(@ModelAttribute("player")IPLPlayerForm form,
			                  RedirectAttributes attr,
			                  @RequestParam(name="playerId",required=false)Integer playerId) {
		System.out.println("IPLCricketOperationsController.updatePost()"+form+"....."+playerId);
		//for update player
		if(null!=playerId) {
			boolean status = service.updatePlayer(form, playerId);
			if(status)
				attr.addFlashAttribute("succMsg","Player Updated");
			else
				attr.addFlashAttribute("errMsg","Player not uploaded");
		}
		return "redirect:edit";
	}
	
	@GetMapping("/team")
	public String getAllTeamInfo(Model model) throws Exception {
		List<IPLTeam> list = teamRepo.findAll();
		if(list.isEmpty()) {
			dataLoader();
		}
		model.addAttribute("teamList", list);
		return "teamInfoPage";
	}
	
	@GetMapping("/delete")
	public String deletePlayer(@RequestParam("playerId")Integer playerId) {
		System.out.println("IPLCricketOperationsController.deletePlayer()"+playerId);
		service.deletePlayer(playerId);
		return "redirect:dashboard";
	}
	
	//helper method for static data loading
	private void dataLoader() {
		IPLDataLoader dataLoader=new IPLDataLoader();
		List<IPLTeam> loadStaticData = dataLoader.loadStaticData();
		teamRepo.saveAll(loadStaticData);
	}
	
	//helper method for static data loading
	private void playerDataLoader() {
		IPLDataLoader dataLoader=new IPLDataLoader();
		dataLoader();
		List<IPLTeam> teamList = teamRepo.findAll();
		List<IPLPlayer> playerList = dataLoader.loadIPLPlayer();
		for(IPLTeam team : teamList) {
			for(IPLPlayer player : playerList) {
				if(player.getTeam()==null) {
				    player.setTeam(team);
					break;
				}//if
			}//inner for loop
		}//outer for loop
		
		service.playerStaticDataLoader(playerList);
	}
	
	//A common method which sends data to create Dynamic DropDown at UI
		private void dynamicCommonUI(Model model) {
			List<Object[]> list = teamRepo.getTeamIdAndTeamName();
			if(list.isEmpty()) {
				dataLoader();
				list=teamRepo.getTeamIdAndTeamName();
			}
			Map<Long, String> map = MyCollection.convertListToMap(list);
			// map.forEach((o1,o2) -> System.out.println(o1+" _ "+o2));
			model.addAttribute("map", map);
		}
	
}
