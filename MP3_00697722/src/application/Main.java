package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Converter model = new Converter();
			ConverterView view = new ConverterView();
			ConverterController controller = new ConverterController(model, view);
			view.displayGraphicalUserInterface(primaryStage, controller);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}