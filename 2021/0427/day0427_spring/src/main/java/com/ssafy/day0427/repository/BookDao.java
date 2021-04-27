package com.ssafy.day0427.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.day0427.dto.BookDto;

// book_tb 테이블 관련 디비작업 담당 클래스 
@Repository
public class BookDao {
//////////////////////////////////////////////////////////////
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DBUtil util = DBUtil.getInstance();

	public List<BookDto> selectAll() throws SQLException {
		ArrayList<BookDto> list = new ArrayList<>();
		try {
			conn = util.makeConnection();
			String sql = "SELECT BNUM, ISBN, TITLE, PUBLISHER, PRICE, AUTHOR FROM BOOK_TB";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BookDto book = new BookDto();
				book.setBnum(rs.getInt(1));
				book.setIsbn(rs.getString(2));
				book.setTitle(rs.getString(3));
				book.setPublisher(rs.getString(4));
				book.setPrice(rs.getInt(5));
				book.setAuthor(rs.getString(6));

				list.add(book);
			}
		} finally {
			util.close(conn, pstmt, rs);
		}
		return list;
	}

	public int insert(BookDto book) throws SQLException {
		int result = 0;
		try {
			conn = util.makeConnection();
			String sql = " INSERT INTO " + " BOOK_TB(TITLE,PUBLISHER,PRICE,AUTHOR,DESCRIPTION,ISBN) "
					+ " VALUES(?,?,?,?,?,?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getPublisher());
			pstmt.setInt(3, book.getPrice());
			pstmt.setString(4, book.getAuthor());
			pstmt.setString(5, book.getDescription());
			pstmt.setString(6, book.getIsbn());

			result = pstmt.executeUpdate();
		} finally {
			util.close(pstmt, conn);
		}
		return result;
	}

	public int delete(int dNum) throws SQLException {
		int result = 0;
		try {
			conn = util.makeConnection();
			String sql = "DELETE FROM BOOK_TB WHERE BNUM=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dNum);
			result = pstmt.executeUpdate();
		} finally {
			util.close(pstmt, conn);
		}
		return result;
	}
}
