package ch02;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonMainTest3 {

	public static void main(String[] args) {
		// 문자열 "[]" 상태 
		
		JsonArray jsonArray = new JsonArray();
		// [] <- 안에 jsonObject({})
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("name", "티모");
		
		System.out.println(jsonArray);
		System.out.println("--------------");
		System.out.println(jsonObject);
		
		// jsonArray에 jsonObject 넣기
		jsonArray.add(jsonObject);
		jsonArray.add(jsonObject);
		jsonArray.add(jsonObject);
		System.out.println("--------------");
		System.out.println(jsonArray);
		
		JsonArray jsonArray2 = new JsonArray();
		JsonObject jsonObjectTodo1 = new JsonObject();
		jsonObjectTodo1.addProperty("userId", 1);
		jsonObjectTodo1.addProperty("id", 1);
		jsonObjectTodo1.addProperty("title", "delectus aut autem");
		jsonObjectTodo1.addProperty("completed", false);
		
		JsonObject jsonObjectTodo2 = new JsonObject();
		jsonObjectTodo2.addProperty("userId", 1);
		jsonObjectTodo2.addProperty("id", 2);
		jsonObjectTodo2.addProperty("title", "quis ut nam facilis et officia qui");
		jsonObjectTodo2.addProperty("completed", false);
		
		JsonObject jsonObjectTodo3 = new JsonObject();
		jsonObjectTodo3.addProperty("userId", 1);
		jsonObjectTodo3.addProperty("id", 3);
		jsonObjectTodo3.addProperty("title", "fugiat veniam minus");
		jsonObjectTodo3.addProperty("completed", false);
		
		jsonArray2.add(jsonObjectTodo1);
		jsonArray2.add(jsonObjectTodo2);
		jsonArray2.add(jsonObjectTodo3);
		
		System.out.println("--------------");
		System.out.println(jsonArray2);
		
		// JsonArray에서 JsonObject 꺼내는 방법
		JsonObject targetObject = jsonArray2.get(0).getAsJsonObject();
		System.out.println(targetObject);
		String strName = targetObject.get("name").getAsString();
		
	}
	
}
