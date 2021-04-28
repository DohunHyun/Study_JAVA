package com.ssafy.day0428.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.day0428.dto.ProductDto;
import com.ssafy.day0428.repository.ProductDao;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao pdao;
	
	public List<ProductDto> productList() throws SQLException {
		return pdao.selectList();
	}
	

}
