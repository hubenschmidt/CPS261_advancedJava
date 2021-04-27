package views;

import controllers.GameController;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/*
 * View class contains all the user interaction methods used throughout the application
 * by other views classes
 */
public class View {
    private GameController controller;
    private Scene scene;
    private Container container;

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

	/*
	 * calling methods in the render() method makes these dynamically available
	 * throughout the user interaction
	 */
	refreshData();// clears data upon game start
	highlightActivePlayer();
	rollDie();
	holdRound();
	checkHistory();
	exitHistory();
	restartGame();
    }

    /*
     * User interaction methods
     */
    public void rollDie() {
	container.getBtnRoll().setOnAction((ActionEvent e) -> {
	    int face = controller.roll();
	    refreshData();
	    refreshDie(face);
	});
    }

    public void holdRound() {
	container.getBtnHold().setOnAction((ActionEvent e) -> {
	    controller.hold();
	    highlightActivePlayer();
	    refreshData();
	});
    }

    /*
     * style changes based on turn
     */
    public void highlightActivePlayer() {
	// if player 1
	if (controller.getPlayers().get(0).equals(controller.getActivePlayer())) {
	    container.getLeftSplit().getSplit().setStyle("-fx-background-color: #ffbd05");
	    container.getRightSplit().getSplit().setStyle("-fx-background-color: black");
	} else { // if player 2
	    container.getRightSplit().getSplit().setStyle("-fx-background-color: #ffbd05");
	    container.getLeftSplit().getSplit().setStyle("-fx-background-color: black");
	}
    }

    public void refreshData() {
	int roundScoreP1 = controller.getPlayers().get(0).getRoundScore();
	int totalScoreP1 = controller.getPlayers().get(0).getTotal();
	int roundScoreP2 = controller.getPlayers().get(1).getRoundScore();
	int totalScoreP2 = controller.getPlayers().get(1).getTotal();

	if (controller.getState().toString() == "Initialized") {
	    if (totalScoreP1 >= 100 || totalScoreP2 >= 100) {
		gameOver(true);
	    } else { // clear scores
		container.getLeftSplit().getRoundScore1().setText("" + roundScoreP1);
		container.getLeftSplit().getTotal1().setText("" + totalScoreP1);
		container.getRightSplit().getRoundScore2().setText("" + roundScoreP2);
		container.getRightSplit().getTotal2().setText("" + totalScoreP2);
	    }
	}
    }

    public void refreshDie(int face) {
	container.getDie().setImage(new Image("images/dice" + face + ".png"));
    }

    public void gameOver(boolean gameOver) {
	container.getDie().setImage(null); // clear image
	container.getDie().setImage(new Image("images/pig.jpg"));
	container.getBtnRestart().setMinWidth(460); // activate buttons
	container.getBtnHistory().setMinWidth(460);

	// set the winner
	controller.getGame().setWinner(); // player comparison logic is located on game object

	// update history
	controller.updateHistory();

	container.getPaneForButtons().getChildren().remove(container.getBtnRoll());
	container.getPaneForButtons().getChildren().remove(container.getBtnHold());
	container.getPaneForButtons().getChildren().addAll(container.getBtnRestart(), container.getBtnHistory());
    }

    public void restartGame() {
	container.getBtnRestart().setOnAction((ActionEvent e) -> {
	    container.getPaneForButtons().getChildren().remove(container.getBtnHold());// clear button if exists from
										       // exitHistory()
	    container.getDie().setImage(null); // clear image
	    controller.resetGame(); // clear scores
	    // remove and replace buttons
	    container.getPaneForButtons().getChildren().removeAll(container.getBtnRestart(), container.getBtnHistory());
	    container.getPaneForButtons().getChildren().addAll(container.getBtnRoll(), container.getBtnHold());
	    container.getBtnHold().setDisable(false); // re-enable Hold button if disabled by exitHistory()
	    container.getStackPane().getChildren().remove(container.getHistoryTable());
	    refreshData();
	});
    }

    /*
     * When Check History button is clicked, this method accesses the stackPane
     * component on Container class, and adds the result of the getHistoryTable
     * method (which itself returns the HistoryTable component)
     */
    public void checkHistory() {
	container.getBtnHistory().setOnAction((ActionEvent e) -> {
	    container.getDie().setImage(null);// clear image
	    container.getStackPane().getChildren().add(container.getHistoryTable().render());
	});
    }

    /*
     * When exit button is clicked, restart the game.
     */
    public void exitHistory() {
	container.getHistoryTable().getExitButton().setOnAction((ActionEvent e) -> {
	    container.getStackPane().getChildren().remove(container.getHistoryTable().getHistoryTableVBox());// clear
													     // table
	    container.getBtnHold().setDisable(true);
	    restartGame();
	});
    }
}
