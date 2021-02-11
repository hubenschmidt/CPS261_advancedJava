package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Converter extends Application {
	TextField fahrenheit = new TextField();
	TextField celsius = new TextField();
	Button fToC = new Button("f to c");
	Button cToF = new Button("c to f");

	TextField miles = new TextField();
	TextField kilometers = new TextField();
	Button mToK = new Button("m to k");
	Button kToM = new Button("k to m");

	TextField pounds = new TextField();
	TextField kilograms = new TextField();
	Button pToKg = new Button("lb to kg");
	Button kgToP = new Button("kg to lb");

	Scene scene;
	Label fileLabel, dotText;
	RadioButton temperature, distance, weight;
	ToggleGroup sumGroup;

	@Override
	public void start(Stage primaryStage) {
		GridPane layout = new GridPane();
		layout.setVgap(5);
		layout.setHgap(5);

		// Makes Button group
		sumGroup = new ToggleGroup();

		// Adding all radio buttons
		temperature = new RadioButton("A Branch");
		temperature.setToggleGroup(sumGroup);

		distance = new RadioButton("B Branch");
		distance.setToggleGroup(sumGroup);

		weight = new RadioButton("C Branch");
		weight.setToggleGroup(sumGroup);

		GridPane gridPane = new GridPane();

		gridPane.setVgap(5);
		gridPane.setHgap(5);
		gridPane.add(new Label("Fahrenheit: "), 0, 0);
		gridPane.add(fahrenheit, 1, 0);
		gridPane.add(new Label("Celsius: "), 0, 1);
		gridPane.add(celsius, 1, 1);
		gridPane.add(fToC, 0, 2);
		gridPane.add(cToF, 1, 2);
		gridPane.add(new Label("Select: "), 0, 3);
		gridPane.add(temperature, 1, 3);
		gridPane.add(distance, 1, 4);
		gridPane.add(weight, 1, 5);

		String conversion = "temp";

		switch (conversion) {
		case "temp":
			convertTemperature(fToC, cToF, fahrenheit, celsius);
		case "distance":
			convertDistance(mToK, kToM, miles, kilometers);
		case "weight":
			convertWeight(kgToP, pToKg, pounds, kilograms);
		default:
			System.out.println("none");
		}

		Scene scene = new Scene(gridPane, 400, 400);

		primaryStage.setTitle("Converter");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void convertTemperature(Button fToC, Button cToF, TextField fahrenheit, TextField celsius) {
		fToC.setOnAction(e -> {
			double c;
			c = (Double.parseDouble(fahrenheit.getText()) - 32) * 5 / 9;
			celsius.setText(String.valueOf(c));
		});
		cToF.setOnAction(e -> {
			double f;
			f = (Double.parseDouble(celsius.getText()) * 1.8) + 32;
			fahrenheit.setText(String.valueOf(f));
		});
	}

	public void convertDistance(Button mToK, Button kToM, TextField miles, TextField kilometers) {
		mToK.setOnAction(e -> {
			double k;
			k = (Double.parseDouble(miles.getText()) * 1.609);
			kilometers.setText(String.valueOf(k));
		});
		kToM.setOnAction(e -> {
			double m;
			m = (Double.parseDouble(kilometers.getText()) / 1.609);
			miles.setText(String.valueOf(m));
		});
	}

	public void convertWeight(Button pToKg, Button kgToP, TextField pounds, TextField kilograms) {
		pToKg.setOnAction(e -> {
			double kg;
			kg = (Double.parseDouble(pounds.getText()) * 1.609);
			kilograms.setText(String.valueOf(kg));
		});
		kgToP.setOnAction(e -> {
			double m;
			m = (Double.parseDouble(kilometers.getText()) / 1.609);
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}