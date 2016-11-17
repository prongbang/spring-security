package com.prongbang.sec.service;

import java.util.List;

public interface AbstractService<T> {

	public int add(T entity) throws Exception;
	
	public int update(T entity) throws Exception;
	
	public int delete(T entity) throws Exception;
	
	public List<T> findAll() throws Exception;
	
	public T findById(T entity) throws Exception;
	
}
