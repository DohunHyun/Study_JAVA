package com.ssafy.day0427.repository;

import java.sql.*;

import com.ssafy.day0427.dto.MemberDto;

// ssafy_member 테이블 관련 디비작업 담당 클래스
public class MemberDao {
	private DBUtil util = DBUtil.getInstance();
	
	public MemberDto login(String userid, String userpwd) throws SQLException {
		MemberDto memberDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = util.makeConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select username, userid, email \n");
			sql.append("from ssafy_member \n");
			sql.append("where userid = ? and userpwd = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userid);
			pstmt.setString(2, userpwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setUserid(rs.getString("userid"));
				memberDto.setUsername(rs.getString("username"));
				memberDto.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			memberDto = null;
		} finally {
			util.close(rs, pstmt, conn);
		}
		return memberDto;
	}
}
