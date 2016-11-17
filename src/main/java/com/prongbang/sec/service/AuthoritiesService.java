package com.prongbang.sec.service;

import java.util.List;

import com.prongbang.sec.model.Authorities;

public interface AuthoritiesService extends AbstractService<Authorities> {

	public List<Authorities> findByUsername(String username) throws Exception;
	
}
