package com.prongbang.sec.security.authentication;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.prongbang.sec.security.utils.SessionUtil;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        
    	handle(request, response, authentication);
        
        clearAuthenticationAttributes(request);
        
    }
	
    /**
     * Handle request and response
     * @param request
     * @param response
     * @param authentication
     * @throws IOException
     */
	private void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
		
		String targetUrl = SessionUtil.getRedirectURL(request);
		
		if(targetUrl.equals("/")) {
			
			targetUrl = determineTargetUrl(authentication);
			if (response.isCommitted()) {
				
				System.out.println("Response has already been committed. Unable to redirect to " + targetUrl);
				return;
			}
		}
		
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	/**
	 * Determine Target URL
	 * @param authentication
	 * @return String
	 */
	private String determineTargetUrl(Authentication authentication) {
		
		for (GrantedAuthority auth : authentication.getAuthorities()) {
			
			if(auth.getAuthority().equals("ROLE_DBA")) {
				
				return "/dba";
			} else if(auth.getAuthority().equals("ROLE_USER")) {
				
				return "/";
			} else if (auth.getAuthority().equals("ROLE_ADMIN")) {
				
				return "/admin";
			}
		}
		
		throw new IllegalStateException("Granted authority not found");
	}
	
	/**
	 * Clear Authentication Attributes
	 * @param request
	 */
	private void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

}
