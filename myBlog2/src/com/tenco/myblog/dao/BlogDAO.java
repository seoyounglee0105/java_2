package com.tenco.myblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tenco.myblog.dto.BlogDto;
import com.tenco.myblog.dto.BlogDto;
import com.tenco.myblog.utils.DBHelper;

// DB에 접근해서 CRUD 실행
public class BlogDao implements IBlogDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BlogDao() {
		conn = DBHelper.getInstance().getConnection();
		
	}

	@Override
	public void select() {
		
	}

	@Override
	public BlogDto select(int id) {
		BlogDto blogDto = null;
		String query = " SELECT * FROM board WHERE id = ? "; // ?로 바인딩
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				blogDto = new BlogDto();
				blogDto.setId(rs.getInt("id"));
				blogDto.setTitle(rs.getString("title"));
				blogDto.setContent(rs.getString("content"));
				blogDto.setReadCount(rs.getInt("readCount"));
				blogDto.setUserId(rs.getInt("userId"));
			}
		} catch (SQLException e) {
			System.out.println(">> BlogDao select 에러 발생");
			e.printStackTrace();
		}
		return blogDto;
	} // end of select

	@Override
	public int delete(int boardId) {
		int resultRow = 0;
		
		String sql = " DELETE FROM board WHERE id = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardId);
			resultRow = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(">> BlogDao delete에서 에러 발생 <<");
			e.printStackTrace();
		}
		
		
		
		
		
		return resultRow;
	}
	
}
