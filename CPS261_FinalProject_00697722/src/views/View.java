package views;

import controllers.GameController;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class View {
    private GameController controller;
    private Scene scene;
    private Container container;

    // view component contains state, passing down to child components

    public View(GameController controller) {
	this.controller = controller;
	this.container = new Container(controller);
    }

    public void render(Stage primaryStage) {
	primaryStage.setTitle("A Game of Pig");
	scene = new Scene(container.render(), 960, 680);
	primaryStage.setScene(scene);
	primaryStage.setResizable(false);
	primaryStage.show();

	refreshData();// clears data upon game start
	rollDie();
	holdRound();
//	checkHistory();
//	restartGame();
    }

    /*
     * User interaction methods
     */
    public void rollDie() {
	container.getBtnRoll().setOnAction((ActionEvent e) -> {
	    int face = controller.roll();
	    refreshData();
//	    refreshDie(face);
	});
    }

    public void holdRound() {
	container.getBtnHold().setOnAction((ActionEvent e) -> {
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
//		gameOver(true);
	    } else {
		container.getLeftSplit().getRoundScore1().setText("" + roundScoreP1);
		container.getLeftSplit().getTotal1().setText("" + totalScoreP1);
		container.getRightSplit().getRoundScore2().setText("" + roundScoreP2);
		container.getRightSplit().getTotal2().setText("" + totalScoreP2);
	    }
	}
    }

//    public void refreshDie(int face) {
//	die.setImage(new Image("images/dice" + face + ".png"));
//    }
//
//    public void gameOver(boolean gameOver) {
//	die.setImage(null); // clear image
//	die.setImage(new Image("images/pig.jpg"));
//	btnRestart.setMinWidth(460); // activate buttons
//	btnHistory.setMinWidth(460);
//
//	// set the winner
//	controller.getGame().setWinner(); // player comparison logic is located on game object
//
//	// update history
//	controller.updateHistory();
//
//	paneForButtons.getChildren().remove(btnRoll);
//	paneForButtons.getChildren().remove(btnHold);
//	paneForButtons.getChildren().addAll(btnRestart, btnHistory);
//    }
//
//    public void restartGame() {
//	btnRestart.setOnAction((ActionEvent e) -> {
//	    paneForButtons.getChildren().remove(btnHold);// clear button if exists from exitHistory()
//	    die.setImage(null); // clear image
//	    controller.resetGame(); // clear scores
//	    paneForButtons.getChildren().removeAll(btnRestart, btnHistory); // remove and replace buttons
//	    paneForButtons.getChildren().addAll(btnRoll, btnHold);
//	    btnHold.setDisable(false); // re-enable Hold button if disabled by exitHistory()
//	    stackPane.getChildren().remove(historyTableVBox);
//	    refreshData();
//	});
//    }
//
//    public void checkHistory() {
//	btnHistory.setOnAction((ActionEvent e) -> {
//	    die.setImage(null);// clear image
//	    displayHistoryTable();
//	});
//    }
//
//    public void displayHistoryTable() {
//	historyTableVBox.getChildren().removeAll(historyTableLabel, table, exitButton, displayWinsVBox);// clear table
//													// if exists
//	table.getColumns().removeAll(nameCol, dateCol, finalScoreCol, winLoseCol);// clear table if exists
//
//	historyTableLabel.setFont(new Font("Arial", 20));
//	historyTableLabel.setTextFill(Color.web("white"));
//
//	// creating columns
//	nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
//	dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
//	finalScoreCol.setCellValueFactory(new PropertyValueFactory<>("finalScore"));
//	winLoseCol.setCellValueFactory(new PropertyValueFactory<>("winOrLose"));
//
//	// adding data to the table
//	table.setItems(controller.getData());
//	table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//	table.getColumns().addAll(nameCol, dateCol, finalScoreCol, winLoseCol);
//	table.getSortOrder().add(dateCol);
//
//	historyTableVBox.setSpacing(5);
//	historyTableVBox.setPadding(new Insets(150, 0, 0, 10));
//	historyTableVBox.getChildren().addAll(historyTableLabel, table, exitButton);
//	paneForButtons.getChildren().removeAll(btnRestart, btnHistory); // remove and replace buttons
//
//	displayPlayerWins();
//
//	stackPane.getChildren().add(historyTableVBox);
//	exitHistory();
//    }
//
//    /*
//     * gets and displays win total
//     */
//
//    public void displayPlayerWins() {
//	displayWinsVBox.getChildren().removeAll(displayWinsP1, displayWinsP2);
//	String p1Name = controller.getPlayers().get(0).getName();
//	String p2Name = controller.getPlayers().get(1).getName();
//	long p1Wins = 0;
//	long p2Wins = 0;
//
//	/*
//	 * controller.computeTotalWins() returns a Java 8 stream of LinkedHashMap. For
//	 * example, it may return any of the following: {loss=1, win=2}, {loss=1},
//	 * {win=1}, or {win=2}. if either key "win" or "loss" is null, it does *not*
//	 * return {loss=0, win=1} or {loss=1, win=0}. and so, use conditional logic
//	 * based on player 1 loss/win data to get wins for player 2.
//	 */
//
//	if (controller.computeTotalWins().keySet().contains("win")
//		&& !controller.computeTotalWins().keySet().contains("loss")) {
//	    p1Wins = (long) controller.computeTotalWins().values().toArray()[0];
//	    System.out.println("William has " + p1Wins + " wins.");
//	} else if (controller.computeTotalWins().keySet().contains("loss")
//		&& !controller.computeTotalWins().keySet().contains("win")) {
//	    p2Wins = (long) controller.computeTotalWins().values().toArray()[0];
//	    System.out.println("Jen has " + p2Wins + " wins.");
//	} else {
//	    p1Wins = (long) controller.computeTotalWins().values().toArray()[1];
//	    p2Wins = (long) controller.computeTotalWins().values().toArray()[0];
//	    System.out.println("William has " + p1Wins + " wins.");
//	    System.out.println("Jen has " + p2Wins + " wins.");
//	}
//	displayWinsP1 = new Text("William has " + p1Wins + " wins.");
//
//	displayWinsP2 = new Text("Jen has " + p2Wins + " wins.");
//	displayWinsVBox.setStyle("-fx-background-color: white");
//	displayWinsVBox.getChildren().addAll(displayWinsP1, displayWinsP2);
//	historyTableVBox.getChildren().addAll(displayWinsVBox);
//    }
//
//    public void exitHistory() {
//	exitButton.setOnAction((ActionEvent e) -> {
//	    stackPane.getChildren().remove(historyTableVBox);// clear table
//	    paneForButtons.getChildren().addAll(btnRestart, btnHold);
//	    btnHold.setDisable(true);
//	    restartGame();
//	});
//    }
}
