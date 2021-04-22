package controllers;

import java.util.ArrayList;

import javafx.stage.Stage;
import models.Game;
import models.Player;
import views.ViewJavaFX;

public class GameController {
    public enum State {
	AddPlayers
    }

    private Game game;
    private State state;
    private ViewJavaFX view;
    private Stage stage = new Stage();

    public GameController(ArrayList<Player> players) {
	this.game = new Game(players);
	System.out.println(players.get(0).getName() + " " + players.get(1).getName());
	this.state = State.AddPlayers;
    }

    /*
     * getters and setters
     */
    public Game getGame() {
	return game;
    }

    public void setGame(Game game) {
	this.game = game;
    }

    public State getState() {
	return state;
    }

    public void setState(State state) {
	this.state = state;
    }

    /*
     * changes game state
     */
    public void run() {
	switch (state) {
	case AddPlayers:
	    view.displayGUI(stage);
	    break;

	}
    }

}
