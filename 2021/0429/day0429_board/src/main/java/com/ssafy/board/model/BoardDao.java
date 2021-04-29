package com.ssafy.board.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.board.model.mapper.BoardMapper;

@Repository
public class BoardDao {
	@Autowired
	private SqlSessionTemplate template;
	
	// 글쓰기
		public int insert(BoardDto boardDto) {
			return template.getMapper(BoardMapper.class).insert(boardDto);
		}
		
		// 게시글 읽기(목록에서 특정 게시글 선택했을 때)
		public BoardDto selectOne(int bnum) {
			return template.getMapper(BoardMapper.class).selectOne(bnum);
		}
		
		// 게시판 목록(특정 페이지에 보여질 글 여러개)
		public List<BoardDto> selectList(int startRow, int count){
			return template.getMapper(BoardMapper.class).selectList(startRow, count);
		}
		
		// 게시판 목록에서 시작페이지 마지막페이지 계산할 때.
		public int selectTotalCount() {
			return template.getMapper(BoardMapper.class).selectCount();
		}
	
}
