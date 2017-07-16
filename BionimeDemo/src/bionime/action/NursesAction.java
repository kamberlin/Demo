package bionime.action;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bionime.enity.Station;
import bionime.service.StationService;

@Controller
public class NursesAction {
	@Resource(name = "stationService")
	private StationService service;

	@RequestMapping("/addNurse")
	public void addNurses(Model m) {
		ArrayList<Station> stationList = service.query();
		m.addAttribute("stationList", stationList);
	}

	@RequestMapping("/insertNurse")
	public String insertNurse(@RequestParam(required=false,value="cList") String[] cList, Model m) {
		if(cList!=null) {
			System.out.println(cList.length);
		}
		return "addNurse";
	}
}
