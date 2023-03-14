package com.tenco.myblog;

import com.tenco.myblog.controller.BlogController;
import com.tenco.myblog.dto.BlogDto;

public class MainTest1 {

	
	public static void main(String[] args) {
		BlogController blogController = new BlogController();
		
		// select 테스트
//		BlogDto dto = blogController.requestBoardContentById(30);
//		System.out.println(dto);
		
		// delete 테스트
		int result = blogController.requestDeleteBoardById(4, 9);
		System.out.println(result);
	}
	
}
