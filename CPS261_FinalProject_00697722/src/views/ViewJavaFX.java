package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ViewJavaFX {
//	PigGameController controller;
    StackPane stackPane;
    Scene scene;
    Text initialInstructions;
    Text deckEmptyInstructions;
    Text playerName1;
    Text playerName2;
    Group cardsRow;
    FlowPane flowPane;
    Button btnDealCards;
    Button btnShuffleDeck;
    HBox paneForButtons;
    HBox paneForNames;
    BorderPane borderPane;
    ImageView imageView;
    VBox vbox1;
    VBox vbox2;
    Label label1;
    Label label2;
    VBox leftSplit;
    VBox rightSplit;
    HBox instructionsBox;
    SplitPane split;

//	public ViewJavaFX(CardGameController controller) {
//		this.controller = controller;
//	}

    /**
     * displays user interface
     * 
     * @param primaryStage
     */

    public void displayGUI(Stage primaryStage) {
	primaryStage.setTitle("JavaFX Cards");
	stackPane = new StackPane();
	split = new SplitPane();
	initialInstructions = new Text("Click the cards after dealing");
//	controller.getGame().getPlayers().get(0).getName();

	// build card group
	cardsRow = new Group();
	cardsRow.setManaged(true); // automatic layout enabled for cards

	// build buttons
	btnDealCards = new Button("Deal / Refresh");
	btnShuffleDeck = new Button("Shuffle Cards");

	// build player names
//	playerName1 = new Text(controller.getGame().getPlayers().get(0).getName());
//	playerName2 = new Text(controller.getGame().getPlayers().get(1).getName());
//	playerName1.setFont(new Font(36));
//	playerName2.setFont(new Font(36));
//	vbox1 = new VBox();
//	vbox1.getChildren().addAll(playerName1);
//	vbox1.setAlignment(Pos.TOP_LEFT);
//	vbox1.setPadding(new Insets(200, 0, 0, 200));
//	vbox2 = new VBox();
//	vbox2.getChildren().addAll(playerName2);
//	vbox2.setAlignment(Pos.TOP_RIGHT);
//	vbox2.setPadding(new Insets(200, 200, 0, 0));

	// build buttons
	paneForButtons = new HBox(16);// space between buttons is 16
	paneForButtons.getChildren().addAll(btnDealCards, btnShuffleDeck);
	paneForButtons.setAlignment(Pos.CENTER);
	paneForButtons.setPadding(new Insets(0, 0, 20, 0));
	borderPane = new BorderPane();
	borderPane.setBottom(paneForButtons);
	borderPane.setLeft(paneForNames);

	// build instructions box
	initialInstructions.setFont(new Font(64));
	instructionsBox = new HBox();
	instructionsBox.setStyle("-fx-background-color: white");
	instructionsBox.setMaxSize(10, 10);
	instructionsBox.getChildren().addAll(initialInstructions);

	// build player labels on left and right
	label1 = new Label("Player 1");
	label1.setPadding(new Insets(10, 0, 0, 10));
	leftSplit = new VBox(label1);
	label1.setFont(new Font(24));
//	leftSplit.getChildren().addAll(vbox1);
	leftSplit.setStyle("-fx-background-color: cadetblue");
	label2 = new Label("Player 2");
	label2.setPadding(new Insets(10, 0, 0, 10));
	rightSplit = new VBox(label2);
	label2.setFont(new Font(24));
	rightSplit.setStyle("-fx-background-color: cadetblue");
//	rightSplit.getChildren().addAll(vbox2);

	// set up split pane
	split.getItems().addAll(leftSplit, rightSplit);
	split.setDividerPosition(1, 0);

	stackPane.getChildren().addAll(split, borderPane, instructionsBox, cardsRow);
	scene = new Scene(stackPane, 960, 680);
	primaryStage.setScene(scene);
	primaryStage.show();

    }

}
