package com.hw.day0427.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hw.day0427.dto.ProductDto;
import com.hw.day0427.repository.DBUtil;

@Repository
public class ProductDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DBUtil util = DBUtil.getInstance();
	
	public List<ProductDto> selectAll() throws SQLException {
		ArrayList<ProductDto> list = new ArrayList<ProductDto>();
		
		try {
			conn = util.makeConnection();
			String sql = "select serialnum, title, price, description from product_tb";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductDto product = new ProductDto();
				product.setSerialnum(rs.getString(1));
				product.setTitle(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setDescription(rs.getString(4));
				
				list.add(product);
			}
		} finally {
			util.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public int insert(ProductDto product) throws SQLException {
		int result = 0;
		try {
			conn = util.makeConnection();
			String sql = " insert into " 
					+ " book_tb(serialnum, title, price, description) " 
					+ " values(?,?,?,?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getSerialnum());
			pstmt.setString(2, product.getTitle());
			pstmt.setInt(3, product.getPrice());
			pstmt.setString(4, product.getDescription());
			
			result = pstmt.executeUpdate();
		} finally {
			util.close(pstmt, conn);
		}
		
		
		return result;
	}

}
