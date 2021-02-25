package cardgame.view;

import java.util.List;

import cardgame.controller.CardGameController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ViewJavaFX {
	CardGameController controller;

	Text instructions = new Text("Click the cards");
	Group row_of_cards = new Group();

	BorderPane border;
	HBox hbox;
	VBox vbox;

	GridPane gridPane;
	Group root;
	private Stage primaryStage;
	private Button buttonDealCards, buttonReshuffleDeck;
	private Scene scene;

	public void setController(CardGameController controller) {
		this.controller = controller;
	}

	public void displayPlayerName() {
//		System.out.println(controller.getPlayer().getName());
	}

	public void promptFlip() {
		System.out.println("Press return to flip cards");
		// button to flip cards goes here
		controller.flipCards();
	}

	public void promptForNewGame() {
	};

	public void promptToReshuffleDeck() {
	};

	public void displayCardsFaceDown(List<Image> cards) {

		System.out.println("display");
		ImageView iv1 = new ImageView();
		iv1.setImage(cards.get(0));
		Group root = new Group();
		Scene scene = new Scene(root);
		scene.setFill(Color.BLACK);
		HBox box = new HBox();
		box.getChildren().add(iv1);
//		box.getChildren().add(iv2);
//		box.getChildren().add(iv3);
		root.getChildren().add(box);

	}

//	public void showCardForPlayer(String rank, String suit, int index) {
	public void showCardForPlayer(int index) {
//		System.out.println(index);

//		controller.setCardFront(new Image("card_images/" + index + ".png"));

	};

	public void dealCardsButton() {
		buttonDealCards.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				controller.startGame();

			}
		});
	}

	public void displayGUI() {
		primaryStage = new Stage();
//		gridPane = new GridPane();
		buttonDealCards = new Button("deal cards");
//		buttonReshuffleDeck = new Button("reshuffle deck");
//		scene = new Scene(gridPane, 800, 800);
//		gridPane.setVgap(5);
//		gridPane.setHgap(5);
//		gridPane.setAlignment(Pos.CENTER);
//		gridPane.add(buttonDealCards, 0, 2);
//		gridPane.add(buttonReshuffleDeck, 1, 2);

		primaryStage.setTitle("Card Game");
//		primaryStage.setScene(scene);
		primaryStage.show();
		dealCardsButton();
		displayCardsFaceDown(controller.getCards());

	}

}
