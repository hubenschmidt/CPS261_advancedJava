package tests;

import org.junit.jupiter.api.Test;

import models.Die;

class Models_DiceTest {

    @Test
    void test() {
	Die d = new Die(6, 1);
	d.roll();
//	
	System.out.println(d.getTop());
	for (int i = 0; i < 10; i++) {
	    d.roll();
	    System.out.println(d.getTop());
	}
    }
}
