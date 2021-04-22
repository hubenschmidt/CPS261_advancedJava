package controllers;

import java.util.ArrayList;

import javafx.stage.Stage;
import models.Game;
import models.Player;
import views.ViewJavaFX;

//View: "Hey, controller, the user just told me he wants item 4 deleted."
//Controller: "Hmm, having checked his credentials, he is allowed to do that... Hey, model, I want you to get item 4 and do whatever you do to delete it."
//Model: "Item 4... got it. It's deleted. Back to you, Controller."
//Controller: "Here, I'll collect the new set of data. Back to you, view."
//View: "Cool, I'll show the new set to the user now."

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
