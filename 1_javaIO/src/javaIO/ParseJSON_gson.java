package javaIO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class ParseJSON_gson {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String fileName = "files/example_1.json";
		Gson gson = new Gson();

		try (FileReader fileReader = new FileReader(fileName); // try with resources
				JsonReader reader = new JsonReader(fileReader)) {

			// for Object structured JSON data
//			FlowerModel data = gson.fromJson(reader, FlowerModel.class);
//			System.out.println(data);

			// for Array structured JSON data
			FlowerModel[] data = gson.fromJson(reader, FlowerModel[].class);
			for (FlowerModel flower : data) {
				System.out.println(flower);
			}
		}
	}
}
