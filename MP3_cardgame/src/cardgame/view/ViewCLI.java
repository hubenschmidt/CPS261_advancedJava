
package cardgame.view;

import java.util.Scanner;

import cardgame.controller.CardGameController;

public class ViewCLI implements View {
	CardGameController controller;
	Scanner keyboard = new Scanner(System.in);

	public void setController(CardGameController controller) {
		this.controller = controller;
	}

	public void displayPlayerName() {
		System.out.println(controller.getPlayer().getName());
	}

	public void promptFlip() {
		System.out.println("Press return to flip cards");
		keyboard.nextLine();
		controller.flipCards();
	}

	public void promptForNewGame() {
		System.out.println("Press return to deal again");
		keyboard.nextLine();
		controller.resetHand();
		controller.startGame();
	}

	public void promptToReshuffleDeck() {
		System.out.println("Deck is empty. Press enter to shuffle again.");
		keyboard.nextLine();
		controller.reshuffleDeck();
		controller.startGame();
	}

	public void showCardForPlayer(String rank, String suit) {
		System.out.println(rank + " " + suit);
	}
}
