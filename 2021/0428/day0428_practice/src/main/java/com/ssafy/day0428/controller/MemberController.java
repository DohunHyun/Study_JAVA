package com.ssafy.day0428.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.day0428.dto.MemberDto;
import com.ssafy.day0428.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService mservice;
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(String userid, String userpwd, HttpSession session) throws SQLException {
		MemberDto memberDto = mservice.login(userid, userpwd);
		System.out.println("check");
//		System.out.println(memberDto.toString());
		if(memberDto != null) {
			session.setAttribute("loginInfo", memberDto);
		} else {
			session.setAttribute("msg", "아이디 또는 비밀번호를 확인해주세요.");
		}
		return "index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	
	

}
