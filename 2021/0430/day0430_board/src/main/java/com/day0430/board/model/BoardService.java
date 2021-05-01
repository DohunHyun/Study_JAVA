package com.day0430.board.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	@Autowired
	private BoardDao bdao;
	@Autowired
	private CommentDao cdao;
	
	private static final int COUNT_PER_PAGE = 10;
	
	public Map<String, Object> makePage(int page) {
		int totalCount = bdao.selectCount();
		
		int totalPage = totalCount/COUNT_PER_PAGE;
		if(totalCount % COUNT_PER_PAGE > 0) {
			totalPage++;
		}
		
		int startPage = (page-1) / 10 * 10 + 1;
		
		int endPage = startPage + 9;
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		int startRow = (page-1) * COUNT_PER_PAGE;
		List<BoardDto> bList = bdao.selectList(startRow, COUNT_PER_PAGE);
		Map<String, Object> pageInfo = new HashMap<>();
		
		pageInfo.put("stargPage", startPage);
		pageInfo.put("endPage", endPage);
		pageInfo.put("totalPage", totalPage);
		pageInfo.put("curPage", page);
		pageInfo.put("bList", bList);
		
		return pageInfo;
	}
	
	public boolean write(BoardDto boardDto, HttpSession session) {
		MemberDto loginInfo = (MemberDto) session.getAttribute("loginInfo");
		System.out.println("로그인 이름 : " + loginInfo.getName());
		System.out.println("작성자 이름 : " + boardDto.getBwriter());
		if(loginInfo.getName().equals(boardDto.getBwriter())) {
			System.out.println("작성자가 같네요 ! ");
			if(bdao.insert(boardDto) > 0) {
				return true;
			}
		}
		return false;
	}
	
	public boolean update(BoardDto boardDto, MemberDto memberDto) {
//		BoardDto boardDto = bdao.selectOne(bnum);
		if(boardDto.getBwriter().equals(memberDto.getName())) {
			if(bdao.update(boardDto) > 0);
				return true;
		}
		return false;
	}
	
	public boolean delete(int bnum, MemberDto memberDto) {
		BoardDto boardDto = bdao.selectOne(bnum);
		if(boardDto.getBwriter().equals(memberDto.getName())) {
			if(bdao.delete(boardDto) > 0) return true;
		}
		return false;
	}
	
	public BoardDto read(int bnum) {
		return bdao.selectOne(bnum);
	}
	
	public List<CommentDto> getCmtList(int bnum) {
		return cdao.selectList(bnum);
	}
	
	public boolean writeComment(CommentDto cmtDto) {
		if(cdao.insert(cmtDto) > 0) 
			return true;
		return false;
	}

}
