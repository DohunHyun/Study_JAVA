package com.ssafy.day0427.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.day0427.dto.BookDto;
import com.ssafy.day0427.repository.BookDao;

@Service
public class BookService {
//	private BookDao dao = new BookDao(); // 절대 이러면 안됨!! 여기는 스프링이야~~
	
	@Autowired
	private BookDao dao;
	
	public List<BookDto> allBook() throws SQLException {
		return dao.selectAll();
	}

	public void add(BookDto book) throws SQLException {
		dao.insert(book);
	}

}
