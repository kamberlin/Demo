package bionime.service;

import java.util.ArrayList;

import bionime.dao.NursesDAO;
import bionime.enity.Nurses;

public class NursesService {
	private NursesDAO nursesDao;

	public void add(Nurses nurses) {
		nursesDao.add(nurses);
	}

	public NursesDAO getNursesDao() {
		return nursesDao;
	}

	public void setNursesDao(NursesDAO nursesDao) {
		this.nursesDao = nursesDao;
	}
	public ArrayList<Nurses> query(){
		return nursesDao.query();
	}
	public void delete(String employeeNo) {
		nursesDao.delete(employeeNo);
	}
}