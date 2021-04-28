package com.ssafy.ws.repository;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.ws.dto.Product;


public interface ProductRepository {
	/**
	 * 입력된 Product 정보를 저장한다.
	 * @param product
	 * @throws SQLException
	 */
	void insert(Product product) throws SQLException;

	/**
	 * 입력된 pCode에 해당하는 Product를 반환한다.
	 * @param pCode
	 * @return
	 * @throws SQLException
	 */
	Product select(String pCode) throws SQLException;

	/**
	 * 모든 Product 정보를 반환한다.
	 * @return
	 * @throws SQLException
	 */
	List<Product> selectAll() throws SQLException;
}
