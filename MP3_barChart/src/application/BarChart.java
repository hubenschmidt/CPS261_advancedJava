package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BarChart {

	Map<String, Integer> goals;
	Scanner fin;

	public BarChart() {

		goals = new HashMap<String, Integer>();

	}

	void getFile() {
		try {
			fin = new Scanner(new FileInputStream("mp3_hockey_stats.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fin != null)
				fin.close();
		}

//		try {
//			fn = new Scanner(new FileInputStream("mp3_hockey_stats.txt"));
//
//			while (fn.hasNext()) {
//				goals.put(fileIn.next(), fileIn.nextInt());
//				fileIn.next(); // Clear scanner
//			}
//		} catch (FileNotFoundException e) {
//			scoreBoard.put("Error: File Not Found", 0);
//		} finally {
//			if (fileIn != null) {
//				fileIn.close();
//			}
//		}
//		getHighScore();

	}

}