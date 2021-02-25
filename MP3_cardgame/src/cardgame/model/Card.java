package cardgame.model;

import javafx.scene.image.Image;

public class Card {
	Rank rank;
	Suit suit;
	int index;
	String color;
	String joker;
	boolean faceUp;
	private Image cardFront;
	private Image cardBack;

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

	public Image getCardFront() {
		return cardFront;
	}

	public void setCardFront(Image cardFront) {
		this.cardFront = cardFront;
	}

	public Image getCardBack() {
		return cardBack;
	}

	public void setCardBack(Image cardBack) {
		this.cardBack = cardBack;
	}

}
