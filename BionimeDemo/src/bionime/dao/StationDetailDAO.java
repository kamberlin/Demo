package bionime.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import bionime.enity.Nurses;
import bionime.enity.Stationdetail;
import bionime.enity.StationdetailId;

public class StationDetailDAO extends HibernateDaoSupport {
	@Autowired
	private SessionFactory sessionFactory;

	public void add(Stationdetail stationDetail) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(stationDetail);
		tx.commit();
		session.close();
	}

	public boolean deleteByStation(int stationNo) {
		boolean flag = false;
		Stationdetail stationdetail = new Stationdetail();
		StationdetailId stationdetailId = new StationdetailId();
		stationdetailId.setStationNo(stationNo);
		stationdetail.setId(stationdetailId);
		// System.out.println("stationNoDAO="+stationNo);
		String sql = " delete from Stationdetail where station_no=:stationNo";
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query<Stationdetail> query = session.createQuery(sql);
		query.setParameter("stationNo", stationNo);
		int result = query.executeUpdate();
		System.out.println("result=" + result);
		tx.commit();
		if (result > 0) {
			flag = true;
		}
		session.close();
		return flag;

	}

	public boolean deleteByNurse(String employeeNo) {
		boolean flag = false;
		String sql = " delete Stationdetail where employee_no=:employeeNo";
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query<Stationdetail> query = session.createQuery(sql);
		query.setParameter("employeeNo", employeeNo);
		int result = query.executeUpdate();
		tx.commit();
		if (result > 0) {
			flag = true;
		}
		return flag;

	}
}
