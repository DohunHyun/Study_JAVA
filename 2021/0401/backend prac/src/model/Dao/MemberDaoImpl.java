package model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Dto.MemberDto;
import util.DBUtil;

public class MemberDaoImpl implements MemberDao{
	
	//for singleton
	private static MemberDaoImpl memberDaoImpl;
	private MemberDaoImpl() {}
	public static MemberDaoImpl getMemberDaoImpl() {
		if(memberDaoImpl == null) {
			memberDaoImpl = new MemberDaoImpl();
		}
		return memberDaoImpl;
	}

	@Override
	public void registerMember(MemberDto memeberDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberDto login(String userId, String userPwd) {
		MemberDto memberDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnect();
			String sql = "select username, email \n";
			sql += "from ssafy_member \n";
			sql += "where userid = ? and userpwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setUserName(rs.getString("username"));
				memberDto.setUserId(userId);
				memberDto.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn,pstmt,rs);
		}
		return memberDto;
	}

	@Override
	public MemberDto getMember(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyMember(MemberDto memberDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(String userId) {
		// TODO Auto-generated method stub
		
	}

}
