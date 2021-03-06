package bionime.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bionime.enity.Station;
import bionime.enity.Stationdetail;
import bionime.enity.StationdetailId;
import bionime.service.NursesService;
import bionime.service.StationDetailService;
import bionime.service.StationService;

@Controller
public class StationAction {
	@Resource(name = "stationService")
	private StationService stationService;
	@Resource(name = "nursesService")
	private NursesService nursesService;
	@Resource(name = "stationDetailService")
	private StationDetailService stationDetailService;

	@RequestMapping("/addStation")
	public String foward() {
		return "addStation";
	}

	@RequestMapping("/insertStation")
	public String insert(@RequestParam(required = false, name = "stationName") String stationName, Model model) {
		Station station = new Station();
		station.setStationName(stationName);
		station.setUpdateTime(new Date());
		stationService.add(station);
		model.addAttribute("result", true);
		return "addStation";
	}

	@RequestMapping("/deleteStation")
	public String delete(@RequestParam("stationNo") int stationNo, Model model) {
		boolean  flag = stationDetailService.deleteByStation(stationNo);
		flag = stationService.delete(stationNo);

		if (flag) {
			model.addAttribute("result", true);
		}
		return "addStation";
	}
	@RequestMapping("/modifyStation")
	public String modify(@RequestParam("stationNo") int stationNo,@RequestParam("stationName") String stationName, Model model) {
		stationService.modifyStation(stationNo, stationName);
		model.addAttribute("result",true);
		//待調整
		Station station = stationService.queryStation(stationNo);
		List<Stationdetail> stationDetailList = stationDetailService.queryOnSiteNurses(stationNo);
		model.addAttribute("station",station);
		model.addAttribute("stationDetailList",stationDetailList);
		return "stationDetail";
	}

	@RequestMapping("/viewStation")
	public String view(@RequestParam("stationNo") int stationNo, Model model) {
		Station station = stationService.queryStation(stationNo);
		List<Stationdetail> stationDetailList = stationDetailService.queryOnSiteNurses(stationNo);
		model.addAttribute("station",station);
		model.addAttribute("stationDetailList",stationDetailList);
		return "stationDetail";
	}

	@RequestMapping("/stationList")
	public String showList(Model model) {
		ArrayList<Station> stationList = stationService.queryAll();
		model.addAttribute("stationList", stationList);
		return "stationList";
	}
}
