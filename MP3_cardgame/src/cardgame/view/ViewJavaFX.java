package cardgame.view;

import cardgame.controller.CardGameController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ViewJavaFX implements View {
//	Stage stage;
	CardGameController controller;
	StackPane stackPane;
	Scene scene;
	Text initialInstructions;
	Group cardsRow;
	FlowPane flowPane;
	Button btnDealCards;
	Button btnShuffleDeck;
	HBox paneForButtons;
	BorderPane borderPane;
	ImageView imageView;

	public ViewJavaFX(CardGameController controller) {
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
		stackPane = new StackPane();
		initialInstructions = new Text("Click the cards after dealing.");
		cardsRow = new Group();

		btnDealCards = new Button("Deal");
		btnShuffleDeck = new Button("Shuffle");

		System.out.println(controller.getCards().size());
		System.out.println(controller.getTest());

//		for (Card card : controller.dealCards()) {
//			System.out.println(card);
//
//
//		}

//		for (int i = 0; i < controller.dealCards().size(); i++) {
//			System.out.println(controller.dealCards().get(i));
//			cardsRow.getChildren().add(controller.dealCards().get(i));
//		}

//		btnDealCards.setOnAction((ActionEvent e) -> {
//			if (initialInstructions != null) {
//				stackPane.getChildren().remove(initialInstructions);
//				initialInstructions = null;
//			}
//
//			cardsRow.getChildren().clear();
//
////			for (Card card : controller.dealCards()) {
////
////				cardsRow.getChildren().add(card);
////			}
//
//			for (int i = 0; i < controller.dealCards().size(); i++) {
//				System.out.println(controller.dealCards().get(i));
//				cardsRow.getChildren().add(controller.dealCards().get(i));
//			}
//
//		});

		HBox paneForButtons = new HBox(16);// space between buttons is 16
		paneForButtons.getChildren().addAll(btnDealCards, btnShuffleDeck);
		paneForButtons.setAlignment(Pos.CENTER);
		paneForButtons.setPadding(new Insets(0, 0, 20, 0));
		borderPane = new BorderPane();
		borderPane.setBottom(paneForButtons);
		initialInstructions.setFont(new Font(24));
		stackPane.getChildren().addAll(borderPane, initialInstructions);
		scene = new Scene(stackPane, 860, 600);

		primaryStage.setScene(scene);
		primaryStage.show();

	}

}