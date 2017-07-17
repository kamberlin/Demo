package bionime.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import bionime.enity.Nurses;
import bionime.enity.Station;
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

	public void updateStation(String stationName, String oriSataionName) {
		String sql = "update Stationdetail set station_name=:station_name where station_name=:ostation_name";
		Session session = sessionFactory.openSession();
		Query<Stationdetail> query = session.createQuery(sql);
		query.setParameter("stationName", stationName);
		query.setParameter("oriSataionName", oriSataionName);
		query.executeUpdate();
	}

	public void updateNurse(int employeeNo, String nurseName, int oriEmployeeNo, String oriNurseName) {
		String sql = "update Stationdetail set employee_no=:employee_no and nurse_name=:nurseName where nurseName=:oriNurse_name and employeeNo=:oriEmployee";
		Session session = sessionFactory.openSession();
		Query<Stationdetail> query = session.createQuery(sql);
		 query.setParameter("employeeNo", employeeNo);
		 query.setParameter("nurseName", nurseName);
		 query.setParameter("oriEmployeeNo", oriEmployeeNo);
		query.setParameter("oriNurseName", oriNurseName);
		query.executeUpdate();
	}

	public ArrayList<Stationdetail> queryNursesOnSite(String employeeNo) {
		String sql = "from Stationdetail where employee_no=:employeeNo";
		Session session = sessionFactory.openSession();
		Query<Stationdetail> query = session.createQuery(sql);
		query.setParameter("employeeNo", employeeNo);
		ArrayList<Stationdetail> list = (ArrayList<Stationdetail>) query.list();
		session.close();
		return list;
	}

	public ArrayList<Stationdetail> queryOnSiteNurses(int stationNo) {
		String sql = "from Stationdetail where station_no=:stationNo ";
		Session session = sessionFactory.openSession();
		Query<Stationdetail> query = session.createQuery(sql);
		query.setParameter("stationNo", stationNo);
		ArrayList<Stationdetail> list = (ArrayList<Stationdetail>) query.list();
		session.close();
		return list;
	}

}
