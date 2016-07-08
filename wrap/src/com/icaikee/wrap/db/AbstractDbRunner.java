package com.icaikee.wrap.db;

import java.util.List;

public abstract class AbstractDbRunner implements DbRunner {

	@Override
	public void execute(String sql, Object... values) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public long count(String sql, Object... values) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T> List<T> find(Class<T> entityClass, String sql, Object... values) throws Exception {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public void update(Object obj) throws Exception {
		// TODO Auto-generated method stub

	}

}
