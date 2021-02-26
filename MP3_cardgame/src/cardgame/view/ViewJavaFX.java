package cardgame.view;

import cardgame.controller.CardGameController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ViewJavaFX implements View {
//	Stage stage;
	Scene scene;
	CardGameController controller;
	StackPane stackPane = new StackPane();
	Text initialInstructions = new Text("Click the cards after dealing.");
	Group cardsRow = new Group();
	Button btnDealCards = new Button("Deal");
	Button btnShuffleDeck = new Button("Shuffle");

	public void setController(CardGameController controller) {
		this.controller = controller;
	}

	public void displayPlayerName() {
		// TODO Auto-generated method stub

	}

	public void displayCards() {

	}

	public void promptFlip() {
		// TODO Auto-generated method stub

	}

	public void promptForNewGame() {
		// TODO Auto-generated method stub

	}

	public void promptToReshuffleDeck() {
		// TODO Auto-generated method stub

	}

	public void showCardForPlayer(String rank, String suit) {
		// TODO Auto-generated method stub

	}

	public void displayGUI(Stage primaryStage) {
		primaryStage.setTitle("ViewJavaFX.java");
		scene = new Scene(stackPane, 910, 600);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}