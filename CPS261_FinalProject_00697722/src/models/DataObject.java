package models;

import javafx.beans.property.SimpleStringProperty;

//object mapping for JavaFX TableView. I would have preferred to add the History object directly to the table, however this alterate approach seems to work:
public class DataObject {
    private SimpleStringProperty name;
    private SimpleStringProperty date;
    private SimpleStringProperty finalScore;
    private SimpleStringProperty winOrLose;

    public DataObject(String name, String date, String finalScore, String winOrLose) {

	this.name = new SimpleStringProperty(name);
	this.date = new SimpleStringProperty(date);
	this.finalScore = new SimpleStringProperty(finalScore);
	this.winOrLose = new SimpleStringProperty(winOrLose);

    }

    public SimpleStringProperty getName() {
	return name;
    }

    public void setName(SimpleStringProperty name) {
	this.name = name;
    }

    public SimpleStringProperty getDate() {
	return date;
    }

    public void setDate(SimpleStringProperty date) {
	this.date = date;
    }

    public SimpleStringProperty getFinalScore() {
	return finalScore;
    }

    public void setScore(SimpleStringProperty finalScore) {
	this.finalScore = finalScore;
    }

    public SimpleStringProperty getWinOrLose() {
	return winOrLose;
    }

    public void setWinOrLose(SimpleStringProperty winOrLose) {
	this.winOrLose = winOrLose;
    }

}
