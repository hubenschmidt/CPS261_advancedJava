package application;

import java.util.ArrayList;

import controllers.GameController;
import javafx.application.Application;
import javafx.stage.Stage;
import models.Player;
import views.View;

/*
 * Driver class executes the application
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
	try {
	    /*
	     * Players enter the game
	     */
	    ArrayList<Player> players = new ArrayList<>();
	    Player p1 = new Player("William", 0, 0);
	    players.add(p1);
	    Player p2 = new Player("Jen", 0, 0);
	    players.add(p2);

	    /*
	     * start controller, start view
	     */
	    GameController controller = new GameController(players);
	    View view = new View(controller);

	    /*
	     * if there is a game state, display GUI
	     */
	    if (controller.getState() != null) {
		System.out.println(controller.getState().toString());
		view.render(primaryStage);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public static void main(String[] args) {
	launch(args);
    }

}
