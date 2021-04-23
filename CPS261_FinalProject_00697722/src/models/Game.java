package models;

import java.util.ArrayList;

public class Game {
    private Die die;
    private ArrayList<Player> players;
    private Player activePlayer;
    private CurrentDateTime date;

    public Game(ArrayList<Player> players) {
	System.out.println("initializing Game");
	this.die = new Die(6, 1);
	this.players = players;
	this.activePlayer = players.get(0);
	this.date = new CurrentDateTime();
    }

    public Die getDie() {
	return die;
    }

    public void setDie(Die die) {
	this.die = die;
    }

    public ArrayList<Player> getPlayers() {
	return players;
    }

    public void setPlayers(ArrayList<Player> players) {
	this.players = players;
    }

    public Player getActivePlayer() {
	return activePlayer;
    }

    public void setActivePlayer(Player activePlayer) {
	this.activePlayer = activePlayer;
    }

    public CurrentDateTime getDate() {
	return date;
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

    /*
     * Compares player total scores to set winner of game
     */
    public void setWinner() {
	int p1total = getPlayers().get(0).getTotal();
	int p2total = getPlayers().get(1).getTotal();

	if (p1total > p2total) {
	    getPlayers().get(0).setWinner(true);
	}
	getPlayers().get(1).setWinner(false);
    }

}
