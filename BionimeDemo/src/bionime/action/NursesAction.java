package bionime.action;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bionime.enity.Nurses;
import bionime.enity.NursesId;
import bionime.enity.Station;
import bionime.enity.Stationdetail;
import bionime.enity.StationdetailId;
import bionime.service.NursesService;
import bionime.service.StationDetailService;
import bionime.service.StationService;

@Controller
public class NursesAction {
	@Resource(name = "stationService")
	private StationService stationService;
	@Resource(name = "nursesService")
	private NursesService nursesService;
	@Resource(name = "stationDetailService")
	private StationDetailService stationDetailService;

	@RequestMapping("/nursesList")
	public String showList(Model m) {
		ArrayList<Nurses> nursesList = nursesService.queryAll();
		m.addAttribute("nursesList", nursesList);
		return "nursesList";
	}

	@RequestMapping("/addNurse")
	public void addNurse(Model m) {
		ArrayList<Station> stationList = stationService.queryAll();
		m.addAttribute("stationList", stationList);
	}

	@RequestMapping("/deleteNurse")
	public ModelAndView deleteNurse(@RequestParam("employeeNo") String employeeNo, Model m) {
		nursesService.delete(employeeNo);
		stationDetailService.deleteByNurse(employeeNo);
		return new ModelAndView("redirect:/nursesList", "deleteResult", true);
	}

	@RequestMapping("/viewNurse")
	public String viewNurse(@RequestParam("employeeNo") String employeeNo, Model m) {
		Nurses nurse = nursesService.queryNurse(employeeNo);
		ArrayList<Station> stationList = stationService.queryAll();
		ArrayList<Stationdetail> onSiteList = stationDetailService.queryNursesOnSite(employeeNo);
		ArrayList<Station> tempList = new ArrayList<Station>();
		if (stationList != null && stationList.size() > 0) {
			for (int i = 0; i < stationList.size(); i++) {
				Station station = stationList.get(i);
				if (onSiteList != null && onSiteList.size() > 0) {
					for (int j = 0; j < onSiteList.size(); j++) {
						Stationdetail siteDetail = onSiteList.get(j);
						if (station.getStationNo() == siteDetail.getId().getStationNo()) {
							tempList.add(station);
						}
					}
				}
			}
		}
		for (int i = 0; i < tempList.size(); i++) {
			stationList.remove(tempList.get(i));
		}
		m.addAttribute("nurse", nurse);
		m.addAttribute("stationList", stationList);
		m.addAttribute("onSiteList", onSiteList);
		return "nursesDetail";
	}

	@RequestMapping("/modifyNurse")
	public String modifyNurse(@RequestParam("employeeNo") String employeeNo,
			@RequestParam("nursesName") String nursesName, @RequestParam("oriEmployeeNo") String oriEmployeeNo,
			@RequestParam("oriNursesName") String oriNursesName,
			@RequestParam(required = false, value = "cStationList") String[] cStationList, Model m) {
		nursesService.update(employeeNo, nursesName, oriEmployeeNo, oriNursesName);
		stationDetailService.deleteByNurse(employeeNo);
		if (cStationList != null) {
			for (int i = 0; i < cStationList.length; i++) {
				String[] station = cStationList[i].split("#");
				if (station != null && station.length == 2) {
					StationdetailId stationDetailId = new StationdetailId();
					stationDetailId.setEmployeeNo(employeeNo);
					stationDetailId.setStationNo(Integer.parseInt(station[0]));
					stationDetailId.setStationName(station[1]);
					stationDetailId.setUpdateTime(new Date());
					Stationdetail stationDetail = new Stationdetail();
					stationDetail.setId(stationDetailId);
					stationDetailService.add(stationDetail);
				}
			}
		}
		m.addAttribute("modify",true);
		viewNurse(employeeNo, m);
		return "nursesDetail";
	}

	@RequestMapping("/insertNurse")
	public String insertNurse(@RequestParam("employeeNo") String employeeNo,
			@RequestParam("nursesName") String nursesName,
			@RequestParam(required = false, value = "cStationList") String[] cStationList, Model m) {
		if(nursesService.queryNurse(employeeNo)!=null) {
			m.addAttribute("error",true);
			m.addAttribute("errorMsg","員工編號"+employeeNo+" 護士已存在");
		}else {
			Nurses nurses = new Nurses();
			NursesId nursesId = new NursesId();
			nursesId.setEmployeeNo(employeeNo);
			nursesId.setNursesName(nursesName);
			nursesId.setUpdateTime(new Date());
			nurses.setId(nursesId);
			nursesService.add(nurses);
			if (cStationList != null) {
				for (int i = 0; i < cStationList.length; i++) {
					String[] station = cStationList[i].split("#");
					if (station != null && station.length == 2) {
						StationdetailId stationDetailId = new StationdetailId();
						stationDetailId.setEmployeeNo(employeeNo);
						stationDetailId.setStationNo(Integer.parseInt(station[0]));
						stationDetailId.setStationName(station[1]);
						stationDetailId.setUpdateTime(new Date());
						Stationdetail stationDetail = new Stationdetail();
						stationDetail.setId(stationDetailId);
						stationDetailService.add(stationDetail);
					}
				}
			}
			m.addAttribute("insert",true);
			addNurse(m);
		}
		return "addNurse";
	}
}
