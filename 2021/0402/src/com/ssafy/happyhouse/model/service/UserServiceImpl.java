package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;

import com.ssafy.happyhouse.model.UserDto;
import com.ssafy.happyhouse.model.dao.UserDaoImpl;

public class UserServiceImpl implements UserService{
	private static UserService userService;
	private UserServiceImpl() {}
	public static UserService getUserService() {
		if(userService == null) {
			userService = new UserServiceImpl();
		}
		return userService;
	}
	
    @Override
    public void registerUser(UserDto userDto) throws SQLException {
    	System.out.println("가입 service");
    	UserDaoImpl.getUserDao().registerUser(userDto);
    }

    @Override
    public UserDto login(String userId, String userPwd) {
    	System.out.println("service");
    	System.out.println("userid : " + userId);
        return UserDaoImpl.getUserDao().login(userId, userPwd);
    }

    @Override
    public UserDto getUser(String userId) {
        return null;
    }

    @Override
    public void modifyUser(UserDto userDto) throws SQLException {
    	System.out.println("수정 service");
    	UserDaoImpl.getUserDao().modifyUser(userDto);
    	
    }
}
