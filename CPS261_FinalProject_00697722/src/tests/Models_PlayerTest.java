package tests;

import org.junit.jupiter.api.Test;

import models.Die;
import models.Player;

class Models_PlayerTest {

    @Test
    void test() {
	Die d = new Die(6, 1);
	Player p = new Player("William", 0, 0);
	System.out.println(p.getRoundScore());
	System.out.println(p.getTotal());
	for (int i = 0; i < 10; i++) {
	    d.roll();
	    p.updateTurn(d.getTop());
	    System.out.println(p.getRoundScore());
	    System.out.println(p.getTotal());
	}
	p.saveScore();
	System.out.println("Saving...");
	System.out.println(p.getRoundScore());
	System.out.println(p.getTotal());

    }

}
