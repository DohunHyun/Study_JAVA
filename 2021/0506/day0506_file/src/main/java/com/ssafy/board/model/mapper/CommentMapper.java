package com.ssafy.board.model.mapper;

import java.util.List;

import com.ssafy.board.model.CommentDto;

public interface CommentMapper {
	public int insert(CommentDto commentDto);
	public List<CommentDto> selectList(int bnum);
	public int selectCommentCount(int bnum);
}
