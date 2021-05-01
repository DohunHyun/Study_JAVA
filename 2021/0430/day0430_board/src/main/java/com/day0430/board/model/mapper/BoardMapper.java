package com.day0430.board.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.day0430.board.model.BoardDto;

public interface BoardMapper {
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int delete(BoardDto dto);
	public BoardDto selectOne(int bnum);
	public List<BoardDto> selectList(@Param("startRow")int startRow, @Param("count")int count);
	public int selectCount();

}
