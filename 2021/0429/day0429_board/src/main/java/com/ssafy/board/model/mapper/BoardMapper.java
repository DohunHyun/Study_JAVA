package com.ssafy.board.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.board.model.BoardDto;

public interface BoardMapper {
	public int insert(BoardDto dto);
	public BoardDto selectOne(int bnum);
	public List<BoardDto> selectList(@Param("startRow")int startRow, @Param("count")int count);
	public int selectCount();

}
