package cardgame.view;

import cardgame.controller.CardGameController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ViewJavaFX {
	CardGameController controller;
	GridPane gridPane;

	private ToggleGroup toggleGroup;
	private TextField english, metric;
	private Button eToM, mToE;
	private Label labelA, labelB;
	private RadioButton temperature, distance, weight;
	private Scene scene;
	private RadioButton initialToggle;
	private String initVal;
	private String selection;

	public void setController(CardGameController controller) {
		this.controller = controller;
	}

	public void displayPlayerName() {
		System.out.println(controller.getPlayer().getName());
	}

	public void promptFlip() {
	}

	public void promptForNewGame() {
	};

	public void promptToReshuffleDeck() {
	};

	public void showCardForPlayer(String rank, String suit) {
	};

	public void displayGrid(GridPane gridPane) {
		gridPane.setVgap(5);
		gridPane.setHgap(5);

	}

	public void displayGUI() {
		gridPane = new GridPane();
		displayGrid(gridPane);

	}

	public String getSelection() {
		return selection;
	}

	public void setSelection(String selection) {
		this.selection = selection;
	}

	/**
	 * builds GUI grid
	 * 
	 * @param gridPane
	 * @param english
	 * @param metric
	 * @param eToM
	 * @param mToE
	 * @param labelA
	 * @param labelB
	 */
	public void displayGrid(GridPane gridPane, TextField english, TextField metric, Button eToM, Button mToE,
			Label labelA, Label labelB) {
		gridPane.setVgap(5);
		gridPane.setHgap(5);
		gridPane.setAlignment(Pos.CENTER);
		gridPane.add(labelA, 0, 0);
		gridPane.add(english, 0, 1);
		gridPane.add(labelB, 1, 0);
		gridPane.add(metric, 1, 1);
		gridPane.add(eToM, 0, 2);
		gridPane.add(mToE, 1, 2);
		gridPane.add(new Label("Select: "), 0, 3);
		gridPane.add(temperature, 1, 3);
		gridPane.add(distance, 1, 4);
		gridPane.add(weight, 1, 5);
	}

	/**
	 * initializes and displays GUI elements
	 * 
	 * @param gridPane
	 * @param english
	 * @param metric
	 * @param eToM
	 * @param mToE
	 * @param labelA
	 * @param labelB
	 */
	public void displayGraphicalUserInterface(Stage primaryStage, CardGameController controller) throws Exception {
		gridPane = new GridPane();
//		toggleGroup = new ToggleGroup();
//		english = new TextField();
//		metric = new TextField();
//		eToM = new Button("english to metric");
//		mToE = new Button("metric to english");
//		labelA = new Label();
//		labelB = new Label();
//		temperature = new RadioButton("Temperature");
//		temperature.setToggleGroup(toggleGroup);
//		temperature.setSelected(true);
//		distance = new RadioButton("Distance");
//		distance.setToggleGroup(toggleGroup);
//		weight = new RadioButton("Weight");
//		weight.setToggleGroup(toggleGroup);
		scene = new Scene(gridPane, 800, 800);
//		displayGrid(gridPane, english, metric, eToM, mToE, labelA, labelB);
		primaryStage.setTitle("Card Game");
		primaryStage.setScene(scene);
		primaryStage.show();
//		initialToggle = (RadioButton) toggleGroup.getSelectedToggle(); // initialize application with temperature
//																		// conversion as default selection
//		initVal = initialToggle.getText();

	}

}
