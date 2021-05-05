package com.ssafy.boot.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.boot.model.mapper.ProductMapper;


@Service
public class ProductService {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private static final int COUNT_PER_PAGE=10;

	public Map<String, Object> makePage(int page){
		// 총 게시글 갯수 디비에서 조회함.
		int totalCount = template.getMapper(ProductMapper.class).selectCount();
		
		// 총 페이지수 계산
		int totalPage = totalCount/COUNT_PER_PAGE;
		if(totalCount%COUNT_PER_PAGE>0)
			totalPage++;
		
		// 화면 하단의 시작 페이지
		int startPage = (page-1)/10*10+1;
				
		int endPage = startPage+9;
		if(endPage>totalPage)
			endPage = totalPage;
		
		// 현재 페이지 게시글 조회
		int startRow = (page-1)*COUNT_PER_PAGE; // limit 의 시작행 번호 계산.
		List<ProductDto> pList =  template.getMapper(ProductMapper.class).selectList(startRow, COUNT_PER_PAGE);
		
		Map<String, Object> pageInfo = new HashMap<>();
		
		pageInfo.put("startPage", startPage);
		pageInfo.put("endPage", endPage);
		pageInfo.put("totalPage", totalPage);
		pageInfo.put("curPage", page);
		pageInfo.put("pList", pList);
	
		return pageInfo;
	}
	
	@Transactional
	public boolean write(ProductDto productDto) {
		if( template.getMapper(ProductMapper.class).insert(productDto)>0)
			return true;
		return false;
	}

	public ProductDto read(int bnum) {
		return  template.getMapper(ProductMapper.class).selectOne(bnum);
	}
}
