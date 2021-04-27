package views;

import controllers.GameController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

/*
 * Container class contains all view component classes,
 * and makes these available to View class
 */
public class Container {
    private GameController controller;
    private Group group;
    private StackPane stackPane;
    private SplitPane split;
    private BorderPane borderPane;
    private ImageView die;
    private LeftSplit leftSplit;
    private RightSplit rightSplit;
    private Button btnRoll;
    private Button btnHold;
    private Button btnRestart;
    private Button btnHistory;
    private HBox paneForButtons;
    private HistoryTable historyTable;

    public Container(GameController controller) {
	this.controller = controller;
	this.group = new Group();
	this.stackPane = new StackPane();
	this.split = new SplitPane();
	this.borderPane = new BorderPane();
	this.leftSplit = new LeftSplit(controller);
	this.rightSplit = new RightSplit(controller);
	this.btnRoll = new Button("Roll");
	this.btnHold = new Button("Hold");
	this.paneForButtons = new HBox(16);
	this.die = new ImageView();
	this.btnRestart = new Button("Restart");
	this.btnHistory = new Button("Check History");
	this.historyTable = new HistoryTable(controller);

    }

    public Button getBtnRoll() {
	return btnRoll;
    }

    public Button getBtnHold() {
	return btnHold;
    }

    public Button getBtnRestart() {
	return btnRestart;
    }

    public Button getBtnHistory() {
	return btnHistory;
    }

    public LeftSplit getLeftSplit() {
	return leftSplit;
    }

    public RightSplit getRightSplit() {
	return rightSplit;
    }

    public ImageView getDie() {
	return die;
    }

    public HBox getPaneForButtons() {
	return paneForButtons;
    }

    public StackPane getStackPane() {
	return stackPane;
    }

    public HistoryTable getHistoryTable() {
	return historyTable;
    }

    public Group render() {
	// set up split panes
	split.getItems().addAll(leftSplit.render(), rightSplit.render());
	split.setDividerPosition(1, 0);

	btnRoll.setMinWidth(460);
	btnHold.setMinWidth(460);

	// build buttons holder
	paneForButtons = new HBox(16);// space between buttons is 16
	paneForButtons.getChildren().addAll(btnRoll, btnHold);
	paneForButtons.setAlignment(Pos.CENTER);
	paneForButtons.setPadding(new Insets(0, 0, 20, 0));
	borderPane.setBottom(paneForButtons);

	// add to container
	stackPane.getChildren().addAll(split, borderPane, die);
	group.getChildren().add(stackPane);

	return group;
    }

}
