package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;

import com.ssafy.happyhouse.model.UserDto;

public interface UserService {
    //회원가입
    void registerUser(UserDto userDto) throws SQLException;

    //로그인
    UserDto login(String userId, String userPwd);

    //회원정보 수정을 위한 회원의 모든 정보 얻기
    UserDto getUser(String userId);

    //회원정보 수정
    void modifyUser(UserDto userDto) throws SQLException;
}
