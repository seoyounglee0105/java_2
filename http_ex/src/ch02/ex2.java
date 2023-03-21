package ch02;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class ex2 {

	public static void main(String[] args) {
		
		JsonObject jsonObject1 = new JsonObject();
		jsonObject1.addProperty("id", 1);
		jsonObject1.addProperty("title", "청소");
		jsonObject1.addProperty("complete", false);
		
		JsonObject jsonObject2 = new JsonObject();
		jsonObject2.addProperty("id", 2);
		jsonObject2.addProperty("title", "영어공부");
		jsonObject2.addProperty("complete", true);
		
		JsonArray jsonArray1 = new JsonArray();
		jsonArray1.add(jsonObject1);
		jsonArray1.add(jsonObject2);

		JsonObject jsonObjectP = new JsonObject();
		jsonObjectP.add("todoList", jsonArray1); // add의 매개변수 : ("key이름", JsonElement)
		jsonObjectP.addProperty("server_name", "server_1");
		
		System.out.println(jsonObjectP);
	}
	
}
