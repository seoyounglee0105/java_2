package ch01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MainTest4 {

	public static void main(String[] args) {
		URL url;
		try {
			url = new URL("https://jsonplaceholder.typicode.com/todos");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET"); 
			conn.connect(); // Get 방식으로 요청
			
			// 응답
			int statusCode = conn.getResponseCode();       
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line = null;
			StringBuffer sb = new StringBuffer();
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			String result = sb.toString();
			
			Gson gson = new Gson();
			
			// 여러 개의 JSON 객체일 때는 이 방식으로 (하나의 객체일 때는 ToDo.Class 방식으로)
			// 리플렉션 기법 (실행될 때 데이터 타입을 만듦)
			// 1. ArrayList<Object>를 파싱하기 위해서 데이터 타입 선언
			// MainTest에서 사용한 ToDo.class와 같은 역할 (대신 리스트에 넣을 수 있게 복수형)
			Type listType = new TypeToken<List<ToDo>>(){}.getType();
					
			ArrayList<ToDo> toDoList = gson.fromJson(result, listType);
			
			for (ToDo toDo : toDoList) {
				System.out.println(toDo);
			}
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
