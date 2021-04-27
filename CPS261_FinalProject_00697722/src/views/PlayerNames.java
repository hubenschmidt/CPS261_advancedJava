package views;

import controllers.GameController;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PlayerNames {
    GameController controller;
    private Pane pane;
    private HBox nameBox1;
    private HBox nameBox2;
    private Text playerName1;
    private Text playerName2;

    public PlayerNames(GameController controller) {
	this.controller = controller;
	this.playerName1 = new Text();
	this.playerName2 = new Text();
	this.pane = new Pane();
	this.nameBox1 = new HBox();
	this.nameBox2 = new HBox();

    }

    public Pane render() {

	playerName1 = new Text(controller.getGame().getPlayers().get(0).getName());
	playerName1.setFill(Color.web("#1F51FF"));
	playerName1.setFont(new Font(36));
	playerName2 = new Text(controller.getGame().getPlayers().get(1).getName());
	playerName2.setFont(new Font(36));

	nameBox2.setAlignment(Pos.TOP_RIGHT);

	nameBox1.getChildren().add(playerName1);
	nameBox2.getChildren().add(playerName2);
//	pane.setMinWidth(960);
	pane.getChildren().addAll(nameBox1, nameBox2);

	return pane;

//	vbox2 = new VBox();
//	vbox2.getChildren().addAll(playerName2);
//	vbox2.setAlignment(Pos.TOP_RIGHT);
//	vbox2.setPadding(new Insets(0, 100, 0, 0));

    }

}
