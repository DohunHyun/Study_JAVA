package com.ssafy.ws.service;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.dto.Member;
import com.ssafy.ws.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public Member select(String id, String pass) throws SQLException, NoSuchElementException {
		Member found = memberRepository.select(id, pass);
		if (found == null)
			throw new NoSuchElementException();
		
		return found;
	}

}
