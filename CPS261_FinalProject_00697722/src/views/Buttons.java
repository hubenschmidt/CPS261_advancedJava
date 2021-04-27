package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class Buttons {
    private Button btnRoll;
    private Button btnHold;
    private HBox paneForButtons;

    public Buttons() {
	this.btnRoll = new Button("Roll");
	this.btnHold = new Button("Hold");
	this.paneForButtons = new HBox(16);

    }

    public HBox render() {
	// build buttons
	btnRoll.setMinWidth(460);
	btnHold.setMinWidth(460);

	// build buttons holder
	paneForButtons = new HBox(16);// space between buttons is 16
	paneForButtons.getChildren().addAll(btnRoll, btnHold);
	paneForButtons.setAlignment(Pos.CENTER);
	paneForButtons.setPadding(new Insets(0, 0, 20, 0));

	return paneForButtons;

    }

}
