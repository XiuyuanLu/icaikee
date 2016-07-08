package com.icaikee.wrap.db;

import java.util.List;

public interface DbRunner {

	public abstract void execute(String sql, Object... values) throws Exception;

	public abstract long count(String sql, Object... values) throws Exception;

	public abstract <T> List<T> find(Class<T> entityClass, String sql, Object... values) throws Exception;

	public abstract <T> T findUnique(Class<T> entityClass, String sql, Object... values) throws Exception;

	public abstract void insert(Object obj) throws Exception;

	public abstract void update(Object obj) throws Exception;
}
