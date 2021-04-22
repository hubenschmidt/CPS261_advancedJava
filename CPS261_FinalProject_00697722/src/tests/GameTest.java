package tests;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import models.Game;
import models.Player;

class GameTest {

    @Test
    void test() {
	ArrayList<Player> players = new ArrayList<>();
	Player p1 = new Player("William", 0, 0);
	players.add(p1);
	Player p2 = new Player("Jen", 0, 0);
	players.add(p2);
	Game game = new Game(players);

	for (int i = 0; i < 10; i++) {
	    game.roll();
	    game.roll();
	    game.hold();

	    System.out.println("Die Rolled " + game.getDie().getTop());
	    System.out.println("player 1 round: " + game.getPlayers().get(0).getRoundScore());
	    System.out.println("player 1 score: " + game.getPlayers().get(0).getTotal());
	    System.out.println("player 2 round: " + game.getPlayers().get(1).getRoundScore());
	    System.out.println("player 2 score: " + game.getPlayers().get(1).getTotal());

	}

    }

}
