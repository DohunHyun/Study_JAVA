package com.hw.day0427.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hw.day0427.dto.ProductDto;
import com.hw.day0427.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService pservice;
	
	@RequestMapping(value="/productList", method=RequestMethod.GET)
	public ModelAndView productList() throws SQLException {
		ModelAndView mav = new ModelAndView("product/list");
		mav.addObject("pList", pservice.allProduct());
		return mav;
	}
	@GetMapping("/productAdd")
	public String productAdd() {
		return "product/addForm";
	}
	
	@PostMapping("/productAdd")
	public String productAdd(ProductDto product) throws SQLException {
		pservice.add(product);
		return "product/result";
	}
}
