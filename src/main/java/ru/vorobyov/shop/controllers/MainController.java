package ru.vorobyov.shop.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/")
	private String showHomePage() {
		return "index";
	}
	
	@Secured({"ROLE_ADMIN"})
	@RequestMapping("/security")
	@ResponseBody
	private String returnSecurity() {
		return "index";
	}
	
}
