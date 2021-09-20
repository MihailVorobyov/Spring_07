package ru.vorobyov.shop.controllers;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class IndexController {

	@GetMapping({"", "/index"})
	private String showIndexPage(Model model) {
		return "redirect:/shop/products";
	}

}
