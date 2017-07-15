package bionime.action;

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
	public String insert(@RequestParam("stationName") String stationName, Model model) {
		Station station = new Station();
		station.setStationName(stationName);
		service.add(station);
		model.addAttribute("result", "success");
		return "addStation";
	}
}
