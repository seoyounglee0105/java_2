package com.tenco.myblog.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// mysql 서버와 연결해주는 객체
public class DBHelper {

	private static final String DB_HOST = "localhost";
	private static final String DB_PORT = "3306";
	private static final String DB_DATABASE_NAME = "myBlog";
	private static final String DB_CHARSET = "UTF-8";
	private static final String DB_USER_NAME = "blog_user";
	private static final String DB_PASSWORD = "1q2w3e4r5t";
	
	// Connection이 인터페이스로 설계된 이유
	// 각 프로그램마다 연결하는 방식이 다 다르면 번거롭기 때문에
	// 인터페이스로 표준을 만들어서, 편하게 사용할 수 있게 함
	private Connection conn;
	
	// 싱글톤 패턴 만들기
	private static DBHelper dbHelper;
	
	private DBHelper() {
	}
	
	// static으로 선언하면 클래스명으로 접근 가능
	// static 메서드 내에서는 static 멤버 변수만 사용할 수 있음
	public static DBHelper getInstance() {
		if (dbHelper == null) {
			dbHelper = new DBHelper();
		}
		return dbHelper;		
	}
	
	public Connection getConnection() {
		if(conn == null) {
			// 한번도 생성하지 않았다면 동작
			String urlFormat = "jdbc:mysql://%s:%s/%s?serverTimezone=Asia/Seoul&characterEncoding=%s";
			String url = String.format(urlFormat, DB_HOST, DB_PORT, DB_DATABASE_NAME, DB_CHARSET);
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, DB_USER_NAME, DB_PASSWORD);
				System.out.println(">> DB 연결 완료 <<");
			} catch (Exception e) {
				System.out.println(">> DBHelper 에서 오류가 발생 했어! <<");
				e.printStackTrace();
			}
		}
		// todo 삭제 예정
//		System.out.println("주소 찍어보기 : " + this);
		return conn;
	}
	
	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn = null;
	}
	
	
}
