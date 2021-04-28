package com.ssafy.ws.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.dto.Product;
import com.ssafy.ws.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void insert(Product product) throws SQLException, NoSuchFieldException {
		if (product.getQuantity() == null) 
			throw new NoSuchFieldException();
		else 
			productRepository.insert(product);
	}

	@Override
	public Product select(String pCode) throws SQLException {
		return productRepository.select(pCode);
	}

	@Override
	public List<Product> selectAll() throws SQLException {
		return productRepository.selectAll();
	}

}
