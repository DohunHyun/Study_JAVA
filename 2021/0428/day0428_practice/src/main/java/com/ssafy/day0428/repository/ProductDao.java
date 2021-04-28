package com.ssafy.day0428.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.day0428.dto.ProductDto;

@Repository
public class ProductDao {
	static Connection conn;
	static PreparedStatement pstmt;
	static ResultSet rs;
	
	public List<ProductDto> selectList() throws SQLException {
		ArrayList<ProductDto> list = new ArrayList<ProductDto>();
		try {
			String sql = "select pcode, pname, pquantity from tproduct ";
			conn = DBUtil.makeConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductDto p = new ProductDto();
				p.setPcode(rs.getString(1));
				p.setPname(rs.getString(2));
				p.setPquantity(rs.getInt(3));
				
				list.add(p);
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return list;
	}

}
