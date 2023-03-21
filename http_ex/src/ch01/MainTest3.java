package ch01;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;

public class MainTest3 {

	public static void main(String[] args) {
		
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/posts/19");
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			
			conn.setRequestMethod("GET");
			conn.connect();
			
			int response = conn.getResponseCode();
//			System.out.println(response);
			
			if (response == 200) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				
				String line = null;
				StringBuffer sb = new StringBuffer();
				
				while ( (line = reader.readLine()) != null) {
					sb.append(line);
				}
				
				System.out.println(sb);
				
				Gson gson = new Gson();
				Post post = gson.fromJson(sb.toString(), Post.class);
				
				System.out.println(post);
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
