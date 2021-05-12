package com.ssafy.book.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.book.model.BookDto;


public interface BookMapper {
	public int insert(BookDto dto);
	public BookDto selectOne(int bnum);
	public List<BookDto> selectList(@Param("startRow")int startRow, @Param("count")int count);
	public int selectCount();

}
