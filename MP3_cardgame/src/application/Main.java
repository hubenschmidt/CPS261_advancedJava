package application;

import java.util.ArrayList;

import cardgame.controller.CardGameController;
import cardgame.model.Player;
import cardgame.view.ViewJavaFX;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			ArrayList<Player> players = new ArrayList<>();
			Player p1 = new Player("William");
			players.add(p1);
//			Player p2 = new Player("Joe");
//			players.add(p2);

			int cardsPerHand = 4;

			CardGameController controller = new CardGameController(cardsPerHand, players);

			ViewJavaFX viewJavaFX = new ViewJavaFX();

//			viewJavaFX.displayGUI();
			viewJavaFX.displayGUI(primaryStage);
//			viewJavaFX.displayGraphicalUserInterface(primaryStage, controller);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}