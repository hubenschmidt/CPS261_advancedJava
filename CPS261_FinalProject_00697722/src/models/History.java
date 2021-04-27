package models;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * Keeps track of game history, store list of players in a LinkedHashMap
 */
public class History {

    private Map<Game, ArrayList<Player>> games = new LinkedHashMap<>(); // not specifying capacity and load factor

    public History() {
    }

    public Map<Game, ArrayList<Player>> getGames() {
	return games;
    }

    public void update(Game game, ArrayList<Player> players) {
	System.out.println("updating history..");
	games.put(game, players);
	System.out.println("entries in history: " + games.size());

    }

}
