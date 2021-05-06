package com.ssafy.board.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.board.model.mapper.MemberMapper;

@Repository
public class MemberDao {
	@Autowired
	public SqlSessionTemplate template;
	
	public MemberDto login(String userid, String userpwd) {
		return template.getMapper(MemberMapper.class).login(userid, userpwd);
	}

}
