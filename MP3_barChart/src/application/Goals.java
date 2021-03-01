package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class Goals {

	String filePath = "mp3_hockey_stats.txt";
	HashMap<String, Integer> map;
	String line;
	String title;
	BufferedReader reader;
//	BarChart barChart;
//	CategoryAxis yAxis;
//	NumberAxis xAxis;
//	XYChart.Series dataSeries1;

	void processFile() throws IOException {
		map = new HashMap<String, Integer>();
		try {
			reader = new BufferedReader(new FileReader(filePath));

			// process title
			title = reader.readLine();

			// process data
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",", 2);
				if (parts.length >= 2) {
					String key = parts[0];
					String value = parts[1];
					map.put(key, Integer.parseInt(value));
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	void displayChart(Stage primaryStage) {
//		primaryStage.setTitle(title);
//
//		xAxis = new NumberAxis();
//		xAxis.setLabel("Goals");
//
//		yAxis = new CategoryAxis();
//		yAxis.setLabel("Teams");

//		xAxis.setTickLabelRotation(90);

		primaryStage.setTitle("BarChart Experiments");

		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel("Devices");

		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Visits");

		BarChart barChart = new BarChart(yAxis, xAxis);

		XYChart.Series dataSeries1 = new XYChart.Series();
		dataSeries1.setName("2014");

		for (Map.Entry mapElement : map.entrySet()) {
			String key = (String) mapElement.getKey();

			Integer value = (Integer) mapElement.getValue();

			dataSeries1.getData().add(new XYChart.Data(value, key));
		}

		barChart.getData().add(dataSeries1);

		VBox vbox = new VBox(barChart);

		Scene scene = new Scene(vbox, 400, 200);

		primaryStage.setScene(scene);
		primaryStage.setHeight(300);
		primaryStage.setWidth(1200);

		primaryStage.show();

	}

}