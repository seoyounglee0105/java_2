package ch01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MainTest5 {

	public static void main(String[] args) {
		
		URL url;
		try {
			url = new URL("https://jsonplaceholder.typicode.com/users");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET"); 
			conn.connect(); // Get 방식으로 요청
			
			// 응답
			int statusCode = conn.getResponseCode();          // 404 : 통신 약속 (통신이 실패했다는 의미)
//			System.out.println("statusCode : " + statusCode);
			
			if (statusCode == 200) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				
				String line = null;
				StringBuffer sb = new StringBuffer();
				
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}
				
				String str = sb.toString();
				Gson gson = new Gson();
				
				Type listType = new TypeToken<List<User>>(){}.getType();
				ArrayList<User> userList = gson.fromJson(str, listType);
				
				for (User user : userList) {
					System.out.println(user);
				}
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
