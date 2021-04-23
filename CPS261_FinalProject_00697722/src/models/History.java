package models;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class History {

    Map<Game, ArrayList<Player>> games = new LinkedHashMap<>(); // uses type inference // consider specifying initial
								// capacity and load factor

    public History(Game game, ArrayList<Player> players) {
	games.put(game, players);
    }

    public Map<Game, ArrayList<Player>> getGames() {
	return games;
    }

}
