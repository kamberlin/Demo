package bionime.service;

import java.util.ArrayList;

import bionime.dao.StationDAO;
import bionime.enity.Station;

public class StationService {
	private StationDAO stationDao;
	
	public void add(Station station) {
		stationDao.add(station);
	}
	public ArrayList<Station> queryAll(){
		return stationDao.queryAll();
	}
	public Station queryStation(int stationNo){
		return stationDao.queryStation(stationNo);
	}
	public boolean modifyStation(int stationNo,String stationName) {
		return stationDao.modifyStation(stationNo, stationName);
	}
	public StationDAO getStationDao() {
		return stationDao;
	}

	public void setStationDao(StationDAO stationDao) {
		this.stationDao = stationDao;
	}
	public boolean delete(int stationNo) {
		return stationDao.delete(stationNo);
	}
}
