package models;

import java.util.ArrayList;
import java.util.List;

/*
 * Defines game properties and logic
 */
public class Game {
    private Die die;
    private ArrayList<Player> players;
    private Player activePlayer;
    private CurrentDateTime date;
    private List<Integer> finalScores = new ArrayList<>(); // for displaying final scores on game history view
    private List<String> winLoss = new ArrayList<>(); // for displaying winner on game history view

    public Game(ArrayList<Player> players) {
	this.die = new Die(6, 1);
	this.players = players;
	this.activePlayer = players.get(0);
	this.date = new CurrentDateTime();
    }

    /*
     * getters and setters
     */

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

    public List<Integer> getFinalScores() {
	return finalScores;
    }

    public void setFinalScores(int finalScore) {
	this.finalScores.add(finalScore);
    }

    public List<String> getWinLoss() {
	return winLoss;
    }

    public void setWinLoss(String winLoss) {
	this.winLoss.add(winLoss);
    }

    /*
     * The following methods control the game's functionality and logic
     */

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
    public int roll() {
	die.roll();
	int face = die.getFace();
	activePlayer.updateRound(face);
	if (face == 1) {
	    newTurn();
	    activePlayer.resetRoundScore();
	}
	return activePlayer.getRoundScore();
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
	    setWinLoss("win"); // set player1 as win
	    setWinLoss("loss");// set player2 as loss
	} else if (p2total > p1total) {
	    setWinLoss("loss");// set player1 as win
	    setWinLoss("win");// set player2 as loss
	}
	// record final scores
	setFinalScores(p1total);
	setFinalScores(p2total);
    }
}
