package com.prongbang.sec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prongbang.sec.dao.UsersDao;
import com.prongbang.sec.model.Users;
import com.prongbang.sec.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDao usersDao;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int add(Users entity) throws Exception {
		
		return usersDao.add(entity);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int update(Users entity) throws Exception {
		
		return usersDao.update(entity);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int delete(Users entity) throws Exception {
		
		return usersDao.delete(entity);
	}

	@Override
	public List<Users> findAll() throws Exception {
		
		return usersDao.findAll();
	}

	@Override
	public Users findById(Users entity) throws Exception {
		
		return usersDao.findById(entity);
	}

	@Override
	public Users findByUsername(String username) throws Exception {
		
		return usersDao.findByUsername(username);
	}

}
