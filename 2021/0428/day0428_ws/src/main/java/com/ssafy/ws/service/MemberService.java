package com.ssafy.ws.service;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import com.ssafy.ws.dto.Member;


public interface MemberService {
	Member select(String id, String pass) throws SQLException, NoSuchElementException;
}
