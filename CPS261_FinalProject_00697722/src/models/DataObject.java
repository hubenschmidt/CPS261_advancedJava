package models;

/*
 * object mapping for JavaFX TableView. I would have preferred to add the History 
 * object directly to the table, however this alternate approach seems to work
 */

public class DataObject {
    private String name;
    private String date;
    private int finalScore;
    private String winOrLose;

    public DataObject(String name, String date, int finalScore, String winOrLose) {

	this.name = name;
	this.date = date;
	this.finalScore = finalScore;
	this.winOrLose = winOrLose;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getDate() {
	return date;
    }

    public void setDate(String date) {
	this.date = date;
    }

    public int getFinalScore() {
	return finalScore;
    }

    public void setScore(int finalScore) {
	this.finalScore = finalScore;
    }

    public String getWinOrLose() {
	return winOrLose;
    }

    public void setWinOrLose(String winOrLose) {
	this.winOrLose = winOrLose;
    }

}
