package models;

public class Player {
    private String name;
    private int roundScore;
    private int total;

    public Player(String name, int roundScore, int total) {
	this.name = name;
	this.roundScore = roundScore;
	this.total = total;
    }

    public String getName() {
	return name;
    }

    public int getRoundScore() {
	return roundScore;
    }

    public int getTotal() {
	return total;
    }

    public void setTotal(int total) {
	this.total = total;
    }

    public void resetRoundScore() {
	roundScore = 0;
    }

    public void updateTurn(int roll) {
	roundScore += roll;
    }

    public void saveScore() {
	total += roundScore;
	resetRoundScore();
    }

    public static void main(String[] args) {

    }

}
