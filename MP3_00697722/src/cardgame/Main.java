package cardgame;

public class Main {
	public static void main(String[] args) {
		Deck deck = new Deck();
		CardGameView view = new CardGameView();
		Player player = new Player("User1");
		CardGameController controller = new CardGameController(view, deck, player);
		view.setController(controller);

		controller.run();
	}
}

//public class Main extends Application {
//	@Override
//	public void start(Stage primaryStage) {
//		try {
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void main(String[] args) {
//		launch(args);
//
//	}
//}