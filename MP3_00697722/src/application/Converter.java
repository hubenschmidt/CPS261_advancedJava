package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Converter extends Application {
	TextField fahrenheit = new TextField();
	TextField celsius = new TextField();
	Button fToC = new Button("f to c");
	Button cToF = new Button("c to f");

	@Override
	public void start(Stage primaryStage) {

		GridPane gridPane = new GridPane();
		gridPane.setVgap(5);
		gridPane.setHgap(5);
		gridPane.add(new Label("Fahrenheit: "), 0, 0);
		gridPane.add(fahrenheit, 1, 0);
		gridPane.add(new Label("Celsius: "), 0, 1);
		gridPane.add(celsius, 1, 1);
		gridPane.add(fToC, 0, 2);
		gridPane.add(cToF, 1, 2);
		Scene scene = new Scene(gridPane, 400, 400);

		convertTemperature(fToC, cToF, fahrenheit, celsius);

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
			double c;
			c = (Double.parseDouble(celsius.getText()) * 1.8) + 32;
			fahrenheit.setText(String.valueOf(c));
		});

	}

	public static void main(String[] args) {
		launch(args);
	}
}
