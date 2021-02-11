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

public class RB extends Application {

	Scene scene;
	String fileName;
	Button button;
	Label fileLabel, dotText;
	TextField fileNameText;
	RadioButton totalRadio, aRadio, bRadio, cRadio;
	ToggleGroup sumGroup;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		GridPane layout = new GridPane();
		layout.setVgap(5);
		layout.setHgap(5);

		// Adds button
		button = new Button("Sum file");
		button.setOnAction(e -> {
			fileName = "C:\\Users\\Luke\\Desktop\\" + fileNameText.getText() + ".txt";
		});
		layout.setConstraints(button, 1, 1);

		// Adds label
		fileLabel = new Label("File name: ");
		layout.setConstraints(fileLabel, 0, 0);

		// Adds TextField
		fileNameText = new TextField();
		fileNameText.setPrefWidth(100);
		layout.setConstraints(fileNameText, 1, 0);

		// Adds Label
		dotText = new Label(".txt");
		layout.setConstraints(dotText, 2, 0);

		// Makes Button group
		sumGroup = new ToggleGroup();

		// Adding all radio buttons
		totalRadio = new RadioButton("Total");
		totalRadio.setToggleGroup(sumGroup);
		totalRadio.setSelected(true);
		layout.setConstraints(totalRadio, 1, 2);

		aRadio = new RadioButton("A Branch");
		totalRadio.setToggleGroup(sumGroup);
		layout.setConstraints(aRadio, 1, 3);

		bRadio = new RadioButton("B Branch");
		totalRadio.setToggleGroup(sumGroup);
		layout.setConstraints(bRadio, 1, 4);

		cRadio = new RadioButton("C Branch");
		totalRadio.setToggleGroup(sumGroup);
		layout.setConstraints(cRadio, 1, 5);

		// Adds components to scene
		layout.getChildren().addAll(fileLabel, fileNameText, button, dotText, totalRadio, aRadio, bRadio, cRadio);
		scene = new Scene(layout, 230, 185);

		primaryStage.setScene(scene);
		primaryStage.show();
	}
}