package views;

import controllers.GameController;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class DisplayWins {
    private GameController controller;
    private Text displayWinsP1;
    private Text displayWinsP2;
    private VBox displayWinsVBox;

    public DisplayWins(GameController controller) {
	this.controller = controller;
	this.displayWinsP1 = null;
	this.displayWinsP2 = null;
	this.displayWinsVBox = new VBox();

    }

    public VBox render() {
	displayWinsVBox.getChildren().removeAll(displayWinsP1, displayWinsP2); // clear if exists

	// get player data
	String p1Name = controller.getPlayers().get(0).getName();
	String p2Name = controller.getPlayers().get(1).getName();
	long p1Wins = 0;
	long p2Wins = 0;

	/*
	 * controller.computeTotalWins() returns a Java 8 stream of LinkedHashMap. For
	 * example, it may return any of the following: {loss=1, win=2}, {loss=1},
	 * {win=1}, or {win=2}. if either key "win" or "loss" is null, it does *not*
	 * return {loss=0, win=1} or {loss=1, win=0}. and so, use conditional logic
	 * based on player 1 loss/win data to get wins for player 2.
	 */

	if (controller.computeTotalWins().keySet().contains("win")
		&& !controller.computeTotalWins().keySet().contains("loss")) {
	    p1Wins = (long) controller.computeTotalWins().values().toArray()[0];
	} else if (controller.computeTotalWins().keySet().contains("loss")
		&& !controller.computeTotalWins().keySet().contains("win")) {
	    p2Wins = (long) controller.computeTotalWins().values().toArray()[0];
	} else {
	    p1Wins = (long) controller.computeTotalWins().values().toArray()[1];
	    p2Wins = (long) controller.computeTotalWins().values().toArray()[0];
	}

	displayWinsP1 = new Text("William has " + p1Wins + " wins.");
	displayWinsP1.setFill(Color.web("red"));
	displayWinsP2 = new Text("Jen has " + p2Wins + " wins.");
	displayWinsP2.setFill(Color.web("red"));
	displayWinsVBox.setStyle("-fx-background-color: white");

	displayWinsVBox.getChildren().addAll(displayWinsP1, displayWinsP2);
	return displayWinsVBox;
    }

}
