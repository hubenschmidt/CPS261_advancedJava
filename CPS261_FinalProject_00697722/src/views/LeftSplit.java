package views;

import controllers.GameController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class LeftSplit {
    private VBox split;
    private VBox nameBox1;
    private VBox labelBox1;
    private Text playerName1;
    private Label label1;
    private GridPane gridPane1;
    private Label roundScoreLabel1;
    private TextField roundScore1;
    private Label totalLabel1;
    private TextField total1;

    public LeftSplit(GameController controller) {
	this.split = new VBox();
	this.nameBox1 = new VBox();
	this.labelBox1 = new VBox();
	this.playerName1 = new Text(controller.getGame().getPlayers().get(0).getName());
	this.label1 = new Label();
	this.gridPane1 = new GridPane();
	this.roundScoreLabel1 = new Label("Round");
	this.roundScore1 = new TextField();
	this.totalLabel1 = new Label("Total");
	this.total1 = new TextField();
    }

    public TextField getRoundScore1() {
	return roundScore1;
    }

    public TextField getTotal1() {
	return total1;
    }

    public VBox getSplit() {
	return split;
    }

    public VBox render() {
	// build player name
	playerName1.setFill(Color.web("#1F51FF"));
	playerName1.setFont(new Font(36));

	nameBox1 = new VBox();
	nameBox1.getChildren().addAll(playerName1);
	nameBox1.setAlignment(Pos.TOP_LEFT);
	nameBox1.setPadding(new Insets(0, 0, 0, 100));

	// build player label on left
	label1 = new Label("Player 1");
	label1.setTextFill(Color.web("#1F51FF"));
	label1.setPadding(new Insets(10, 0, 0, 10));
	label1.setFont(new Font(24));
	labelBox1.getChildren().add(label1);

	// format round score and total score boxes
	roundScoreLabel1.setStyle("-fx-text-fill: red; -fx-font-size: 18px;");
	totalLabel1.setStyle("-fx-text-fill: #1F51FF; -fx-font-size: 18px;");
	roundScore1.setStyle("-fx-text-fill: red; -fx-font-size: 18px;");
	total1.setStyle("-fx-text-fill: #1F51FF; -fx-font-size: 18px;");

	// Setting size for the pane
	gridPane1.setMinSize(480, 600);

	// Setting the padding
	gridPane1.setPadding(new Insets(10, 10, 10, 10));

	// Setting the vertical and horizontal gaps between the columns
	gridPane1.setVgap(5);
	gridPane1.setHgap(5);

	// Setting the Grid alignment
	gridPane1.setAlignment(Pos.BASELINE_RIGHT);

	// Arranging all the nodes in the grid
	gridPane1.add(roundScoreLabel1, 0, 0);
	gridPane1.add(roundScore1, 1, 0);
	gridPane1.add(totalLabel1, 0, 1);
	gridPane1.add(total1, 1, 1);

	split.getChildren().addAll(label1, nameBox1, gridPane1);
	split.setStyle("-fx-background-color: black");

	return split;
    }

}
