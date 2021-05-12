package com.ssafy.book.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.book.model.BookService;
import com.ssafy.book.model.BookDto;

@RestController
@CrossOrigin("*")
public class BookController {
	@Autowired
	private BookService bservice;
	
	@RequestMapping("/")
	public String index() {
		return "home";
	}
	
	@GetMapping("/bookMain") // @ResponseBody 생략. RestController라서!
	public ResponseEntity<Map<String, Object>> main(@RequestParam(value = "page", defaultValue = "1") int page) {
		Map<String, Object> result = bservice.makePage(page);

		if (result == null || result.get("bList")==null || ((List)result.get("bList")).size()==0 || result.size() == 0)
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}
	
	@GetMapping("/book") // 글 읽기
	public ResponseEntity<BookDto> read(int bnum){
		BookDto result = bservice.read(bnum);
		if(result==null)
			return new ResponseEntity<BookDto>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<BookDto>(result, HttpStatus.OK);
	}
	
	@PostMapping("/book") // 글 쓰기
	public ResponseEntity<String> write(@RequestBody BookDto dto){
		boolean result = bservice.write(dto);
		if(result)
			return new ResponseEntity<String>("success",HttpStatus.OK);
		else
			return new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);
	}

}
