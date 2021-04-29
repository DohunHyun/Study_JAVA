package com.day0429.hw.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public boolean write(BoardDto boardDto) {
		if(bdao.insert(boardDto) > 0) {
			return true;
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
