package com.day0430.board.controller;

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

import com.day0430.board.model.BoardDto;
import com.day0430.board.model.BoardService;
import com.day0430.board.model.CommentDto;
import com.day0430.board.model.MemberDto;

@Controller
public class BoardController {
	@Autowired
	private BoardService bservice;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/list")
	public ModelAndView list(@RequestParam(defaultValue = "1") int page) {
		ModelAndView mav = new ModelAndView("board_list");
		mav.addObject("pageInfo", bservice.makePage(page));
		return mav;
	}
	
	@GetMapping("/read/{bnum}")
	public ModelAndView read(@PathVariable("bnum") int bn) {
		ModelAndView mav = new ModelAndView("board_read");
		mav.addObject("boardDto", bservice.read(bn));
		return mav;
	}
	
	@GetMapping("/write")
	public String write(HttpServletRequest request, HttpSession session) {
		if(session.getAttribute("loginInfo") != null) {
			session.setAttribute("msg", "로그인이 되었습니다.");			
			return "board_write";
		}
		else {
			session.setAttribute("msg", "로그인이 필요합니다.");
			return "index";
		}
	}
	
	@PostMapping("/write")
	public String write(BoardDto board, HttpSession session) {
		if(bservice.write(board, session)) return "write_success";
		return "write_fail";
	}
	
	@GetMapping("/update")
	public String update(int bnum, HttpServletRequest request) {
		BoardDto boardDto = bservice.read(bnum);
		request.setAttribute("original", boardDto);
		return "board_update";
	}
	
	@PostMapping("/update")
	public String update(BoardDto board, int bnum, HttpSession session) {
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
		if(bservice.update(board, memberDto))
			return "update_success";
		else return "update_fail";
	}
	
	@GetMapping("/delete")
	public String delete(int bnum, HttpSession session) {
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
		if(bservice.delete(bnum, memberDto)) {
			return "delete_success";
		} else return "delete_fail";
	}
	
	@GetMapping(value="/ajax", produces = "application/json;charset=utf8")
	@ResponseBody
	public List<CommentDto> ajax(int bnum) {
		return bservice.getCmtList(bnum);
	}
	
	@PostMapping("/ajax")
	@ResponseBody
	public String ajax(@RequestBody CommentDto cmtDto) {
		if(bservice.writeComment(cmtDto)) {
			return "success";
		} else {
			return "fail";
		}
	}
	

}
