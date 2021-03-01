package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

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

	void displayChart(Stage stage) {
		stage.setTitle(title);

		NumberAxis xAxis = new NumberAxis();
		xAxis.setLabel("Goals");

		CategoryAxis yAxis = new CategoryAxis();
		yAxis.setLabel("Teams");

		xAxis.setTickLabelRotation(90);

		BarChart barChart = new BarChart(xAxis, yAxis);

		XYChart.Series dataSeries1 = new XYChart.Series<>();
		dataSeries1.setName("2018-2019 season");

//		dataSeries1.getData().add("Test", 1);

		VBox vbox = new VBox(barChart);
		Scene scene = new Scene(vbox, 400, 200);

		stage.setScene(scene);
		stage.setHeight(300);
		stage.setWidth(1200);

		stage.show();

//		bc.setTitle("Country Summary");

	}

}