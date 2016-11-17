package com.prongbang.sec.dao;

import java.util.List;

import com.prongbang.sec.model.Authorities;

public interface AuthoritiesDao extends AbstractDao<Authorities> {

	public List<Authorities> findByUsername(String username) throws Exception;
	
}
