package com.icaikee.wrap.db.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class HibernateDao extends HibernateTemplate {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> find(Class<T> entityClass, String queryString, Object... values) {
		return (List<T>) find(queryString, values);
	}

	@SuppressWarnings("unchecked")
	public <T> T findUnique(Class<T> entityClass, String queryString, Object... values) {
		return (T) findUnique(queryString, values);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findByPage(Class<T> entityClass, int page, int size, String queryString, Object... values) {
		return (List<T>) findByPage(page, size, queryString, values);
	}

	public List<?> findByLimit(int limit, String queryString, Object... values) {
		return findByPage(1, limit, queryString, values);
	}

	public List<?> findByPage(final int page, final int size, final String queryString, final Object... values) {
		return executeWithNativeSession(new HibernateCallback<List<?>>() {
			@Override
			public List<?> doInHibernate(Session session) throws HibernateException {
				Query queryObject = session.createQuery(queryString);
				prepareQuery(queryObject);
				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						queryObject.setParameter(i, values[i]);
					}
				}

				if (page > 0 && size > 0) {
					queryObject.setFirstResult((page - 1) * size);
					queryObject.setMaxResults(size);
				}
				return queryObject.list();
			}

		});
	}

	public Object findUnique(final String queryString, final Object... values) {
		return executeWithNativeSession(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				Query queryObject = session.createQuery(queryString);
				prepareQuery(queryObject);
				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						queryObject.setParameter(i, values[i]);
					}
				}
				try {
					return queryObject.uniqueResult();
				} catch (NonUniqueResultException e) {
					String error = "Not unique: " + queryString + "!";
					for (Object object : values) {
						error += object.toString() + " ";
					}
					logger.error(error);
					return queryObject.list().get(0);
				}
			}
		});
	}
}
