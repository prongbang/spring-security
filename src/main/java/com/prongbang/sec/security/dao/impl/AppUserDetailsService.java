package com.prongbang.sec.security.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.prongbang.sec.model.Authorities;
import com.prongbang.sec.model.Users;
import com.prongbang.sec.service.AuthoritiesService;
import com.prongbang.sec.service.UsersService;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersService usersService;

	@Autowired
	private AuthoritiesService authoritiesService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users users = new Users();
		
		List<Authorities> authoritiesList = new ArrayList<Authorities>();

		try {
			
			users = usersService.findByUsername(username);
			
			if (users == null) {

				System.out.println(username + " not found");
				
			} else {
				
				authoritiesList = authoritiesService.findByUsername(username);

			}
			
			Authorities auth = new Authorities();
			auth.setUsername("prongbang");
			auth.setAuthority("ROLE_ADMIN");
			
//			System.out.println(authoritiesService.add(auth));
			
		} catch (Exception e) {

			e.printStackTrace();
		}

		return buildUserForAuthentication(users, authoritiesList);
	}

	/**
	 * Build user for authentication
	 * @param users
	 * @param authoritiesList
	 * @return UserDetails
	 */
	private UserDetails buildUserForAuthentication(Users users, List<Authorities> authoritiesList) {

		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		if(authoritiesList != null) {
			
			for (Authorities authoritie : authoritiesList) {
				
				authorities.add(new SimpleGrantedAuthority(authoritie.getAuthority()));
			}
		}

		return new AppUserDetails(users, authorities);
	}
}
