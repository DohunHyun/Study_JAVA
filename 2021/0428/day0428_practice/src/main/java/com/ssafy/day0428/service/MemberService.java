package com.ssafy.day0428.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.day0428.dto.MemberDto;
import com.ssafy.day0428.repository.MemberDao;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao mdao;
	
	public MemberDto login(String userid, String userpwd) throws SQLException {
		if(userid == null || userpwd == null) return null;
		return mdao.login(userid, userpwd);
	}

}
