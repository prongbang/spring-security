package com.prongbang.sec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "expired", required = false) String expired,
		@RequestParam(value = "duplicate", required = false) String duplicate,
		@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			
			model.addObject("error", "Invalid username / password, try again.");
			
		}

		if (logout != null) {
			
			model.addObject("msg", "You have been logged out.");
			
		}
		
		if (expired != null) {
			
			model.addObject("expired", "Session expired.");
			
		}
		
		if (duplicate != null) {
			
			model.addObject("duplicate", "Session expired duplicate login.");
			
		}
		
		model.setViewName("login");

		return model;
	}
	
}
