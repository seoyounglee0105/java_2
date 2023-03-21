package com.tenco.myblog.dao;

import com.tenco.myblog.dto.BlogDto;

public interface IBlogDao {
	
	void select(); // 전체 조회
	BlogDto select(int id); // id 기반 조회
	
	int delete(int boardId);
	
}
