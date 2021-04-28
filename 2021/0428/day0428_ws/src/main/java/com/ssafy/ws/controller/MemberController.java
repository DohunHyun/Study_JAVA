package com.ssafy.ws.controller;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.ws.dto.Member;
import com.ssafy.ws.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/login")
	public ModelAndView login(String id, String password, HttpSession session) {
		ModelAndView mav = new ModelAndView("index");
		try {
			Member found = memberService.select(id, password);
			session.setAttribute("loginUser", found);
		} catch (NoSuchElementException e) {
			mav.addObject("msg", "ID와 PW가 올바르지 않습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			mav.setViewName("error/500");
			e.printStackTrace();
		}
		
		return mav;
	}
	

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
}
