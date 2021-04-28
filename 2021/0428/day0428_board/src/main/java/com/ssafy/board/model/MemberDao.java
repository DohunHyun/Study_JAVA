package com.ssafy.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public MemberDto login(String userid, String userpwd) throws SQLException {
		MemberDto memberDto = null;
		
		conn = DBUtil.makeConnection();
		String sql = " select mid, mpass, mname from member_tb where mid = ? and mpass = ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,  userid);
		pstmt.setString(2, userpwd);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			memberDto = new MemberDto();
			memberDto.setId(rs.getString(1));
			memberDto.setPass(rs.getString(2));
			memberDto.setName(rs.getString(3));
		}
		DBUtil.close(rs, pstmt, conn);
		return memberDto;
	}

}
