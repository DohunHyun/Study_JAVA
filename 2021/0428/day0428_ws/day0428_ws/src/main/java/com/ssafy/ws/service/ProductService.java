package com.ssafy.ws.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.ws.dto.Product;


public interface ProductService {
	void insert(Product product) throws SQLException, NoSuchFieldException;

	Product select(String pCode) throws SQLException;

	List<Product> selectAll() throws SQLException;
}
