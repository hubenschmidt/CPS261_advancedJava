package cards;

public class Card {
	Rank rank;
	Suit suit;
	boolean faceUp;

	public Card(Rank r, Suit s) {
		rank = r;
		suit = s;
		faceUp = false;
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public boolean isFaceUp() {
		return faceUp;
	}

	public boolean flip() {
		faceUp = !faceUp;
		return faceUp;
	}

}
