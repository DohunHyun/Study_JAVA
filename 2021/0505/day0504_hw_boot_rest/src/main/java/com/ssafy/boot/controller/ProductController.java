package com.ssafy.boot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.boot.model.ProductDto;
import com.ssafy.boot.model.ProductService;

@RestController
@CrossOrigin("*")
public class ProductController {
	@Autowired
	private ProductService pservice;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/productMain")
	public ResponseEntity<Map<String, Object>> main(@RequestParam(value="page", defaultValue = "1") int page) {
		System.out.println("controller 도착 ! ");
		Map<String, Object> result = pservice.makePage(page);
		if(result == null || result.get("pList") == null || ((List)result.get("pList")).size() == 0 || result.size() == 0) {
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Map<String, Object>>(pservice.makePage(page), HttpStatus.OK);
	}
	
	@GetMapping("/product") // 상품 정보 보기 
	public ResponseEntity<ProductDto> read(int bnum) {
		ProductDto result = pservice.read(bnum);
		if(result == null) {
			return new ResponseEntity<ProductDto>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<ProductDto>(result, HttpStatus.OK);
	}
	
	@PostMapping("/product") // 상품 정보 등록 
	public ResponseEntity<String> write(ProductDto dto) {
		boolean result = pservice.write(dto);
		if(result) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}
		return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
	}

}
