package cardgame.model;

import javafx.scene.image.Image;

public class Card {
	private Rank rank;
	private Suit suit;
	private String joker;
	private String jokerColor;
	private int index;
	boolean faceUp;
	private Image cardBack;
	private Image cardFront;

	public Card(Rank r, Suit s, int i) {
		this.rank = r;
		this.suit = s;
		this.index = i;
		this.faceUp = false;
		this.cardBack = new Image("card_images/" + this.index + ".png");
		this.cardFront = new Image("card_images/back.png");

	}

	public Card(String joker, String jokerColor, int i) {
		this.joker = joker;
		this.jokerColor = jokerColor;
		this.index = i;
		this.faceUp = false;
		this.cardBack = new Image("card_images/" + this.index + ".png");
		this.cardFront = new Image("card_images/back.png");

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
		return jokerColor;
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
//		this.cardFront = cardFront;
	}

	public Image getCardBack() {
		return cardBack;
	}

	public void setCardBack(Image cardBack) {
		this.cardBack = cardBack;
	}

}
