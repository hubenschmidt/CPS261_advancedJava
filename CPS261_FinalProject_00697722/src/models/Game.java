package models;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Die die;
    private List<Player> players;
    private Player activePlayer;

    public Game(ArrayList<Player> players) {
	System.out.println("initializing Game");
	this.die = new Die(6, 1);
	this.players = players;
	this.activePlayer = players.get(0);

    }

    public Die getDie() {
	return die;
    }

    public void setDie(Die die) {
	this.die = die;
    }

    public List<Player> getPlayers() {
	return players;
    }

    public void setPlayers(List<Player> players) {
	this.players = players;
    }

    public Player getActivePlayer() {
	return activePlayer;
    }

    public void setActivePlayer(Player activePlayer) {
	this.activePlayer = activePlayer;
    }

    public boolean gameOver() {
	return activePlayer.getTotal() >= 100;
    }

    public boolean playerOneTurn() {
	return activePlayer == getPlayers().get(0);
    }

    /*
     * switches turns
     */

    public void newTurn() {
	if (playerOneTurn()) {
	    activePlayer = getPlayers().get(1);
	} else {
	    activePlayer = getPlayers().get(0);
	}
    }

    /*
     * if you roll a 1, then roundScore resets and it is player 2's turn
     */

    public void roll() {
	die.roll();
	int top = die.getTop();
	activePlayer.updateTurn(top);
	if (top == 1) {
	    activePlayer.resetRoundScore();
	    newTurn();
	}
    }

    public void hold() {
	activePlayer.saveScore();
	newTurn();
	die.setTop(1);
    }

}
