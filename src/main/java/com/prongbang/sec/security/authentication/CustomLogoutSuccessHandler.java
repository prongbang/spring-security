package com.prongbang.sec.security.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.prongbang.sec.security.utils.SessionUtil;

@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

		if (authentication != null && authentication.getDetails() != null) {
			
			SessionUtil.invalidate(request);
		}

		redirectStrategy.sendRedirect(request, response, "/login?logout");

	}

}
