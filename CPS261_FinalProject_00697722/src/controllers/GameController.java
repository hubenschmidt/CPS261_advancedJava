package controllers;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import models.DataObject;
import models.Game;
import models.History;
import models.Player;
import views.View;

/*
 * If a state change takes place on an object instantiated from a model class,
 * then the controller will recognize and pass the change to application view.
 * If a user interaction is recorded by an event handler within a view class, then
 * the controller will pass the update to the model.  
 * 
 *
 * The model then passes the update back to the controller and then back to the view.
 * 
 * 
 * I experimented with state management on the controller,
 * ultimately preserving a piece of code I might try to expand in the future, 
 * as it only contains one state here.
 * This could be used as a way to manage state changes across an complex application 
 * containing many classes and dynamically updated views.
 * 
 * State could also exist as a separate container class from the controller.
 */
public class GameController {
    public enum State {
	Initialized,
//	GameOver
    }

    private History history;
    private Game game;
    private ArrayList<Player> players;
    private State state;
    private View view;
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
	    view.render(stage);
	    break;
	}
    }

    /*
     * The following methods control game logic and program flow
     */

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

    /*
     * Computes total wins using Java8 stream
     */

    public Map<String, Long> computeTotalWins() {
	return history.getGames().entrySet().stream()
		.map(e -> e.getKey().getWinLoss().get(0))
		.collect(Collectors.groupingBy(Function.identity(),
			Collectors.counting()));

    }
}
