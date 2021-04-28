package com.ssafy.board.model;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberDao mdao;
	
	public MemberDto login(String userid, String userpwd) throws SQLException {
		MemberDto memberDto = mdao.login(userid, userpwd);
		return memberDto;
	}

}
