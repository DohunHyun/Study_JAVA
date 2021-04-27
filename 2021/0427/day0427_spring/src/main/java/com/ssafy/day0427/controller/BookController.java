package com.ssafy.day0427.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.day0427.dto.BookDto;
import com.ssafy.day0427.dto.MemberDto;
import com.ssafy.day0427.service.BookService;

@Controller // @Component 하면 안됨! 여기는 컨트롤러만 가능 
public class BookController {
//	private BookService bservice = new BookService(); // 이러면 안돼! 이러면 dao 없는 서비스가 생성됨...! 
	
	@Autowired // 스프링에게 서비스 객체 달라고 해야 dao 장착된 완제품 서비스를 얻을 수 있음! 
	private BookService bservice;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return null;
	}
	
	@GetMapping("/bookList")
	public ModelAndView bookList() throws SQLException {
//		ModelAndView mav = new ModelAndView("book/list");
//		mav.setViewName("book/list"); // /WEB_INF/views/book/list.jsp
		
		ModelAndView mav = new ModelAndView("book/list"); // 위에 두줄과 같은 결과. 
		
		mav.addObject("bList", bservice.allBook()); // data
		return mav;
	}
	
	@GetMapping("/bookAdd") 
	public String bookAdd(HttpSession session) { // String을 리턴하면 그게 뷰 이름임.! 
//		MemberDto loginInfo = (MemberDto) session.getAttribute("loginInfo");
//		if(loginInfo != null) return "book/addForm";
		return "book/addForm";
	}
	
	@PostMapping("/bookAdd")
	public String bookAdd(BookDto book) throws SQLException {
		bservice.add(book);
		return "book/result";
	}
}
