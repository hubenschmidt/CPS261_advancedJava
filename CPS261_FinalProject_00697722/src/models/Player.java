package models;

/*
 * Defines properties and methods for individual player
 */
public class Player {
    private String name;
    private int roundScore;
    private int total;
    private boolean winner;

    public Player(String name, int roundScore, int total) {
	this.name = name;
	this.roundScore = roundScore;
	this.total = total;
	this.winner = false;
    }

    /*
     * getters and setters
     */

    public String getName() {
	return name;
    }

    public int getRoundScore() {
	if (total < 100) {
	    return roundScore;
	} else {
	    return -1;
	}
    }

    public int getTotal() {
	return total;
    }

    public void setTotal(int total) {
	this.total = total;
    }

    /*
     * The following methods control the player's functionality and logic
     */
    public boolean isWinner() {
	return winner;
    }

    public void setWinner(boolean winner) {
	this.winner = winner;
    }

    public void resetRoundScore() {
	roundScore = 0;
    }

    public void updateRound(int roll) {
	roundScore += roll;
    }

    public void saveScore() {
	total += roundScore;
	resetRoundScore();
    }

}
