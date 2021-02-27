package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

class BarChart {

	String filePath = "mp3_hockey_stats.txt";
	HashMap<String, Integer> map;
	String line;

	BufferedReader reader;

	public BarChart() throws IOException {

	}

	void processFile() throws IOException {
		map = new HashMap<String, Integer>();
		try {
			reader = new BufferedReader(new FileReader(filePath));

			// process title
			line = reader.readLine();
			System.out.println("firstline is " + line);

			// process data
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",", 2);
				if (parts.length >= 2) {
					String key = parts[0];
					String value = parts[1];
					map.put(key, Integer.parseInt(value));
				}
			}

			System.out.println(map);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

	}

}