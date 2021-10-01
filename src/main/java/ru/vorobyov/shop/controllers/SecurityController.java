package ru.vorobyov.shop.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecurityController {
	
	@RequestMapping("/")
	private String showHomePage() {
		return "index";
	}
	
	@Secured({"ROLE_ADMIN"})
	@RequestMapping("/admin")
	@ResponseBody
	private String returnSecurity() {
		return "admin panel";
	}
	
}
