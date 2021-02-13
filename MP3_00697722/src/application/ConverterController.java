package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

public class ConverterController {
	private Converter model;
	private ConverterView view;
	private RadioButton chk;

	public ConverterController() {
	}

	public ConverterController(Converter model) {
		this.model = model;
	}

	public ConverterController(Converter model, ConverterView view) {
		this.model = model;
		this.view = view;
	}

	public double getConverterFahrenheit() {
		return model.getFahrenheit();
	}

	public void setConverterFahrenheit(double fahrenheit) {
		model.setFahrenheit(fahrenheit);
	}

	public double getConverterCelsuis() {
		return model.getCelsius();
	}

	public void setConverterCelsius(double celsius) {
		model.setCelsius(celsius);
	}

	public double getConverterMiles() {
		return model.getMiles();
	}

	public void setConverterMiles(double miles) {
		model.setMiles(miles);
	}

	public double getConverterKilometers() {
		return model.getKilometers();
	}

	public void setConverterKilometers(double kilometers) {
		model.setKilometers(kilometers);
	}

	public double getConverterPounds() {
		return model.getPounds();
	}

	public void setConverterPounds(double pounds) {
		model.setPounds(pounds);
	}

	public double getConverterKilograms() {
		return model.getKilograms();
	}

	public void setConverterKilograms(double kilograms) {
		model.setKilograms(kilograms);
	}

	/**
	 * Selects conversion formula based on radio button selection
	 * 
	 * @param conversion
	 */
	public void setConversion(String selection, TextField english, TextField metric, Button eToM, Button mToE,
			Label labelA, Label labelB) {
		switch (selection) {
		default:
			labelA.setText("Fahrenheit");
			labelB.setText("Celsius");
			convertTemperature(model, eToM, mToE, english, metric);
			break;
		case "Distance":
			labelA.setText("Miles");
			labelB.setText("Kilometers");
			convertDistance(model, eToM, mToE, english, metric);
			break;
		case "Weight":
			labelA.setText("Pounds");
			labelB.setText("Kilograms");
			convertWeight(model, eToM, mToE, english, metric);
			break;
		}
	}

	/**
	 * listens for radio button selection
	 * 
	 * @param toggleGroup
	 * @param converter
	 */
	public void handleToggleGroupEvents(ToggleGroup toggleGroup, ConverterController controller, String selection,
			TextField english, TextField metric, Button eToM, Button mToE, Label labelA, Label labelB) {
		toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) {
				chk = (RadioButton) t1.getToggleGroup().getSelectedToggle();
				view.setSelection(chk.getText());
				setConversion(view.getSelection(), english, metric, eToM, mToE, labelA, labelB);
			}
		});
	}

	/**
	 * Convert english to metric units
	 * 
	 * @param eToM
	 * @param mToE
	 * @param english
	 * @param metric
	 */
	public void convertTemperature(Converter model, Button eToM, Button mToE, TextField english, TextField metric) {
		eToM.setOnAction(e -> {
			double celsius;
			celsius = (Double.parseDouble(english.getText()) - 32) * 5 / 9;
			setConverterCelsius(celsius); // updates model
			metric.setText(String.valueOf(getConverterCelsuis()));
		});
		mToE.setOnAction(e -> {
			double fahrenheit;
			fahrenheit = (Double.parseDouble(metric.getText()) * 1.8) + 32;
			setConverterFahrenheit(fahrenheit); // updates model
			english.setText(String.valueOf(getConverterFahrenheit()));
		});
	}

	public void convertDistance(Converter model, Button eToM, Button mToE, TextField english, TextField metric) {
		eToM.setOnAction(e -> {
			double kilometers;
			kilometers = (Double.parseDouble(english.getText()) * 1.609);
			setConverterKilometers(kilometers); // updates model
			metric.setText(String.valueOf(getConverterKilometers()));
		});
		mToE.setOnAction(e -> {
			double miles;
			miles = (Double.parseDouble(metric.getText()) / 1.609);
			setConverterMiles(miles); // updates model
			english.setText(String.valueOf(getConverterMiles()));
		});
	}

	public void convertWeight(Converter model, Button eToM, Button mToE, TextField english, TextField metric) {
		eToM.setOnAction(e -> {
			double kilograms;
			kilograms = (Double.parseDouble(english.getText()) / 2.205);
			setConverterKilograms(kilograms); // updates model
			metric.setText(String.valueOf(getConverterKilograms()));
		});
		mToE.setOnAction(e -> {
			double pounds;
			pounds = (Double.parseDouble(metric.getText()) * 2.205);
			setConverterPounds(pounds); // updates model
			english.setText(String.valueOf(getConverterPounds()));
		});
	}
}
