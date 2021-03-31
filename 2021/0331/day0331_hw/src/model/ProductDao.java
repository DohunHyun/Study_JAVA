package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// product_tb 관련한 sql 실행 전담 
public class ProductDao {
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public List<ProductDTO> selectAll() {
		
		try {
			con = DBUtil.makeConnection();
			String sql = "SELECT SERIALNUM, TITLE, PRICE, DESCRIPTION FROM PRODUCT_TB";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ArrayList<ProductDTO> productList = new ArrayList<>();
			
			while(rs.next()) {
				ProductDTO product = new ProductDTO();
				product.setSerialnum(rs.getString(1));
				product.setTitle(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setDescription(rs.getString(4));
				System.out.println(product);
				
				productList.add(product);
			
			}
			return productList;
		} catch (SQLException e) {
			System.out.println("dao selectAll error");
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(rs);
			DBUtil.close(con);
		}
		return null;
	}
	
	public int insert(ProductDTO product) {
		int result = 0;
		try {
			con = DBUtil.makeConnection();
			String sql = "INSERT INTO PRODUCT_TB(SERIALNUM,TITLE,PRICE,DESCRIPTION) "
					+ "VALUES(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getSerialnum());
			pstmt.setString(2, product.getTitle());
			pstmt.setInt(3, product.getPrice());
			pstmt.setString(4, product.getDescription());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("dao insert error");
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(rs);
			DBUtil.close(con);
		}
		return result;
	}
	
	public boolean selectUser(String id, String pw) {
		boolean flag = false;
		try {
			con = DBUtil.makeConnection();
			String sql = "SELECT COUNT(*) FROM SSAFY_MEMBER " + ""
					+ " WHERE USERID=? AND USERPWD=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery(); // select 이니깐 쿼리! 
			rs.next();
			if( rs.getInt(1) == 1)  {
				System.out.println("login succ");
				flag = true;
			}
			
		} catch (SQLException e) {
			System.out.println("dao login error");
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(rs);
			DBUtil.close(con);
		}
		return flag;
	}
	
	

}
