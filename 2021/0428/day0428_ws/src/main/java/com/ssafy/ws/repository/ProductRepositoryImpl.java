package com.ssafy.ws.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.ws.dto.Product;


@Repository
public class ProductRepositoryImpl implements ProductRepository{
	private DBUtil util = DBUtil.getUtil();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	@Override
	public void insert(Product product) throws SQLException {
		conn = util.getConnection();
		String sql = "INSERT INTO tproduct(pcode, pname, pquantity)  VALUES(?, ?, ?) ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,product.getCode());
		pstmt.setString(2, product.getName());
		pstmt.setInt(3, product.getQuantity());
		pstmt.executeUpdate();
		
		util.close(pstmt, conn);
	}

	@Override
	public Product select(String pCode) throws SQLException {
		Product found = null;
		conn = util.getConnection();
		String sql = "SELECT pcode, pname, pquantity FROM tproduct WHERE pcode = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, pCode);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			found = new Product(rs.getString(1), rs.getString(2), rs.getInt(3));
		}
		
		util.close(rs, pstmt, conn);
		return found;
	}

	@Override
	public List<Product> selectAll() throws SQLException {
		List<Product> productList = new ArrayList<>();
		
		conn = util.getConnection();
		String sql = "SELECT pcode, pname, pquantity FROM tproduct";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			Product product = new Product(rs.getString(1), rs.getString(2), rs.getInt(3));
			productList.add(product);
		}
		
		util.close(rs, pstmt, conn);
		return productList;
	}

}
