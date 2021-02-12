package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Converter extends Application {

	TextField english = new TextField();
	TextField metric = new TextField();
	Button eToM = new Button("english to metric");
	Button mToE = new Button("metric to english");
	Label labelA = new Label();
	Label labelB = new Label();

	RadioButton temperature, distance, weight;
	ToggleGroup toggleGroup;

	/**
	 * Selects conversion formula based on radio button selection
	 * 
	 * @param conversion
	 */
	public void setConversion(String selection) {
		switch (selection) {
		default:
			labelA.setText("Fahrenheit");
			labelB.setText("Celsius");
			convertTemperature(eToM, mToE, english, metric);
			break;
		case "Distance":
			labelA.setText("Miles");
			labelB.setText("Kilometers");
			convertDistance(eToM, mToE, english, metric);
			break;
		case "Weight":
			labelA.setText("Pounds");
			labelB.setText("Kilograms");
			convertWeight(eToM, mToE, english, metric);
			break;

		}
	}

	/**
	 * Convert english to metric units
	 * 
	 * @param eToM
	 * @param mToE
	 * @param english
	 * @param metric
	 */
	public void convertTemperature(Button eToM, Button mToE, TextField english, TextField metric) {
		eToM.setOnAction(e -> {
			double celsius;
			celsius = (Double.parseDouble(english.getText()) - 32) * 5 / 9;
			metric.setText(String.valueOf(celsius));
		});
		mToE.setOnAction(e -> {
			double fahrenheit;
			fahrenheit = (Double.parseDouble(metric.getText()) * 1.8) + 32;
			english.setText(String.valueOf(fahrenheit));
		});
	}

	public void convertDistance(Button eToM, Button mToE, TextField english, TextField metric) {
		eToM.setOnAction(e -> {
			double kilometers;
			kilometers = (Double.parseDouble(english.getText()) * 1.609);
			metric.setText(String.valueOf(kilometers));
		});
		mToE.setOnAction(e -> {
			double miles;
			miles = (Double.parseDouble(metric.getText()) / 1.609);
			english.setText(String.valueOf(miles));
		});
	}

	public void convertWeight(Button eToM, Button mToE, TextField english, TextField metric) {
		eToM.setOnAction(e -> {
			double kilograms;
			kilograms = (Double.parseDouble(english.getText()) / 2.205);
			metric.setText(String.valueOf(kilograms));
		});
		mToE.setOnAction(e -> {
			double pounds;
			pounds = (Double.parseDouble(metric.getText()) * 2.205);
			english.setText(String.valueOf(pounds));
		});
	}

	/**
	 * Builds and displays GUI
	 * 
	 * @param gridPane
	 * @param english
	 * @param metric
	 * @param eToM
	 * @param mToE
	 * @param labelA
	 * @param labelB
	 */

	public void displayGrid(GridPane gridPane, TextField english, TextField metric, Button eToM, Button mToE,
			Label labelA, Label labelB) {
		gridPane.setVgap(5);
		gridPane.setHgap(5);
		gridPane.setAlignment(Pos.CENTER);
		gridPane.add(labelA, 0, 0);
		gridPane.add(english, 0, 1);
		gridPane.add(labelB, 1, 0);
		gridPane.add(metric, 1, 1);
		gridPane.add(eToM, 0, 2);
		gridPane.add(mToE, 1, 2);
		gridPane.add(new Label("Select: "), 0, 3);
		gridPane.add(temperature, 1, 3);
		gridPane.add(distance, 1, 4);
		gridPane.add(weight, 1, 5);
	}

	@Override
	public void start(Stage primaryStage) {
		GridPane gridPane = new GridPane();

		ToggleGroup toggleGroup = new ToggleGroup();
		temperature = new RadioButton("Temperature");
		temperature.setToggleGroup(toggleGroup);
		temperature.setSelected(true);
		distance = new RadioButton("Distance");
		distance.setToggleGroup(toggleGroup);
		weight = new RadioButton("Weight");
		weight.setToggleGroup(toggleGroup);

		displayGrid(gridPane, english, metric, eToM, mToE, labelA, labelB);

		Scene scene = new Scene(gridPane, 400, 400);

		primaryStage.setTitle("English to Metric Converter");
		primaryStage.setScene(scene);
		primaryStage.show();

		// initialize application with temperature conversion as default selection
		RadioButton initialToggle = (RadioButton) toggleGroup.getSelectedToggle();
		String initVal = initialToggle.getText();
		setConversion(initVal);

		// listen for radio button selection
		toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) {
				RadioButton chk = (RadioButton) t1.getToggleGroup().getSelectedToggle();
				String conversion = chk.getText();
				setConversion(conversion);
			}
		});
	}

	public static void main(String[] args) {
		launch(args);
	}

}
