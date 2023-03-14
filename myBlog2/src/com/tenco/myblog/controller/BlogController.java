package com.tenco.myblog.controller;

import com.tenco.myblog.dto.BlogDto;
import com.tenco.myblog.service.BlogService;

public class BlogController {

	private BlogService blogService;
	
	// 외부에서 오는 요청을 담당함
	
	public BlogController() {
		blogService = new BlogService();
	}
	
	// 글 조회하기
	public BlogDto requestBoardContentById(int id) {
		BlogDto responseDto = blogService.selectByBoardId(id);
		return responseDto;
	}
	
	// 글 삭제하기
	// 사용자가 글쓴이와 동일한지 확인하기 위해 userId도 받음
	public int requestDeleteBoardById(int boardId, int userId) {
		int response = blogService.deleteBoardById(boardId, userId);		
		return response;
	}
	
}
