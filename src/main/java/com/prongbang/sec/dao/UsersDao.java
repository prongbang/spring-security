package com.prongbang.sec.dao;

import com.prongbang.sec.model.Users;

public interface UsersDao extends AbstractDao<Users> {

	public Users findByUsername(String username) throws Exception;
	
}
