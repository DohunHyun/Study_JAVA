package com.ssafy.happyhouse.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.happyhouse.model.UserDto;
import com.ssafy.util.DBUtil;

public class UserDaoImpl implements UserDao{
	
	private static UserDao userDao;
	private UserDaoImpl() {}
	public static UserDao getUserDao() {
		if(userDao == null) {
			userDao = new UserDaoImpl();
		}
		return userDao;
	}
	
    @Override
    public void registerUser(UserDto userDto) throws SQLException {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	try {
    		System.out.println("가입 dao");
    		System.out.println(userDto.getUserId());
    		conn = DBUtil.getConnect();
    		String sql = "insert into users(userId, userPwd, userName, userPhone, userAddress, userPreferarea) \n";
    		sql += "values (?, ?, ?, ?, ?, ?)";
    		pstmt = conn.prepareStatement(sql);
    		pstmt.setString(1, userDto.getUserId());
    		pstmt.setString(2, userDto.getUserPwd());
    		pstmt.setString(3, userDto.getUserName());
    		pstmt.setString(4, userDto.getUserPhone());
    		pstmt.setString(5, userDto.getUserAddress());
    		pstmt.setString(6, userDto.getPreferArea());
    		pstmt.executeUpdate();
    	} finally {
    		DBUtil.close(pstmt,conn);
    	}
    }

    @Override
    public UserDto login(String userId, String userPwd) {
    	UserDto userDto = null;
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
		try {
			conn = DBUtil.getConnect();
			String sql = "select userid, userpwd, username, userphone, useraddress, userpreferarea \n";
			sql += "from users \n";
			sql += "where userid = ? and userpwd = ?";
			pstmt = conn.prepareStatement(sql);
			System.out.println("id : " + userId);
			System.out.println("pw : " + userPwd);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("있어??");
				userDto = new UserDto();
				userDto.setUserId(userId);
				userDto.setUserPwd(userPwd);
				userDto.setUserName(rs.getString("userName"));
				userDto.setUserPhone(rs.getString("userPhone"));
				userDto.setUserAddress(rs.getString("userAddress"));
				userDto.setPreferArea(rs.getString("userPreferArea"));
			}
			System.out.println("유저 데이터 찾았다! ");
			System.out.println(userDto);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}

        return userDto;
    }

    @Override
    public UserDto getUser(String userId) {
        return null;
    }

    @Override
    public void modifyUser(UserDto userDto) throws SQLException {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	try {
    		System.out.println("수정 dao");
    		conn = DBUtil.getConnect();
    		String sql = "update users \n";
    		sql += "set userPwd = ?, userName = ?, userPhone=?, userAddress=?, userPreferarea=? \n";
    		sql += "where userId = ?";
    		pstmt = conn.prepareStatement(sql);
    		pstmt.setString(1, userDto.getUserPwd());
    		pstmt.setString(2, userDto.getUserName());
    		pstmt.setString(3, userDto.getUserPhone());
    		pstmt.setString(4, userDto.getUserAddress());
    		pstmt.setString(5, userDto.getPreferArea());
    		pstmt.setString(6, userDto.getUserId());
    		pstmt.executeUpdate();
    	} finally {
    		DBUtil.close(pstmt,conn);
    	}
    			

    }
}
