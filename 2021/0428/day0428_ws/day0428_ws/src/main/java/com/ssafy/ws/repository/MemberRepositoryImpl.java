package com.ssafy.ws.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.ssafy.ws.dto.Member;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
	private DBUtil util = DBUtil.getUtil();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	@Override
	public Member select(String id, String pass) throws SQLException {
		Member member = null;
		conn = util.getConnection();
		String sql = "SELECT mid, mpass, mname FROM tmember WHERE mid = ? AND mpass = ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,  id);
		pstmt.setString(2, pass);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			member = new Member(rs.getString(1), rs.getString(2), rs.getString(3));
		}
		
		util.close(rs, pstmt, conn);
		return member;
	}

}
