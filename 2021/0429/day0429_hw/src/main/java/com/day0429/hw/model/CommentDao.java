package com.day0429.hw.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.day0429.hw.model.mapper.CommentMapper;

@Repository
public class CommentDao {
	@Autowired
	private SqlSessionTemplate template;
	
	public int insert(CommentDto commentDto) {
		return template.getMapper(CommentMapper.class).insert(commentDto);
	}
	
	public List<CommentDto> selectList(int bnum) {
		return template.getMapper(CommentMapper.class).selectList(bnum);
	}
	
	public int selectCommentCount(int bnum) {
		return template.getMapper(CommentMapper.class).selectCommentCount(bnum);
	}

}
