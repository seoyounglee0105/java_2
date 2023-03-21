package ex01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MainTest {

	public static void main(String[] args) {

		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/albums");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			int statusCode = conn.getResponseCode();

			if (statusCode == 200) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

				String line = null;
				StringBuffer sb = new StringBuffer();

				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}

				String resultStr = sb.toString();
				Gson gson = new Gson();

				Type listType = new TypeToken<List<AlbumDto>>(){}.getType();
				ArrayList<AlbumDto> albumList = gson.fromJson(resultStr, listType);

				// 리스트에 있는 객체들을 DB에 담기
				AlbumController albumController = new AlbumController();

				for (AlbumDto albumDto : albumList) {
					albumController.requestAddAlbum(albumDto);
					System.out.println(albumDto);
				}

			} // end of if

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
