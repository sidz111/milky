package com.milky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/product")
	public String productPage() {
		return "product";
	}
}
