package ru.vorobyov.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import ru.vorobyov.shop.entities.Product;
import ru.vorobyov.shop.service.ProductService;

import java.util.List;


@Controller
@RequestMapping()
public class ProductsController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("")
	private RedirectView start() {
		return new RedirectView("products");
	}
	
	//получение всех товаров
	@GetMapping("/products")
	private String showProductsPage(Model model, @RequestParam (value = "sort_method", defaultValue = "fromMin") String sortMethod,
	                                            @RequestParam (value = "min", defaultValue = "0.0") String min,
	                                            @RequestParam (value = "max", defaultValue = "1500.0") String max) {
		List<Product> productList = null;
		
		if ("fromMin".equals(sortMethod)) {
			productList = productService.fromMin(Double.parseDouble(min));
		} else if ("toMax".equals(sortMethod)) {
			productList = productService.toMax(Double.parseDouble(max));
		} else if ("fromMinToMax".equals(sortMethod)) {
			productList = productService.fromMinToMax(Double.parseDouble(min), Double.parseDouble(max));
		}
		
		model.addAttribute("productList", productList);
		model.addAttribute("newProduct", new Product());
		
		return "products";
	}
	
	//получение товара по id
	@GetMapping("/products/{id}")
	private String getAllProducts(Model model, @RequestParam (value = "id", defaultValue = "0") int id) {
		model.addAttribute("productList", productService.findById(id));
		
		return "products";
	}
	
	//создание нового товара [ POST .../app/products ]
	@PostMapping("/products")
	private RedirectView addProduct(Model model, @ModelAttribute("newProduct") Product newProduct) {
		productService.add(newProduct);
		model.addAttribute("productList", productService.findAll());
		return new RedirectView("products");
	}
	
	
	
	//удаление товара по id.[ GET .../app/products/delete/{id} ]

}
