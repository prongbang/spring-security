package com.prongbang.sec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String init(ModelMap model) { 
		
		return "index";
	}
	
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) { 
		
        return "admin";
    }
 
    @RequestMapping(value = "/dba", method = RequestMethod.GET)
    public String dbaPage(ModelMap model) { 
		
        return "dba";
    }
	
}
