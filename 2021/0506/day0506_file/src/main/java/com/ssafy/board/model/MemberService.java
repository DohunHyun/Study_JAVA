package com.ssafy.board.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberDao mdao;
	
	public MemberDto login(String userid, String userpwd) {
		MemberDto memberDto = mdao.login(userid, userpwd);
//		System.out.println(memberDto.getId());
		return memberDto;
	}

}
