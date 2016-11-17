package com.prongbang.sec.service;

import com.prongbang.sec.model.Users;

public interface UsersService extends AbstractService<Users> {

	public Users findByUsername(String username) throws Exception;
	
}
