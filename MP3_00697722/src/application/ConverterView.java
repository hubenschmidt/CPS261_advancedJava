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

public class ConverterView extends Application {
	Converter model;
	ConverterController controller;
	GridPane gridPane;
	ToggleGroup toggleGroup;
	TextField english, metric;
	Button eToM, mToE;
	Label labelA, labelB;
	RadioButton temperature, distance, weight;
	Scene scene;
	RadioButton initialToggle;
	String initVal;
	RadioButton chk;
	String conversion;

	public void displayConverter() {
		System.out.println("displayConverter default constructor");
	}

	// probably create overloaded method for each parameter type unless I can define
	// a generic and reflect it as such
	public void displayConverter(double fahrenheit, double celsius, double miles, double kilometers, double pounds,
			double kilograms) {
		System.out.println("Conversion results: ");
		System.out.println("Fahrenheit: " + fahrenheit);
		System.out.println("Celsius: " + celsius);
		System.out.println("Miles: " + miles);
		System.out.println("Kilometers: " + kilometers);
		System.out.println("Pounds: " + pounds);
		System.out.println("Kilograms" + kilograms);

	}

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
	public void start(Stage primaryStage) throws Exception {
		model = new Converter(); // detangle this mess from view
		controller = new ConverterController(model);
		gridPane = new GridPane();
		toggleGroup = new ToggleGroup();
		english = new TextField();
		metric = new TextField();
		eToM = new Button("english to metric");
		mToE = new Button("metric to english");
		labelA = new Label();
		labelB = new Label();
		temperature = new RadioButton("Temperature");
		temperature.setToggleGroup(toggleGroup);
		temperature.setSelected(true);
		distance = new RadioButton("Distance");
		distance.setToggleGroup(toggleGroup);
		weight = new RadioButton("Weight");
		weight.setToggleGroup(toggleGroup);

		displayGrid(gridPane, english, metric, eToM, mToE, labelA, labelB);

		scene = new Scene(gridPane, 400, 400);

		primaryStage.setTitle("English to Metric Converter");
		primaryStage.setScene(scene);
		primaryStage.show();

		// initialize application with temperature conversion as default selection
		initialToggle = (RadioButton) toggleGroup.getSelectedToggle();
		initVal = initialToggle.getText();
		controller.setConversion(model, initVal, english, metric, eToM, mToE, labelA, labelB);

		// listen for radio button selection
		toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) {
				chk = (RadioButton) t1.getToggleGroup().getSelectedToggle();
				conversion = chk.getText();
				controller.setConversion(model, conversion, english, metric, eToM, mToE, labelA, labelB);
			}
		});

	}

	public static void main(String[] args) {
		launch(args);
	}

}
