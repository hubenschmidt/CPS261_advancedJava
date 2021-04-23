package views;

import controllers.GameController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
import models.DataObject;

public class ViewJavaFX {
    /*
     * Setting up primary elements of JavaFX scene
     */
    private GameController controller;
    private StackPane stackPane = new StackPane();
    private Scene scene;
    private Text playerName1;
    private Text playerName2;
    private Button btnRoll = new Button("Roll");
    private Button btnHold = new Button("Hold");
    private HBox paneForButtons;
    private HBox paneForNames;
    private BorderPane borderPane = new BorderPane();;
    private VBox vbox1;
    private VBox vbox2;
    private Label label1;
    private Label label2;
    private SplitPane split = new SplitPane();
    private VBox leftSplit;
    private VBox rightSplit;

    // Creating die image
    private ImageView die = new ImageView();

    // Creating Grid Panes for scores Labels and TextFields;
    private GridPane gridPane1 = new GridPane();
    private GridPane gridPane2 = new GridPane();

    // Creating Labels for scores
    private Label roundScoreLabel1 = new Label("Round score");
    private Label roundScoreLabel2 = new Label("Round score");
    private Label totalLabel1 = new Label("Total");
    private Label totalLabel2 = new Label("Total");

    // Creating TextFields for scores
    private TextField roundScore1 = new TextField();
    private TextField roundScore2 = new TextField();
    private TextField total1 = new TextField();
    private TextField total2 = new TextField();

    private Button btnRestart = new Button("Restart");
    private Button btnHistory = new Button("Check History");

    // create history table vbox
    private VBox historyTableVBox = new VBox();
    private Button exitButton = new Button("Exit History");
    private TableView table = new TableView<DataObject>();
    private Label historyTableLabel = new Label("Game History");

    private TableColumn nameCol = new TableColumn("Name");
    private TableColumn dateCol = new TableColumn("Date");
    private TableColumn finalScoreCol = new TableColumn("Score");
    private TableColumn winLoseCol = new TableColumn("Win or Lose");

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
	    if (totalScoreP1 >= 10 || totalScoreP2 >= 10) {
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
	die.setImage(null); // clear image
	die.setImage(new Image("images/pig.jpg"));
	btnRestart.setMinWidth(460); // activate buttons
	btnHistory.setMinWidth(460);

	// set the winner
	controller.getGame().setWinner(); // player comparison logic is located on game object

	// update history
	controller.updateHistory();

//	controller.getHistory();

	paneForButtons.getChildren().remove(btnRoll);
	paneForButtons.getChildren().remove(btnHold);
	paneForButtons.getChildren().addAll(btnRestart, btnHistory);
    }

    public void restartGame() {
	btnRestart.setOnAction((ActionEvent e) -> {
	    paneForButtons.getChildren().remove(btnHold);// clear button if exists from exitHistory()
	    die.setImage(null); // clear image
	    controller.resetGame(); // clear scores
	    paneForButtons.getChildren().removeAll(btnRestart, btnHistory); // remove and replace buttons
	    paneForButtons.getChildren().addAll(btnRoll, btnHold);
	    btnHold.setDisable(false); // re-enable Hold button if disabled by exitHistory()
	    stackPane.getChildren().remove(historyTableVBox);
	    refreshData();
	});
    }

    public void checkHistory() {
	btnHistory.setOnAction((ActionEvent e) -> {
	    die.setImage(null);// clear image
	    displayHistoryTable();
	});
    }

    public void displayHistoryTable() {
	historyTableVBox.getChildren().removeAll(historyTableLabel, table, exitButton);// clear table if exists
	table.getColumns().removeAll(nameCol, dateCol, finalScoreCol, winLoseCol);// clear table if exists

	historyTableLabel.setFont(new Font("Arial", 20));
	historyTableLabel.setTextFill(Color.web("white"));

	// add data here
	// call to game controller to do Stream of Map

//	controller.getHistory().entrySet().stream().map(e -> e.getKey().getDate()).forEach(System.out::println);

	// use stream to access History
	// and add to each column

//	controller.StreamHistory();
//	controller.getHistory().keySet().forEach(e -> {
//	    e.getDate();
//	});

	ObservableList<DataObject> data = FXCollections.observableArrayList(
		new DataObject("file1", "D:\\myFiles\\file1.txt", "25 MB", "12/01/2017"),
		new DataObject("file2", "D:\\myFiles\\file2.txt", "30 MB", "01/11/2019"),
		new DataObject("file3", "D:\\myFiles\\file3.txt", "50 MB", "12/04/2017"),
		new DataObject("file4", "D:\\myFiles\\file4.txt", "75 MB", "25/09/2018"));

	// creating columns
	nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
	dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
	finalScoreCol.setCellValueFactory(new PropertyValueFactory<>("finalScore"));
	winLoseCol.setCellValueFactory(new PropertyValueFactory<>("winOrLose"));

	// adding data to the table
	ObservableList<String> list = FXCollections.observableArrayList();
	table.setItems(data);
	table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	table.getColumns().addAll(nameCol, dateCol, finalScoreCol, winLoseCol);

	// use stream to compute total wins / losses

	historyTableVBox.setSpacing(5);
	historyTableVBox.setPadding(new Insets(200, 0, 0, 10));
	historyTableVBox.getChildren().addAll(historyTableLabel, table, exitButton);
	paneForButtons.getChildren().removeAll(btnRestart, btnHistory); // remove and replace buttons
	stackPane.getChildren().add(historyTableVBox);
	exitHistory();
    }

    public void exitHistory() {
	exitButton.setOnAction((ActionEvent e) -> {
	    stackPane.getChildren().remove(historyTableVBox);// clear table
	    paneForButtons.getChildren().addAll(btnRestart, btnHold);
	    btnHold.setDisable(true);
	    restartGame();
	});
    }

    /**
     * displays user interface
     * 
     * @param primaryStage
     */
    public void displayGUI(Stage primaryStage) {

	primaryStage.setTitle("A Game of Pig");

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

	// build buttons holder
	paneForButtons = new HBox(16);// space between buttons is 16
	paneForButtons.getChildren().addAll(btnRoll, btnHold);
	paneForButtons.setAlignment(Pos.CENTER);
	paneForButtons.setPadding(new Insets(0, 0, 20, 0));

	borderPane.setBottom(paneForButtons);
	borderPane.setLeft(paneForNames);

	// build player labels on left
	label1 = new Label("Player 1");
	label1.setTextFill(Color.web("#1F51FF"));
	label1.setPadding(new Insets(10, 0, 0, 10));
	label1.setFont(new Font(24));
	leftSplit = new VBox(label1);

	roundScoreLabel1.setTextFill(Color.web("#d3d3d3"));

	totalLabel1.setTextFill(Color.web("#d3d3d3"));

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
	roundScoreLabel2.setTextFill(Color.web("black"));
	totalLabel2.setTextFill(Color.web("black"));

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

	refreshData();// clears data upon game start
	rollDie();
	holdRound();
	checkHistory();
	restartGame();

    }

}
