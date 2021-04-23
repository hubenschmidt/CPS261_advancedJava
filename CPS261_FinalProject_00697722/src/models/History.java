package models;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class History {
//    Map<Game, ArrayList<Player>> games = new HashMap<Game, ArrayList<Player>>();
    Map<Game, ArrayList<Player>> games = new LinkedHashMap<>(); // uses type inference?

//    private List<Game> games;

    public History(Game game, ArrayList<Player> players) {
	games.put(game, players);
    }

//    public List<Game> getGames() {
//	return games;
//    }

    public Map<Game, ArrayList<Player>> getGames() {
	return games;
    }

}
