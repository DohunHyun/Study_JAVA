package com.ssafy.book.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.book.model.mapper.BookMapper;

@Service
public class BookService {
	@Autowired
	private SqlSessionTemplate template;
	
	private static final int COUNT_PER_PAGE=10;
	
	public Map<String, Object> makePage(int page){
		// 총 게시글 갯수 디비에서 조회함.
		int totalCount = template.getMapper(BookMapper.class).selectCount();
		
		// 총 페이지수 계산
		int totalPage = totalCount/COUNT_PER_PAGE;
		if(totalCount%COUNT_PER_PAGE>0)
			totalPage++;
		
		// 화면 하단의 시작 페이지
		int startPage = (page-1)/10*10+1;
				
		int endPage = startPage+9;
		if(endPage>totalPage)
			endPage = totalPage;
		
		// 현재 페이지 게시글 조회
		int startRow = (page-1)*COUNT_PER_PAGE; // limit 의 시작행 번호 계산.
		List<BookDto> bList = template.getMapper(BookMapper.class).selectList(startRow, COUNT_PER_PAGE);
		
		Map<String, Object> pageInfo = new HashMap();
		
		pageInfo.put("startPage", startPage);
		pageInfo.put("endPage", endPage);
		pageInfo.put("totalPage", totalPage);
		pageInfo.put("curPage", page);
		pageInfo.put("bList", bList);
	
		return pageInfo;
	}
	
	@Transactional
	public boolean write(BookDto boardDto) {
		// autocommit -> false
		if(template.getMapper(BookMapper.class).insert(boardDto)>0)
			return true;
		// commit();
		return false;
	}

	public BookDto read(int bnum) {
		return template.getMapper(BookMapper.class).selectOne(bnum);
	}

}
