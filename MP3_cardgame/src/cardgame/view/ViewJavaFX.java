package cardgame.view;

import cardgame.controller.CardGameController;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
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
		cardsRow.setManaged(true); // automatic layout enabled for cards

		btnDealCards = new Button("Deal");
		btnShuffleDeck = new Button("Shuffle");

		btnDealCards.setOnAction((ActionEvent e) -> {
			if (initialInstructions != null) {
				stackPane.getChildren().remove(initialInstructions);
				initialInstructions = null;
			}

			cardsRow.getChildren().clear();

			for (int i = 0; i < controller.getCards().size(); i++) {
				int card_width = controller.getCards().get(i).getWidth();
				double position_x = 100 + (card_width + 25) * i;
				double position_y = 100;
				controller.getCards().get(i).set_card_position(position_x, position_y);

				// workaround for accessing counter variable inside inner class:
				final int inner_i = i;

				controller.getCards().get(i).setOnMouseClicked(new EventHandler() {
					@Override
					public void handle(Event e) {
						controller.getCards().get(inner_i).flip();
						System.out.println(controller.getCards().get(inner_i).isFaceUp());

						// if card becomes face up on mouse click, flip card and display front
						if (controller.getCards().get(inner_i).isFaceUp()) {
							controller.getCards().get(inner_i)
									.setImage(controller.getCards().get(inner_i).getCardFront());
							// else if card becomes face down on mouse click, flip card and display back
						} else if (!controller.getCards().get(inner_i).isFaceUp()) {
							controller.getCards().get(inner_i)
									.setImage(controller.getCards().get(inner_i).getCardBack());
						}

					}
				});

				cardsRow.getChildren().add(controller.getCards().get(i));
			}
		});

		btnShuffleDeck.setOnAction((ActionEvent e) -> {
			controller.reshuffleDeck();
		});

		HBox paneForButtons = new HBox(16);// space between buttons is 16
		paneForButtons.getChildren().addAll(btnDealCards, btnShuffleDeck);
		paneForButtons.setAlignment(Pos.CENTER);
		paneForButtons.setPadding(new Insets(0, 0, 20, 0));
		borderPane = new BorderPane();
		borderPane.setBottom(paneForButtons);
		initialInstructions.setFont(new Font(24));
		stackPane.getChildren().addAll(borderPane, initialInstructions, cardsRow);
		scene = new Scene(stackPane, 860, 600);

//		scene.setOnMouseClicked((e) -> {
//			double clicked_x = e.getSceneX();
//			double clicked_y = e.getSceneY();
//			
//			
//			for (int i = 0; i < cardsRow.getChildren().size(); i++) {
//				if (cardsRow.getChildren().contains()))
//			}
//
////			if (cardsRow.getChildren().size() == controller.getCards().size()) {
////				for (Node cardAsNode : cardsRow.getChildren()) {
////					Card cardInRow = (Card) cardAsNode;
////					if (cardInRow.contains_point(clicked_x, clicked_y)) {
////						cardsRow.flip();
////					}
////				}
////			}
//
//		});

		primaryStage.setScene(scene);
		primaryStage.show();

	}

}