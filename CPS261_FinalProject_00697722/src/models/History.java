package models;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class History {

    private Map<Game, ArrayList<Player>> games = new LinkedHashMap<>(); // uses type inference // consider specifying
									// initial
    // capacity and load factor

    public History() {
    }
//    public History(Game game, ArrayList<Player> players) {
//	games.put(game, players);
//    }

    public Map<Game, ArrayList<Player>> getGames() {
	return games;
    }

    public void update(Game game, ArrayList<Player> players) {
	System.out.println("updating history..");
	games.put(game, players);
	System.out.println("Size of the history map: " + games.size());

    }

}
