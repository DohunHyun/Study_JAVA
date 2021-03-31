package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// book_tb 관련한 sql 실행을 전담 
public class BookDao {
	
	// driver loading(mysql-connector 잘 있나 확인)
	// 커넥션 연결 (db url, db id, db pw)
	// sql 작성
	// pstmt or stmt 객체 확보 (preparedstatement, statement)
	// sql 실행 (insert, update, delete (return int) / select (ResultSet 결과 조회))
	// sql 실행 결과의 처리 
	// 자원 반납 close 
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public List<BookDTO> selectAll() {
		
		try {
			con = DBUtil.makeConnection();
			String sql = "SELECT ISBN, TITLE, PUBLISHER, AUTHOR, PRICE FROM BOOK_TB";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ArrayList<BookDTO> bookList = new ArrayList<>();
			
			while(rs.next()) {
				BookDTO book = new BookDTO();
				book.setIsbn(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setPublisher(rs.getString(3));
				book.setAuthor(rs.getString(4));
				book.setPrice(rs.getInt(5));
				
				bookList.add(book);
			}
			
			return bookList;
			
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

	
	public int insert(BookDTO book) {
		int result = 0;
		try {
			con = DBUtil.makeConnection();
			String sql = "INSERT INTO BOOK_TB(ISBN,TITLE,PUBLISHER,AUTHOR,PRICE) "
					+ "VALUES(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getPublisher());
			pstmt.setString(4, book.getAuthor());
			pstmt.setInt(5, book.getPrice());	
			
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


	public int selectUserCount(String id, String pw) {
		int result = 0;
		try {
			con = DBUtil.makeConnection();
			String sql = "SELECT COUNT(*) FROM SSAFY_MEMBER " + ""
					+ " WHERE USERID=? AND USERPWD=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery(); // select 이니깐 쿼리! 
			rs.next();
			result = rs.getInt(1);
			
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
	
//	public int delete(String isbn) {
//		
//	}
}
