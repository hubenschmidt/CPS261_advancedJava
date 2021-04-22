package controllers;

import java.util.ArrayList;
import java.util.List;

import javafx.stage.Stage;
import models.Game;
import models.Player;
import views.ViewJavaFX;

public class GameController {
    public enum State {
	Initialized, GameOver
    }

    private Game game;
    private State state;
    private ViewJavaFX view;
    private Stage stage = new Stage();

    public GameController(ArrayList<Player> players) {
	this.game = new Game(players);
	System.out.println(players.get(0).getName() + " " + players.get(1).getName());
	this.state = State.Initialized;
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
     * controller state
     */
    public void run() {
	switch (state) {
	case Initialized:
	    view.displayGUI(stage);
	    break;
//	case GameOver:
//	    System.out.println("game over");
//	    break;
	// view.displayPig();
	// reset game
	}
    }

    public int roll() {
	game.roll();
	return game.getDie().getFace();
    }

    public int hold() {
	game.hold();
	return game.getActivePlayer().getTotal();
    }

    public Player getActivePlayer() {
	return game.getActivePlayer();
    }

    public List<Player> getPlayers() {
	return game.getPlayers();
    }

}
