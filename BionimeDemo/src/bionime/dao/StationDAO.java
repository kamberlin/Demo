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
import bionime.enity.Stationdetail;

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
		String sql = " delete Station where station_no=:stationNo";
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query<Station> query = session.createQuery(sql);
		query.setParameter("stationNo", stationNo);
		int result = query.executeUpdate();
		tx.commit();
		if (result > 0) {
			flag = true;
		}
		return flag;

	}

	public boolean modifyStation(int stationNo, String stationName) {
		boolean flag = false;
		String sql = " update Station set station_name=:stationName where station_no=:stationNo";
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query<Station> query = session.createQuery(sql);
		query.setParameter("stationNo", stationNo);
		query.setParameter("stationName", stationName);
		int result = query.executeUpdate();
		tx.commit();
		if (result > 0) {
			flag = true;
		}
		return flag;
	}

	public ArrayList<Station> queryAll() {
		String sql = "from Station";
		Session session = sessionFactory.openSession();
		Query<Station> query = session.createQuery(sql);
		ArrayList<Station> list = (ArrayList<Station>) query.list();
		session.close();
		return list;
	}

	public Station queryStation(int stationNo) {
		String sql = "from Station where station_no=:stationNo";
		Session session = sessionFactory.openSession();
		Query<Station> query = session.createQuery(sql);
		query.setParameter("stationNo", stationNo);

		Station station = query.getSingleResult();
		session.close();
		return station;
	}

}
