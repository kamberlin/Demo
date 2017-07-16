package bionime.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import bionime.enity.Station;

public class StationDAO extends HibernateDaoSupport {
	@Autowired
	private SessionFactory sessionFactory;

	public StationDAO() {

	}

	public StationDAO(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	public void add(Station station) {
		Session session = sessionFactory.openSession();
		// Transaction tx = session.beginTransaction();
		session.save(station);
		// tx.commit();
		session.close();
	}

	public boolean delete(int stationNo) {
		boolean flag = false;
		String sql = " delete Station where station_no=?";
		Session session = sessionFactory.openSession();
		Query<Station> query = session.createQuery(sql);
		query.setParameter(1, stationNo);
		int result = query.executeUpdate();
		if (result > 0) {
			flag = true;
		}
		return flag;

	}

	public ArrayList<Station> query() {
		String sql = "from Station";
		Session session = sessionFactory.openSession();
		Query<Station> query = session.createQuery(sql);
		ArrayList<Station> list = (ArrayList<Station>) query.list();
		session.close();
		return list;
	}

	public ArrayList<Station> queryNursesOnSite(String employeeNo) {
		String sql = "from Stationdetail where employee_no=?";
		Session session = sessionFactory.openSession();
		Query<Station> query = session.createQuery(sql);
		query.setParameter(1, employeeNo);
		ArrayList<Station> list = (ArrayList<Station>) query.list();
		session.close();
		return list;
	}

}
