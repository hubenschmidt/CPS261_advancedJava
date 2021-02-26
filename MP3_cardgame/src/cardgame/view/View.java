package cardgame.view;

import cardgame.controller.CardGameController;

public interface View {
	public void setController(CardGameController controller);

	public void displayPlayerName();

	public void displayCards();

	public void promptFlip();

	public void promptForNewGame();

	public void promptToReshuffleDeck();

	public void showCardForPlayer(String rank, String suit);
}
