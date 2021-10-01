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
	
	@RequestMapping("/hello_admin")
	@Secured("ROLE_ADMIN")
	@ResponseBody
	private String showHelloAdminPage() {
		return securedTest();
	}
	
	@RequestMapping("/admin")
	@ResponseBody
	private String returnSecurity() {
		return "admin panel";
	}
	
	
	private String securedTest() {
		return "securedTest for ROLE_ADMIN";
	}
	
}
