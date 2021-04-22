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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ViewJavaFX {
    private GameController controller;
    private StackPane stackPane;
    private Scene scene;

    private Text playerName1;
    private Text playerName2;

    private Button btnRoll = new Button("Roll");
    private Button btnHold = new Button("Hold");
    private HBox paneForButtons;
    private HBox paneForNames;
    private BorderPane borderPane;

    private VBox vbox1;
    private VBox vbox2;
    private Label label1;
    private Label label2;
    private VBox leftSplit;
    private VBox rightSplit;

    private SplitPane split;
    private TextField roundScore1 = new TextField();
    private Label roundScoreLabel1;
    private TextField total1 = new TextField();
    private ImageView die = new ImageView();
    // Creating a Grid Pane
    GridPane gridPane1 = new GridPane();

    // Creating TextFields for scores
    private TextField roundScore2 = new TextField();
    private TextField total2 = new TextField();

    private Button btnRestart = new Button("Restart");
    private Button btnHistory = new Button("Check History");

    public ViewJavaFX(GameController controller) {
	this.controller = controller;
    }

    public void rollDie() {
	btnRoll.setOnAction((ActionEvent e) -> {
	    int face = controller.roll();
	    refreshData();
	    refreshDie(face);
	});
    }

    public void holdRound() {
	btnHold.setOnAction((ActionEvent e) -> {
	    controller.hold();
	    refreshData();
	});
    }

    public void refreshData() {
	int roundScoreP1 = controller.getPlayers().get(0).getRoundScore();
	int totalScoreP1 = controller.getPlayers().get(0).getTotal();
	int roundScoreP2 = controller.getPlayers().get(1).getRoundScore();
	int totalScoreP2 = controller.getPlayers().get(1).getTotal();

	if (controller.getState().toString() == "Initialized") {
	    if (totalScoreP1 >= 100 || totalScoreP2 >= 100) {
		gameOver(true);

	    } else {
		roundScore1.setText("" + roundScoreP1);
		total1.setText("" + totalScoreP1);
		roundScore2.setText("" + roundScoreP2);
		total2.setText("" + totalScoreP2);
	    }
	}
    }

    public void refreshDie(int face) {
	die.setImage(new Image("images/dice" + face + ".png"));
    }

    public void gameOver(boolean gameOver) {
	btnRoll.setDisable(gameOver); // disable buttons
	btnHold.setDisable(gameOver);
	die.setImage(null); // clear image
	die.setImage(new Image("images/pig.jpg"));
	btnRestart.setMinWidth(460); // activate buttons
	btnHistory.setMinWidth(460);
	paneForButtons.getChildren().remove(btnRoll);
	paneForButtons.getChildren().remove(btnHold);
	paneForButtons.getChildren().addAll(btnRestart, btnHistory);

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

	// build buttons
	btnRoll.setMinWidth(460);
	btnHold.setMinWidth(460);

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

	// build player labels on left
	label1 = new Label("Player 1");
	label1.setTextFill(Color.web("#1F51FF"));
	label1.setPadding(new Insets(10, 0, 0, 10));
	leftSplit = new VBox(label1);
	label1.setFont(new Font(24));

	// Creating Labels for scores
	roundScoreLabel1 = new Label("Round score");
	roundScoreLabel1.setTextFill(Color.web("#d3d3d3"));
	Label totalLabel1 = new Label("Total");
	totalLabel1.setTextFill(Color.web("#d3d3d3"));

	// Creating TextFields for scores

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

	rollDie();
	holdRound();

    }

}
