package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class Goals {
	String filePath = "mp3_hockey_stats.txt";
	LinkedHashMap<String, Integer> map;
	String line;
	String title;
	BufferedReader reader;

	void processFile() throws IOException {
		map = new LinkedHashMap<String, Integer>();
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
		primaryStage.setTitle(title);

		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel("Teams");

		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Goals");

		BarChart barChart = new BarChart(yAxis, xAxis);
		barChart.setLegendVisible(false);

		XYChart.Series dataSeries1 = new XYChart.Series();
		dataSeries1.setName("2018-2019");

		for (Map.Entry mapElement : map.entrySet()) {
			String key = (String) mapElement.getKey();
			Integer value = (Integer) mapElement.getValue();
			dataSeries1.getData().add(new XYChart.Data(value, key));
			System.out.println(value + " : " + key);
		}

		barChart.getData().add(dataSeries1);

		for (Node n : barChart.lookupAll(".default-color0.chart-bar")) {
			n.setStyle("-fx-bar-fill: rgb(69,156,218)");
		}

		VBox vbox = new VBox(barChart);
		Scene scene = new Scene(vbox);
		primaryStage.setScene(scene);
		primaryStage.setHeight(300);
		primaryStage.setWidth(500);
		primaryStage.show();
	}

}