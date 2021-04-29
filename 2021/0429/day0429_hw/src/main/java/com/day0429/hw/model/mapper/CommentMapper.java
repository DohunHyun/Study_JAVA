package com.day0429.hw.model.mapper;

import java.util.List;

import com.day0429.hw.model.CommentDto;

public interface CommentMapper {
	public int insert(CommentDto commentDto);
	public List<CommentDto> selectList(int bnum);
	public int selectCommentCount(int bnum);
}
