package com.day0430.board.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.day0430.board.model.mapper.BoardMapper;

@Repository
public class BoardDao {
	@Autowired
	private SqlSessionTemplate template;
	
	public int insert(BoardDto boardDto) {
		return template.getMapper(BoardMapper.class).insert(boardDto);
	}
	
	public int update(BoardDto boardDto) {
		return template.getMapper(BoardMapper.class).update(boardDto);
	}
	
	public int delete(BoardDto boardDto) {
		return template.getMapper(BoardMapper.class).delete(boardDto);
	}
	
	public BoardDto selectOne(int bnum) {
		return template.getMapper(BoardMapper.class).selectOne(bnum);
	}
	
	public List<BoardDto> selectList(int startRow, int count) {
		return template.getMapper(BoardMapper.class).selectList(startRow, count);
	}
	
	public int selectCount() {
		return template.getMapper(BoardMapper.class).selectCount();
	}

}
