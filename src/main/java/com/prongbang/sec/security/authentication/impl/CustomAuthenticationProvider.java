package com.prongbang.sec.security.authentication.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.prongbang.sec.security.service.impl.CustomUserDetailsService;
import com.prongbang.sec.utils.HashingUtil;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName() == null ? "" : authentication.getName();
		String password = authentication.getCredentials().toString() == null ? "" : authentication.getCredentials().toString();

		UserDetails principal = customUserDetailsService.loadUserByUsername(username); 

		String passwordEncode = HashingUtil.sha256(password);
		
		if(principal == null) {
			
			throw new BadCredentialsException("Username not found.");
		}

		if (username.equals(principal.getUsername()) && passwordEncode.equals(principal.getPassword())) {

			Collection<? extends GrantedAuthority> authorities = principal.getAuthorities();
			
			return new UsernamePasswordAuthenticationToken(principal, passwordEncode, authorities);
			
		} else {
			
			return null;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {

		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
