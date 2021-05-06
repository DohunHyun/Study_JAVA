package com.ssafy.board.model;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.board.model.mapper.BoardMapper;

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

	public int fileRegist(BoardDto boardDto) throws SQLException {
		return template.getMapper(BoardMapper.class).fileRegist(boardDto);
	}

}
