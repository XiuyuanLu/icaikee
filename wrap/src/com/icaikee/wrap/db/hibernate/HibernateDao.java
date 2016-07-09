package com.icaikee.wrap.db.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.icaikee.wrap.db.DbRunner;

public class HibernateDao extends HibernateTemplate implements DbRunner {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void execute(String sql, Object... values) throws Exception {
		execute(sql, values);
	}

	@Override
	public long count(String sql, Object... values) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> find(Class<T> entityClass, String sql, Object... values) throws Exception {
		return (List<T>) find(sql, values);
	}

	@Override
	public <T> T findUnique(Class<T> entityClass, String sql, Object... values) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Object obj) throws Exception {
		// TODO Auto-generated method stub

	}

}
