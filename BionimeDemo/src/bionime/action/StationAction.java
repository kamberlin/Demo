package bionime.action;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bionime.enity.Station;
import bionime.service.StationService;

@Controller
public class StationAction {
	@Resource(name = "stationService")
	private StationService service;

	@RequestMapping("/addStation")
	public String foward() {
		return "addStation";
	}

	@RequestMapping("/insertStation")
	public String insert(@RequestParam(required=false,name="stationName") String stationName, Model model) {
		Station station = new Station();
		station.setStationName(stationName);
		station.setUpdateTime(new Date());
		service.add(station);
		model.addAttribute("result", true);
		return "addStation";
	}

	@RequestMapping("/stationList")
	public String showList(Model model) {
		ArrayList<Station> stationList = service.query();
		model.addAttribute("stationList", stationList);
		return "stationList";
	}
}
