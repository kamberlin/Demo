package bionime.service;

import org.springframework.transaction.annotation.Transactional;

import bionime.dao.StationDetailDAO;
import bionime.enity.Stationdetail;

public class StationDetailService {
	private StationDetailDAO stationDetailDao;

	public StationDetailDAO getStationDetailDao() {
		return stationDetailDao;
	}
	@Transactional
	public boolean deleteByStation(int stationNo) {
		return stationDetailDao.deleteByStation(stationNo);
	}
	@Transactional
	public boolean deleteByNurse(String employeeNo) {
		return stationDetailDao.deleteByNurse(employeeNo);
	}

	public void setStationDetailDao(StationDetailDAO stationDetailDao) {
		this.stationDetailDao = stationDetailDao;
	}

	public void add(Stationdetail stationDetail) {
		stationDetailDao.add(stationDetail);
	}

}
