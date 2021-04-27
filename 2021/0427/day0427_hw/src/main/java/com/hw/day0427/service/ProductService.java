package com.hw.day0427.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hw.day0427.dto.ProductDto;
import com.hw.day0427.repository.ProductDao;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao dao;
	
	public List<ProductDto> allProduct() throws SQLException {
		return dao.selectAll();
	}
	
	public void add(ProductDto product) throws SQLException {
		dao.insert(product);
	}

}
