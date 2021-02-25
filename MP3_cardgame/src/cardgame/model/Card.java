package cardgame.model;

public class Card {
	Rank rank;
	Suit suit;
	int index;
	String color;
	String joker;
	boolean faceUp;

	public Card(Rank r, Suit s, int i) {
		rank = r;
		suit = s;
		index = i;
		faceUp = false;
	}

	public Card(String color, String joker, int i) {
		this.color = color;
		this.joker = joker;
		this.index = i;
		faceUp = false;
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public String getJoker() {
		return joker;
	}

	public String getJokerColor() {
		return color;
	}

	public int getIndex() {
		return index;
	}

	public boolean isFaceUp() {
		return faceUp;
	}

	public boolean flip() {
		faceUp = !faceUp;
		return faceUp;
	}

}
