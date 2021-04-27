package views;

import controllers.GameController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class HistoryTable {
    private GameController controller;
    private VBox historyTableVBox;
    private Button exitButton;
    private TableView table;
    private Label historyTableLabel;
    private TableColumn nameCol;
    private TableColumn dateCol;
    private TableColumn finalScoreCol;
    private TableColumn winLoseCol;
    private DisplayWins displayWins;

    public VBox getHistoryTableVBox() {
	return historyTableVBox;
    }

    public Button getExitButton() {
	return exitButton;
    }

    public TableView getTable() {
	return table;
    }

    public Label getHistoryTableLabel() {
	return historyTableLabel;
    }

    public HistoryTable(GameController controller) {
	this.controller = controller;
	this.historyTableVBox = new VBox();
	this.exitButton = new Button("Exit History");
	this.table = new TableView<>();
	this.historyTableLabel = new Label("Game History");
	this.nameCol = new TableColumn("Name");
	this.dateCol = new TableColumn("Date");
	this.finalScoreCol = new TableColumn("Score");
	this.winLoseCol = new TableColumn("Win");
	this.displayWins = new DisplayWins(controller);

    }

    public VBox render() {
	// clear table if exists
	historyTableVBox.getChildren().removeAll(historyTableLabel, table, exitButton, displayWins.render());
	table.getColumns().removeAll(nameCol, dateCol, finalScoreCol, winLoseCol);

	// create labels
	historyTableLabel.setFont(new Font("Arial", 20));
	historyTableLabel.setTextFill(Color.web("white"));

	// create columns
	nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
	dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
	finalScoreCol.setCellValueFactory(new PropertyValueFactory<>("finalScore"));
	winLoseCol.setCellValueFactory(new PropertyValueFactory<>("winOrLose"));

	// add data to the table
	table.setItems(controller.getData());
	table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	table.getColumns().addAll(nameCol, dateCol, finalScoreCol, winLoseCol);
	table.getSortOrder().add(dateCol);

	// format table
	historyTableVBox.setSpacing(5);
	historyTableVBox.setPadding(new Insets(170, 0, 0, 10));
	historyTableVBox.getChildren().addAll(historyTableLabel, table, exitButton);

	// add user wins total
	historyTableVBox.getChildren().addAll(displayWins.render());

	return historyTableVBox;
    }

}
