package com.ssafy.boot.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.boot.model.ProductDto;

@Mapper
public interface ProductMapper {
	public int insert(ProductDto dto);
	public ProductDto selectOne(int bnum);
	public List<ProductDto> selectList(@Param("startRow") int startRow, @Param("count") int count);
	public int selectCount();
}
