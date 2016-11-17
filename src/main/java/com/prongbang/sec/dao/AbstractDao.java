package com.prongbang.sec.dao;

import java.util.List;

public interface AbstractDao<T> {

	public int add(T entity) throws Exception;
	
	public int update(T entity) throws Exception;
	
	public int delete(T entity) throws Exception;
	
	public List<T> findAll() throws Exception;
	
	public T findById(T entity) throws Exception;
	
}
