package cardgame.model;

public enum Suit {
	CLUBS(1), DIAMONDS(2), HEARTS(3), SPADES(4);

	int suit;

	private Suit(int value) {
		suit = value;
	}

	public int value() {
		return suit;
	}

}
