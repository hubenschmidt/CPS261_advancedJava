package controllers;

import java.util.ArrayList;
import java.util.Map;

import javafx.stage.Stage;
import models.Game;
import models.History;
import models.Player;
import views.ViewJavaFX;

public class GameController {
    public enum State {
	Initialized, GameOver
    }

    private History history;
    private Game game;
    private ArrayList<Player> players;
    private State state;
    private ViewJavaFX view;
    private Stage stage = new Stage();

    public GameController(ArrayList<Player> players) {
	this.history = new History();
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

    public void setGame(ArrayList<Player> players) {
	this.game = new Game(players);
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

    public ArrayList<Player> getPlayers() {
	return game.getPlayers();
    }

    public void resetGame() {
	game.getPlayers().get(0).setTotal(0);
	game.getPlayers().get(0).resetRoundScore();
	game.getPlayers().get(1).setTotal(0);
	game.getPlayers().get(1).resetRoundScore();

	setGame(getPlayers());
    }

    public void updateHistory() {
	history.update(game, game.getPlayers());
    }

    public Map<Game, ArrayList<Player>> getHistory() {
	// for debugging:
	for (Map.Entry<Game, ArrayList<Player>> entry : history.getGames().entrySet()) {
	    Game game = entry.getKey();
	    ArrayList<Player> player = entry.getValue();
//	    System.out.println("Game history:");
//	    System.out.println("Game " + game.getDate() + " hashCode: " + game.hashCode());
//	    System.out.println("Player1 name: " + player.get(0).getName() + ", hashCode: " + player.get(0).hashCode());
//	    System.out.println("Player2 name: " + player.get(1).getName() + ", hashCode: " + player.get(1).hashCode());
	}

	return history.getGames();
    }

    public void StreamHistory() {
//	history.getGames().entrySet().stream().map(e -> e.getKey().getDate()).forEach(System.out::println);
//	history.getGames().keySet().forEach(e -> System.out.println(e.getDate()));
	history.getGames().keySet().forEach(e -> {
	    e.getDate();

	});
    }
}
