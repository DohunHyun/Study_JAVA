package com.ssafy.day0428.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.ssafy.day0428.dto.MemberDto;

@Repository
public class MemberDao {
	static Connection conn;
	static PreparedStatement pstmt;
	static ResultSet rs;
	
	public MemberDto login(String userid, String userpwd) throws SQLException{
		MemberDto memberDto = null;
		System.out.println("있긴하니?");

		try {
			conn = DBUtil.makeConnection();
			String sql = " select mid, mpass, mname " 
					+ " from tmember "
					+ " where mid = ? and mpass = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, userpwd);
			rs = pstmt.executeQuery();
			System.out.println("있긴하니?");
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setMid(rs.getString(1));
				memberDto.setMpass(rs.getString(2));
				memberDto.setMname(rs.getString(3));
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return memberDto;
	}

}
