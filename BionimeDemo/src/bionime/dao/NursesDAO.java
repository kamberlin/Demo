package bionime.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import bionime.enity.Nurses;
import bionime.enity.Station;

public class NursesDAO extends HibernateDaoSupport {
	@Autowired
	private SessionFactory sessionFactory;

	public void add(Nurses nurses) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(nurses);
		tx.commit();
		session.close();
	}

	public ArrayList<Nurses> queryAll() {
		String sql = "from Nurses";
		Session session = sessionFactory.openSession();
		Query<Nurses> query = session.createQuery(sql);
		ArrayList<Nurses> list = (ArrayList<Nurses>) query.list();
		session.close();
		return list;
	}
	public Nurses queryNurse(String employeeNo) {
		String sql = "from Nurses where employee_no=:employeeNo";
		Session session = sessionFactory.openSession();
		Query<Nurses> query = session.createQuery(sql);
		query.setParameter("employeeNo", employeeNo);
		Nurses nurse = query.getSingleResult();
		session.close();
		return nurse;
	}

	public boolean delete(String employeeNo) {
		boolean flag = false;
		String sql = " delete Nurses where employee_no=:employeeNo";
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query<Nurses> query = session.createQuery(sql);
		query.setParameter("employeeNo", employeeNo);
		int result = query.executeUpdate();
		tx.commit();
		if (result > 0) {
			flag = true;
		}
		return flag;

	}
}
