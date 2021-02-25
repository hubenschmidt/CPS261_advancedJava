package application;

import cardgame.controller.CardGameController;
import cardgame.model.Deck;
import cardgame.model.Player;
import cardgame.view.ViewJavaFX;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			Deck deck = new Deck();
			ViewJavaFX viewJavaFX = new ViewJavaFX();
			Player player = new Player("User1");
			CardGameController controller = new CardGameController(viewJavaFX, deck, player);
			viewJavaFX.setController(controller);
			controller.run();

			viewJavaFX.displayGUI();
//			viewJavaFX.displayGUI(primaryStage);
//			viewJavaFX.displayGraphicalUserInterface(primaryStage, controller);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}