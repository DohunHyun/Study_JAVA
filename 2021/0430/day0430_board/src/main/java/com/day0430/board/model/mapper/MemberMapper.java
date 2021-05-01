package com.day0430.board.model.mapper;

import org.apache.ibatis.annotations.Param;

import com.day0430.board.model.MemberDto;

public interface MemberMapper {
	public MemberDto login(@Param("userid") String userid, @Param("userpwd") String userpwd);

}
