package com.day0429.hw.controller;

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

import com.day0429.hw.model.BoardDto;
import com.day0429.hw.model.BoardService;
import com.day0429.hw.model.CommentDto;

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
		return "board_write";
	}
	
	@PostMapping("/write")
	public String write(BoardDto board) {
		if(bservice.write(board)) return "write_success";
		return "write_fail";
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
