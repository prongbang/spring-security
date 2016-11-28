package com.prongbang.sec.security.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;  
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;  
import org.springframework.security.core.session.SessionRegistry;  
import org.springframework.security.web.PortResolverImpl;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;  
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class SessionUtil {  
	
	public static final String SPRING_SECURITY_SAVED_REQUEST_KEY = "SPRING_SECURITY_SAVED_REQUEST";
	
	@Autowired
	private SessionRegistry sessionRegistry;

	/**
	 * Expire User Sessions
	 * @param username
	 */
	public void expireUserSessions(String username) {
		
       for (Object principal : sessionRegistry.getAllPrincipals()) {
    	   
           if (principal instanceof User) {
        	   
               UserDetails userDetails = (UserDetails) principal;
               if (userDetails.getUsername().equals(username)) {
            	   
                   for (SessionInformation information : sessionRegistry.getAllSessions(userDetails, true)) {
                       
                	   information.expireNow();
                   }
               }
           }
       }
	}
	
	/**
	 * Save Request Original URL After Session Timeout
	 * @param request
	 */
	public static void saveRequest(HttpServletRequest request) {
		
		SavedRequest savedRequest = new DefaultSavedRequest(request, new PortResolverImpl());
        HttpSession session = request.getSession();
        
        if(session != null){
        	
        	session.setAttribute(SessionUtil.SPRING_SECURITY_SAVED_REQUEST_KEY, savedRequest);
        }
	}
	
	/**
	 * Get Redirect URL
	 * @param request
	 * @return String
	 */
	public static String getRedirectURL(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		
        if (session != null) {
        	
            SavedRequest savedRequest = (SavedRequest) session.getAttribute(SessionUtil.SPRING_SECURITY_SAVED_REQUEST_KEY);
            if (savedRequest != null) {
            	
                return savedRequest.getRedirectUrl();
            }
        }
		
		return "/";
	}
	
	/**
	 * Session Invalidate
	 * @param request
	 */
	public static void invalidate(HttpServletRequest request) {
		
		try {

			request.getSession(false).invalidate();

			SecurityContextHolder.clearContext();

		} catch (Exception e) {
			
			System.err.println("Session error => " + e.getMessage());
		}
	}
}
