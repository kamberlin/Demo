package bionime.service;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.query.Query;
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

	public ArrayList<Stationdetail> queryNursesOnSite(String employeeNo) {
		return stationDetailDao.queryNursesOnSite(employeeNo);
	}

	public ArrayList<Stationdetail> queryOnSiteNurses(int stationNo) {
		return stationDetailDao.queryOnSiteNurses(stationNo);
	}

	public void setStationDetailDao(StationDetailDAO stationDetailDao) {
		this.stationDetailDao = stationDetailDao;
	}

	public void add(Stationdetail stationDetail) {
		stationDetailDao.add(stationDetail);
	}

}
