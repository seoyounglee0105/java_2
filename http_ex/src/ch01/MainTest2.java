package ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;

public class MainTest2 {

	public static void main(String[] args) {
		
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/todos/20");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			// http 요청 방식 1) GET   2) POST
			conn.setRequestMethod("GET");
			conn.connect(); 
			
			int statusCode = conn.getResponseCode();
//			System.out.println("statusCode : " + statusCode);
			// 200 : 통신 성공, 404 : 요청 URL이 없어서 통신 실패
			
			// 방어적 코드
			if (statusCode == 200) {
				// 기반 스트림 + 보조 스트림 : 데코레이션 패턴
				// 상속 : 하향식 기능 확장
				// 데코레이션 패턴 : 수평적 기능 확장
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				
				String line = null;
				// 문자열 더하기(append) 연산을 많이 사용해야 할 때에는 StringBuffer 활용
				StringBuffer sb = new StringBuffer();
				
				while ( (line = reader.readLine()) != null) {
					sb.append(line); 
				}
				
//				System.out.println(sb.toString());
				
				// JSON Parsing 해보기 
				// 문자열을 Java Object로 변환하는 것
				
				Gson gson = new Gson();
//				gson.fromJson("파싱해야 할 문자열", 클래스); 
				// 리플렉션 기법 (동적) : 컴파일 시점에는 만들지 말고, 실행 시점에 만들어.
				ToDo todo = gson.fromJson(sb.toString(), ToDo.class);
				System.out.println("id : " + todo.getId());
				System.out.println("userId : " + todo.getUserId());
				System.out.println("title : " + todo.getTitle());
				System.out.println("completed : " + todo.isCompleted());
				
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
