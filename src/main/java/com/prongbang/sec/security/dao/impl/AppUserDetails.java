package com.prongbang.sec.security.dao.impl;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.prongbang.sec.model.Users;

public class AppUserDetails implements UserDetails {

	private static final long serialVersionUID = -462553908752111643L;

	private Users users;
	private Collection<GrantedAuthority> grants;
	
	public AppUserDetails(Users users, Collection<GrantedAuthority> grants) {
		
		this.users = users;
		
		this.grants = grants;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return grants;
	}

	@Override
	public String getPassword() {
		
		return users.getPassword();
	}

	@Override
	public String getUsername() {
		
		return users.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		//return users.isEnabled() != null ? users.isEnabled() == false ? false : true : false;
		return users == null ? false : users.isEnabled() != null ? users.isEnabled() == 1 : false;
	}

}
