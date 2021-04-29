package com.ssafy.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.BoardService;
import com.ssafy.board.model.CommentDto;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService bservice;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/list") // parameter가 url에 나타나는 구식 버전 
	public ModelAndView list(@RequestParam(defaultValue = "1") int page) {
		ModelAndView mav = new ModelAndView("board_list");
		mav.addObject("pageInfo", bservice.makePage(page));
		return mav;
	}
	
	@GetMapping("/read/{bnum}") // parameter 이름이 url에 안나오고 값만 나오는 신식 버전 
	public ModelAndView read(@PathVariable("bnum") int bn) {
		ModelAndView mav = new ModelAndView("board_read");
		mav.addObject("boardDto", bservice.read(bn));
		return mav;
	}
	
	@GetMapping("/write")
	public String write(HttpServletRequest request, HttpSession session) {
//		Member loginInfo = session.getAttribute("loginInfo");
//		if(loginInfo != null) 
//		return "board_write";
//		else {
//			request.setAttribute("msg", "로그인이 필요합니다.");
//			return "index";
//		}
		
		return "board_write";
	}
	
//	@PostMapping("/write")
//	public String write(String btitle, String bcontent, String bwriter) {
//		
//	}
	
	@PostMapping("/write")
	public String write(BoardDto board) {
		if(bservice.write(board)) return "write_success";
		else return "write_fail";	
	}
	
//	@GetMapping(value="/ajax", produces = "application/json;charset=utf8")
//	@ResponseBody
//	public List<CommentDto> ajax(int bnum) {
//		return bservice.getCmtList(bnum);
//	}
//	
//	@PostMapping("/ajax")
//	@ResponseBody
//	public String ajax(@RequestBody CommentDto cmtDto) {
//		if(bservice.writeComment(cmtDto))
//			return "success";
//		else
//			return "fail";
//	}

}
