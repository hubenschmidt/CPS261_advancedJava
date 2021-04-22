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
	int face = die.getFace();
	activePlayer.updateRound(face);
	if (face == 1) {
	    activePlayer.resetRoundScore();
	    newTurn();
	}
    }

    /*
     * if player is satisfied with round score, adds to total score, and switches
     * turns to other player.
     */
    public void hold() {
	activePlayer.saveScore();
	newTurn();
	die.setFace(1);
    }

}
