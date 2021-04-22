package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import models.Game;
import models.Player;
import views.ViewJavaFX;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
	try {
	    ArrayList<Player> players = new ArrayList<>();
	    Player p1 = new Player("William", 0, 0);
	    players.add(p1);
	    Player p2 = new Player("Jen", 0, 0);
	    players.add(p2);
	    Game game = new Game(players);

//		PigGameController controller = new PigGameController(cardsPerHand, players);
//		ViewJavaFX viewJavaFX = new ViewJavaFX(controller);
	    ViewJavaFX viewJavaFX = new ViewJavaFX();
	    viewJavaFX.displayGUI(primaryStage);

//	    if (controller.getState() != null) {
//		System.out.println(controller.getState().toString());
//		viewJavaFX.displayGUI(primaryStage);
//
//	}

//	    BorderPane root = new BorderPane();
//	    Scene scene = new Scene(root, 400, 400);
//
//	    primaryStage.setScene(scene);
//	    primaryStage.show();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public static void main(String[] args) {
	launch(args);
    }

}
