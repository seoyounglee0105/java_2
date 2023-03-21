package com.tenco.myblog.service;

import com.tenco.myblog.dao.BlogDao;
import com.tenco.myblog.dto.BlogDto;

public class BlogService {
	
	private BlogDao blogDao;
	
	public BlogService() {
		blogDao = new BlogDao();
	}
	
	// 하나의 게시글을 찾는 로직 만들기
	public BlogDto selectByBoardId(int id) {
		BlogDto resultDto = blogDao.select(id);
		return resultDto;
	}
	
	// 사용자 확인은 Service에서
	
	// 게시글 삭제 로직 만들기
	public int deleteBoardById(int boardId, int userId) {
		int resultRow = 0;
		// 검증 : userId 값과 board 테이블의 userId 값이 동일한지
		BlogDto blogDto = selectByBoardId(boardId);
		
		// 방어적 코드
		if (blogDto != null) {
			int blogWriterId = blogDto.getUserId();
			if (blogWriterId == userId) {
				// 삭제 요청
				resultRow = blogDao.delete(boardId);
			}			
		}
		return resultRow;
	}
	
}
