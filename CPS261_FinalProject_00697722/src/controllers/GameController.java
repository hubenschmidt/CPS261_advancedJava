package controllers;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import models.DataObject;
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
    private int i;

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

    /*
     * Method for fetching data to pass to table view. I had difficulty accessing
     * the History LinkedHashTable directly with JavaFX TableView, and so as a
     * workaround and to speed development, I created DataObject to format the data
     * in a single line, which seems to be the easiest way to interact with
     * TableView.
     */
    public ObservableList<DataObject> getData() {
	ObservableList<DataObject> data = FXCollections.observableArrayList();
	for (i = 0; i < getPlayers().size(); i++) {
	    history.getGames().entrySet().forEach(el -> data
		    .add(new DataObject(el.getValue().get(i).getName(), el.getKey().getDate().toString(),
			    el.getKey().getFinalScores().get(i),
			    el.getKey().getWinLoss().get(i))));
	}
	return data;
    }

    public void computeTotalWins() {

	// display player 1's wins and losses in console. We could stop here by
	// computing
	// player 2's number of wins based on the player 1 losses OR
	// we could try to implement a Parallel Stream.
	System.out.println(history.getGames().entrySet().stream().map(e -> e.getKey().getWinLoss().get(0))
		.collect(Collectors.groupingBy(Function.identity(),
			Collectors.counting())));

    }
}
