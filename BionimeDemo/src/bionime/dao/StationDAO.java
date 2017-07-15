package bionime.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		Transaction tx = session.beginTransaction();
		session.save(station);
		tx.commit();
		session.close();
	}

	public void delete(String stationName) {

	}

	public ArrayList<String> query() {
		return null;
	}
	
}
