package com.ssafy.happyhouse.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.model.mapper.BoardMapper;

@Service
public class BoardService {
	@Autowired
	private SqlSession dao;

	public List<BoardDto> list() {
		return dao.getMapper(BoardMapper.class).list();
	}

	public BoardDto read(int bnum) {
		return dao.getMapper(BoardMapper.class).selectOne(bnum);
	}

	public boolean write(BoardDto dto) {
		return dao.getMapper(BoardMapper.class).write(dto);
	}

	public boolean update(BoardDto dto) {
		return dao.getMapper(BoardMapper.class).update(dto);
	}

	public boolean delete(int bnum) {
		return dao.getMapper(BoardMapper.class).delete(bnum);
	}

	public List<BoardDto> search(String key, String word) {
		return dao.getMapper(BoardMapper.class).search(key, word);
	}
	
	
}
