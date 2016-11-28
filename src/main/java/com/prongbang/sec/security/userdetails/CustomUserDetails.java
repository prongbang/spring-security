package com.prongbang.sec.security.userdetails;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.prongbang.sec.model.Users;

public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = -462553908752111643L;

	private Users users;
	private Collection<GrantedAuthority> grants;
	
	public CustomUserDetails(Users users, Collection<GrantedAuthority> grants) {
		
		this.users = users;
		
		this.grants = grants;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return grants;
	}

	@Override
	public String getPassword() {
		
		return users != null ? users.getPassword() : null;
	}

	@Override
	public String getUsername() {
		
		return users != null ? users.getUsername() : null;
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
		
		return users == null ? false : users.isEnabled() != null ? users.isEnabled() == 1 : false;
	}

}
