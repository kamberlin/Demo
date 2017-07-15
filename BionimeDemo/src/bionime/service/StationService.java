package bionime.service;

import bionime.dao.StationDAO;
import bionime.enity.Station;

public class StationService {
	private StationDAO stationDao;
	
	public void add(Station station) {
		stationDao.add(station);
	}

	public StationDAO getStationDao() {
		return stationDao;
	}

	public void setStationDao(StationDAO stationDao) {
		this.stationDao = stationDao;
	}
	
}
