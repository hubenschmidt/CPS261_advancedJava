package cardgame.view;

public interface View {

	public void displayPlayerName();

	public void displayCards();

	public void promptFlip();

	public void promptForNewGame();

	public void promptToReshuffleDeck();

	public void showCardForPlayer(String rank, String suit);
}
