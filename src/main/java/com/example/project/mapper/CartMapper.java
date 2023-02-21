package com.example.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.project.dto.CartDTO;

@Mapper
public interface CartMapper {
	// 회원의 전체 장바구니 목록 조회
	public List<CartDTO> cartList(int userId) throws Exception;

	
	// 장바구니 상품 목록의 개수 변경
	
	// 장바구니의 상품 목록 제거
	
	
	
}