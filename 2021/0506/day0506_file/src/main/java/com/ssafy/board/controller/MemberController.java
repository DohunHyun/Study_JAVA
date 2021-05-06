package com.ssafy.board.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.board.model.MemberDto;
import com.ssafy.board.model.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService mservice;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/login")
	public ModelAndView login(String userid, String userpwd, HttpSession session) throws SQLException {
		ModelAndView mav = new ModelAndView("index");
		MemberDto memberDto = mservice.login(userid, userpwd);
//		System.out.println(memberDto.getId());
		if(memberDto != null) {
			session.setAttribute("loginInfo", memberDto);
		} else {
			mav.addObject("msg", "아이디나 비밀번호가 잘못되었습니다.");
		}
		return mav;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}

}
