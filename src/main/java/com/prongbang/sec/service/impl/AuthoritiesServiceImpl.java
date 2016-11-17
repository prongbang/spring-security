package com.prongbang.sec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prongbang.sec.dao.AuthoritiesDao;
import com.prongbang.sec.model.Authorities;
import com.prongbang.sec.service.AuthoritiesService;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {

	@Autowired
	private AuthoritiesDao authoritiesDao;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int add(Authorities entity) throws Exception {
		
		return authoritiesDao.add(entity);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int update(Authorities entity) throws Exception {
		
		return authoritiesDao.update(entity);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int delete(Authorities entity) throws Exception {
		
		return authoritiesDao.delete(entity);
	}

	@Override
	public List<Authorities> findAll() throws Exception {
		
		return authoritiesDao.findAll();
	}

	@Override
	public Authorities findById(Authorities entity) throws Exception {
		
		return authoritiesDao.findById(entity);
	}

	@Override
	public List<Authorities> findByUsername(String username) throws Exception {

		return authoritiesDao.findByUsername(username);
	}

}
