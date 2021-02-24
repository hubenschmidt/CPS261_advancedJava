package cardgame;

import cardgame.controller.CardGameController;
import cardgame.model.Deck;
import cardgame.model.Player;
import cardgame.view.ViewCLI;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Deck deck = new Deck();
			ViewCLI view = new ViewCLI();
			Player player = new Player("User1");
			CardGameController controller = new CardGameController(view, deck, player);
			view.setController(controller);
			controller.run();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);

	}

}