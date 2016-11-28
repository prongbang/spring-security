package com.prongbang.sec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorController {

	@RequestMapping(value = "/400", method = RequestMethod.GET)
	public String _400(ModelMap model) {
		
		model.addAttribute("bgColor", "is-danger");
		model.addAttribute("errMsg", "400 Bad Request");

		return "error";
	}

	@RequestMapping(value = "/401", method = RequestMethod.GET)
	public String _401(ModelMap model) {
		
		model.addAttribute("bgColor", "is-warning");
		model.addAttribute("errMsg", "401 Unauthorized");

		return "error";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String _403(ModelMap model) {

		model.addAttribute("bgColor", "is-warning");
		model.addAttribute("errMsg", "403 Access is denied");

		return "error";
	}

	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public String _404(ModelMap model) {

		model.addAttribute("bgColor", "is-light");
		model.addAttribute("errMsg", "404 Not Found");

		return "error";
	}

	@RequestMapping(value = "/500", method = RequestMethod.GET)
	public String _500(ModelMap model) {

		model.addAttribute("bgColor", "is-danger");
		model.addAttribute("errMsg", "500 Internal Server Error");

		return "error";
	}

	@RequestMapping(value = "/503", method = RequestMethod.GET)
	public String _503(ModelMap model) {

		model.addAttribute("bgColor", "is-danger");
		model.addAttribute("errMsg", "503 Service Unavailable");

		return "error";
	}

}
