package cardgame;

import java.util.Scanner;

public class CardGameView {
	CardGameController controller;
	Scanner keyboard = new Scanner(System.in);

	public void setController(CardGameController controller) {
		this.controller = controller;
	}

	public void displayPlayerName() {
		System.out.println(controller.player.getName());
	}

	public void promptFlip() {
		System.out.println("Press enter to reveal cards");
		keyboard.nextLine();
		controller.flipCards();
	}

	public void promptForNewGame() {
		System.out.println("Press enter to deal again");
		keyboard.nextLine();
		controller.startGame();
	}

	public void showCardForPlayer(String rank, String suit) {
		System.out.println(rank + " " + suit);
	}
}
