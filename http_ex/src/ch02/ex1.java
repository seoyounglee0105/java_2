package ch02;

import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ex1 {
public static void main(String[] args) {
	JsonArray array = new JsonArray();
	
	Scanner scanner = new Scanner(System.in);
	
	for (int i = 0; i < 3; i++) {
		JsonObject object = new JsonObject();
		System.out.println("이름 입력");
		String name = scanner.nextLine();
		System.out.println("나이 입력");
		int age = scanner.nextInt();
		scanner.nextLine();
		System.out.println("주소 입력");
		String address = scanner.nextLine();	
		
		object.addProperty("name", name);
		object.addProperty("age", age);
		object.addProperty("address", address);
		array.add(object);
	}
	
	System.out.println(array);
	
	
	
	
}
}
