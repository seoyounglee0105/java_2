package ch01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
public class MainTest1 {

	public static void main(String[] args) {
		// Client -> Web Server -> DataBase
		// Client <- Web Server <- DataBase
		
		// 기본 자바 표준 기술인 http 클래스를 이용하여 http 통신을 통해서
		// 데이터를 요청하고 응답받아 보는 기술 확인하기
		
		// https : 프로토콜 
		// jsonplaceholder.typicode.com : 회사의 호스트 주소
		
		// http 통신 준비물
		// URL 클래스
		// HttpURLConnection 클래스
		
		// Ctrl + T : 해당 클래스의 계층 구조 확인 가능 -> 상속 관계 확인
		// url.openConnection()하면 URLConnection이 반환되고,
		// URLConnecttion은 HttpURLConnection의 부모
		
		try {
			// base url : https://jsonplaceholder.typicode.com/
			// end point : todos
			URL url = new URL("https://jsonplaceholder.typicode.com/todos/2");
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET"); 
			conn.connect(); // Get 방식으로 요청
			
			// 응답
			int statusCode = conn.getResponseCode();          // 404 : 통신 약속 (통신이 실패했다는 의미)
			System.out.println("statusCode : " + statusCode); // 200 : 통신 약속 (통신이 성공했다는 의미)
			
			// IO			
			// conn.getInputStream() : 1 byte씩 데이터를 읽음 (읽기 대상 : url)
			// BufferedReader() : 한 줄씩 데이터를 읽음 (\n 전까지)
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line = null;
			
			// reader.readLine()은 null을 만나면 더 이상 읽을 데이터가 없다는 뜻
			while (( line = reader.readLine() ) != null) {
				sb.append(line + "\n"); // 문자열 더하기
			}
			
			String resultStr = sb.toString(); // StringBuffer를 String 타입으로 변환
//			System.out.println(resultStr);
			
			// 문자열 추출해보기
			String[] strArr = resultStr.split(",\n");
			String[] titleArr = new String[2];
			
			// 가져온 데이터들을 모델링해서 클래스에 담자.
			ToDo todo = new ToDo();
			for (String s : strArr) {
				if (s.contains("title")) {
					titleArr = s.split(": ");
				} else if (s.contains("userId")) {
					todo.setUserId(Integer.parseInt(s.split(": ")[1]));
				} else if (s.contains("id")) {
					todo.setId(Integer.parseInt(s.split(": ")[1]));
				} else {
					todo.setCompleted(Boolean.parseBoolean(s.split(": ")[1]));
				}
			}
			titleArr[1] = titleArr[1].substring(1, titleArr[1].length() - 1);
			System.out.println("구한 title : " + titleArr[1]);
			todo.setTitle(titleArr[1]);
			
			System.out.println(todo);
			
			// Gson을 활용하면 훨씬 더 쉽게 데이터를 가져올 수 있음
			
			// gson의 대표적인 사용법 및 개념 알아보기
			Gson gson = new Gson();
			
			// JSON
			// JavaScript Object Notation
			// 경량의 데이터 교환 형식
			// 키-값 쌍 or 배열 형태의 데이터를 텍스트 형식으로 표현하는 것
			// 키에는 항상 쌍따옴표 ""
			// -> "Key명" : Value
			
			// javaScript의 객체 : { }
			// javaScript의 배열(리스트) : [ ]
			
			// 파싱
			// 원하는 데이터 형식으로 변환하는 것
			
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
