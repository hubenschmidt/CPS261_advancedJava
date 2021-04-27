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

public class RightSplit {
    private VBox split;
    private VBox nameBox2;
    private VBox labelBox2;
    private Text playerName2;
    private Label label2;
    private GridPane gridPane2;
    private Label roundScoreLabel2;
    private TextField roundScore2;
    private Label totalLabel2;
    private TextField total2;

    public RightSplit(GameController controller) {
	this.split = new VBox();
	this.nameBox2 = new VBox();
	this.labelBox2 = new VBox();
	this.playerName2 = new Text(controller.getGame().getPlayers().get(1).getName());
	this.label2 = new Label();
	this.gridPane2 = new GridPane();
	this.roundScoreLabel2 = new Label("Round");
	this.roundScore2 = new TextField();
	this.totalLabel2 = new Label("Total");
	this.total2 = new TextField();
    }

    public TextField getRoundScore2() {
	return roundScore2;
    }

    public TextField getTotal2() {
	return total2;
    }

    public VBox render() {
	// build player name
	playerName2.setFill(Color.web("#1F51FF"));
	playerName2.setFont(new Font(36));

	nameBox2 = new VBox();
	nameBox2.getChildren().addAll(playerName2);
	nameBox2.setAlignment(Pos.TOP_RIGHT);
	nameBox2.setPadding(new Insets(0, 100, 0, 0));

	// build player label on left
	label2 = new Label("Player 2");
	label2.setTextFill(Color.web("#1F51FF"));
	label2.setPadding(new Insets(10, 0, 0, 370));
	label2.setFont(new Font(24));
	labelBox2.getChildren().add(label2);

	roundScoreLabel2.setTextFill(Color.web("black"));

	totalLabel2.setTextFill(Color.web("black"));

	// Setting size for the pane
	gridPane2.setMinSize(480, 600);

	// Setting the padding
	gridPane2.setPadding(new Insets(10, 10, 10, 10));

	// Setting the vertical and horizontal gaps between the columns
	gridPane2.setVgap(5);
	gridPane2.setHgap(5);

	// Setting the Grid alignment
	gridPane2.setAlignment(Pos.BASELINE_LEFT);

	// Arranging all the nodes in the grid
	gridPane2.add(roundScore2, 0, 0);
	gridPane2.add(roundScoreLabel2, 1, 0);
	gridPane2.add(total2, 0, 1);
	gridPane2.add(totalLabel2, 1, 1);

	split.getChildren().addAll(label2, nameBox2, gridPane2);
	split.setStyle("-fx-background-color: #ffbd05");

	return split;
    }

}
