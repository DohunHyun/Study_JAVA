package com.ssafy.happyhouse.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.model.BoardService;

@RestController
@CrossOrigin("*")
public class BoardController {
	@Autowired
	private BoardService bservice;
	
	@GetMapping("/board/list")
	public ResponseEntity<List<BoardDto>> list() {
		List<BoardDto> result = bservice.list();
		
		if(result==null)
			return new ResponseEntity<List<BoardDto>>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<BoardDto>>(result, HttpStatus.OK);
	}
	
	@GetMapping("/board/{bnum}") // 글 읽기
	public ResponseEntity<BoardDto> read(@PathVariable("bnum") int bnum){
		BoardDto result = bservice.read(bnum);
		if(result==null)
			return new ResponseEntity<BoardDto>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<BoardDto>(result, HttpStatus.OK);
	}
	
	@PostMapping("/board") // 글 쓰기
	public ResponseEntity<String> write(@RequestBody BoardDto dto){
		boolean result = bservice.write(dto);
		if(result)
			return new ResponseEntity<String>("success",HttpStatus.OK);
		else
			return new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/board") // 글 수정하기
	public ResponseEntity<String> update(@RequestBody BoardDto dto){
		
		boolean result = bservice.update(dto);
		if(result)
			return new ResponseEntity<String>("success",HttpStatus.OK);
		else
			return new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/board/{bnum}") // 글 삭제하기
	public ResponseEntity<String> delete(@PathVariable("bnum") int bnum){
		System.out.println(bnum);
		boolean result = bservice.delete(bnum);
		if(result)
			return new ResponseEntity<String>("success",HttpStatus.OK);
		else
			return new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/board/search")
	public ResponseEntity<List<BoardDto>> search(@RequestParam(value="key") String key,
			@RequestParam("word") String word) {
		System.out.println(key+" "+word);
		List<BoardDto> result = bservice.search(key, word);
		for(int i=0;i<result.size();i++) {
			System.out.println(result.get(i).getBtitle());
		}
		if(result==null)
			return new ResponseEntity<List<BoardDto>>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<BoardDto>>(result, HttpStatus.OK);
	}

}
