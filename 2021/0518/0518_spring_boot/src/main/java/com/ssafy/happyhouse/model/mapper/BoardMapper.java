package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.BoardDto;

@Mapper
public interface BoardMapper {

	List<BoardDto> list();

	BoardDto selectOne(int bnum);

	boolean write(BoardDto dto);

	boolean update(BoardDto dto);

	boolean delete(int bnum);

	List<BoardDto> search(String key, String word);

}
