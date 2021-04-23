package models;

import javafx.beans.property.SimpleStringProperty;

//object mapping for JavaFX TableView. I would have preferred to add the History object directly to the table, however this alterate approach seems to work:
public class DataObject {
    private SimpleStringProperty name;
    private SimpleStringProperty date;
    private SimpleStringProperty score;
    private SimpleStringProperty winOrLose;

    public DataObject(String name, String date, String score, String winOrLose) {

	this.name = new SimpleStringProperty(name);
	this.date = new SimpleStringProperty(date);
	this.score = new SimpleStringProperty(score);
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

    public SimpleStringProperty getScore() {
	return score;
    }

    public void setScore(SimpleStringProperty score) {
	this.score = score;
    }

    public SimpleStringProperty getWinOrLose() {
	return winOrLose;
    }

    public void setWinOrLose(SimpleStringProperty winOrLose) {
	this.winOrLose = winOrLose;
    }

}
