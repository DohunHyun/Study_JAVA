package com.ssafy.day0428.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.day0428.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService pservice;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@GetMapping("/productList")
	public ModelAndView list() throws SQLException {
		ModelAndView mav = new ModelAndView("product/list");
		mav.addObject("pList", pservice.productList());
		return mav;
	}

}
