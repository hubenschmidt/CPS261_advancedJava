package cardgame.view;

import cardgame.controller.CardGameController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//class ImageStore {
//	static Image cardBack;
//	static HashMap<String, Image> cardFaces;
//}

class Card extends ImageView {
	private boolean revealed = false;
	private int card_number;
	private Image card_back;
	private Image card_front;

	public Card(int card_number) {
		super();
		this.card_number = card_number;
		card_back = new Image("card/backCard.png");
		super.setImage(getCardImage());
	}

	public Image getCardImage() {
		if (!revealed) {
			return card_back;
		}
		return card_front;
	}
}

public class ViewJavaFX {
	CardGameController controller;

	Text instructions = new Text("Click the cards");
	Group row_of_cards = new Group();
//	Image cardBack = new Image("");

	BorderPane border;
	HBox hbox;
	VBox vbox;

	GridPane gridPane;
	private Stage primaryStage;
	private Button buttonDealCards, buttonReshuffleDeck;
	private Scene scene;
	private String selection;

	public void setController(CardGameController controller) {
		this.controller = controller;
	}

	public void displayPlayerName() {
		System.out.println(controller.getPlayer().getName());
	}

	public void promptFlip() {
		System.out.println("Press return to flip cards");
		controller.flipCards();
	}

	public void promptForNewGame() {
	};

	public void promptToReshuffleDeck() {
	};

	public void showCardForPlayer(String rank, String suit) {
	};

	public String getSelection() {
		return selection;
	}

	public void setSelection(String selection) {
		this.selection = selection;
	}

	public void buildGrid(GridPane gridPane, Button eToM, Button mToE) {
		gridPane.setVgap(5);
		gridPane.setHgap(5);
		gridPane.setAlignment(Pos.CENTER);
		gridPane.add(buttonDealCards, 0, 2);
		gridPane.add(buttonReshuffleDeck, 1, 2);

	}

	public void dealCardsButton() {
		buttonDealCards.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				controller.startGame();

			}
		});
	}

	public void displayGUI() {
//		File tempFile = new File("card/1.png");
//		boolean exists = tempFile.exists();
//		System.out.println(exists);

		primaryStage = new Stage();
		gridPane = new GridPane();
		buttonDealCards = new Button("deal cards");
		buttonReshuffleDeck = new Button("reshuffle deck");
		scene = new Scene(gridPane, 800, 800);
		buildGrid(gridPane, buttonDealCards, buttonReshuffleDeck);
		primaryStage.setTitle("Card Game");
		primaryStage.setScene(scene);
		primaryStage.show();
		dealCardsButton();

		Group cardGroup = new Group();
		cardGroup.setManaged(false);
//		cardGroup.getChildren().addAll()
	}

}
