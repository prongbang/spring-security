package com.prongbang.sec.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prongbang.sec.model.Authorities;
import com.prongbang.sec.service.AuthoritiesService;

@Controller
@RequestMapping("/authorities/")
public class AuthoritiesController {

	@Autowired
	private AuthoritiesService authoritiesService;
	
	@RequestMapping(value = "/find-all", method = RequestMethod.GET)
	@ResponseBody
	public List<Authorities> authorities() {
		
		try {
			
			return authoritiesService.findAll();
			
		} catch (Exception e) {
			
		}
		
		return new ArrayList<Authorities>();
	}
	
}
