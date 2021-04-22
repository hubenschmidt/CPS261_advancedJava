package views;

import controllers.GameController;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ViewJavaFX {
    GameController controller;
    StackPane stackPane;
    Scene scene;
    Text initialInstructions;
    Text playerName1;
    Text playerName2;
    FlowPane flowPane;
    Button btnRoll;
    Button btnHold;
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

    public ViewJavaFX(GameController controller) {
	this.controller = controller;
    }

    public void rollDice() {
	btnRoll.setOnAction((ActionEvent e) -> {
	    controller.roll();
	});
    }

    /**
     * displays user interface
     * 
     * @param primaryStage
     */

    public void displayGUI(Stage primaryStage) {
	primaryStage.setTitle("A Game of Pig");
	stackPane = new StackPane();
	split = new SplitPane();

	Image image = new Image("/images/dice1.png");
	ImageView die = new ImageView();
	die.setImage(image);

	// build buttons
	btnRoll = new Button("Roll");
	btnHold = new Button("Hold");
	btnRoll.setMinWidth(100);
	btnHold.setMinWidth(100);

	// build player names
	playerName1 = new Text(controller.getGame().getPlayers().get(0).getName());
	playerName1.setFill(Color.web("#1F51FF"));
	playerName2 = new Text(controller.getGame().getPlayers().get(1).getName());
	playerName1.setFont(new Font(36));
	playerName2.setFont(new Font(36));
	vbox1 = new VBox();
	vbox1.getChildren().addAll(playerName1);
	vbox1.setAlignment(Pos.TOP_LEFT);
	vbox1.setPadding(new Insets(0, 0, 0, 100));
	vbox2 = new VBox();
	vbox2.getChildren().addAll(playerName2);
	vbox2.setAlignment(Pos.TOP_RIGHT);
	vbox2.setPadding(new Insets(0, 100, 0, 0));

	// build buttons
	paneForButtons = new HBox(16);// space between buttons is 16
	paneForButtons.getChildren().addAll(btnRoll, btnHold);
	paneForButtons.setAlignment(Pos.CENTER);
	paneForButtons.setPadding(new Insets(0, 0, 20, 0));
	borderPane = new BorderPane();
	borderPane.setBottom(paneForButtons);
	borderPane.setLeft(paneForNames);

	rollDice();

	// build player labels on left
	label1 = new Label("Player 1");
	label1.setTextFill(Color.web("#1F51FF"));
	label1.setPadding(new Insets(10, 0, 0, 10));
	leftSplit = new VBox(label1);
	label1.setFont(new Font(24));

	// Creating Labels for scores
	Label roundScoreLabel1 = new Label("Round score");
	roundScoreLabel1.setTextFill(Color.web("#d3d3d3"));
	Label totalLabel1 = new Label("Total");
	totalLabel1.setTextFill(Color.web("#d3d3d3"));

	// Creating TextFields for scores
	TextField roundScore1 = new TextField();
	TextField total1 = new TextField();

	// Creating a Grid Pane
	GridPane gridPane1 = new GridPane();

	// Setting size for the pane
	gridPane1.setMinSize(400, 200);

	// Setting the padding
	gridPane1.setPadding(new Insets(10, 10, 10, 10));

	// Setting the vertical and horizontal gaps between the columns
	gridPane1.setVgap(5);
	gridPane1.setHgap(5);

	// Setting the Grid alignment
	gridPane1.setAlignment(Pos.BASELINE_RIGHT);

	// Arranging all the nodes in the grid
	gridPane1.add(roundScoreLabel1, 0, 0);
	gridPane1.add(roundScore1, 1, 0);
	gridPane1.add(totalLabel1, 0, 1);
	gridPane1.add(total1, 1, 1);
	leftSplit.getChildren().addAll(vbox1, gridPane1);
	leftSplit.setStyle("-fx-background-color: black");

	// build player labels on right
	label2 = new Label("Player 2");
	label1.setTextFill(Color.web("#1F51FF"));
	label2.setPadding(new Insets(10, 0, 0, 375));
	rightSplit = new VBox(label2);
	label2.setFont(new Font(24));

	// Creating Labels for scores
	Label roundScoreLabel2 = new Label("Round score");
	roundScoreLabel2.setTextFill(Color.web("black"));
	Label totalLabel2 = new Label("Total");
	totalLabel2.setTextFill(Color.web("black"));

	// Creating TextFields for scores
	TextField roundScore2 = new TextField();
	TextField total2 = new TextField();

	// Creating a Grid Pane
	GridPane gridPane2 = new GridPane();

	// Setting size for the pane
	gridPane2.setMinSize(400, 200);

	// Setting the padding
	gridPane2.setPadding(new Insets(10, 10, 10, 10));

	// Setting the vertical and horizontal gaps between the columns
	gridPane2.setVgap(5);
	gridPane2.setHgap(5);

	// Setting the Grid alignment
	gridPane2.setAlignment(Pos.BASELINE_LEFT);

	// Arranging all the nodes in the grid
	gridPane2.add(roundScore2, 0, 0);
	gridPane2.add(roundScoreLabel2, 1, 0);
	gridPane2.add(total2, 0, 1);
	gridPane2.add(totalLabel2, 1, 1);

	rightSplit.getChildren().addAll(vbox2, gridPane2);
	rightSplit.setStyle("-fx-background-color: #ffbd05");

	// set up split pane
	split.getItems().addAll(leftSplit, rightSplit);
	split.setDividerPosition(1, 0);

	stackPane.getChildren().addAll(split, borderPane, die);
	scene = new Scene(stackPane, 960, 680);
	primaryStage.setScene(scene);
	primaryStage.setResizable(false);
	primaryStage.show();

    }

}
