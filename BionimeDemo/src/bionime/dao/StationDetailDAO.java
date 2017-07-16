package bionime.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import bionime.enity.Nurses;
import bionime.enity.Stationdetail;

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
	public boolean delete(int stationNo) {
		boolean flag = false;
		String sql = " delete StationDetail where station_no=?";
		Session session = sessionFactory.openSession();
		Query<Stationdetail> query = session.createQuery(sql);
		query.setParameter(1, stationNo);
		int result = query.executeUpdate();
		if (result > 0) {
			flag = true;
		}
		return flag;

	}
}
