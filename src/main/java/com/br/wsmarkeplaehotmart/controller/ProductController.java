package com.br.wsmarkeplaehotmart.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import br.com.marketplaceHotMart.dto.ProductDTO;

@RestController
@RequestMapping("/api/wsmarkeplaehotmart")
public class ProductController {
	@GetMapping("/create")
	public String create(Model model, HttpServletRequest request) {
//		model.addAttribute("product", new ProductDTO());
		return "create_product";
	}
}
