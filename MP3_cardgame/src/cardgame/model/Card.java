package cardgame.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Card extends ImageView {

	private Rank rank;
	private Suit suit;
	private String joker;
	private String jokerColor;
	private int width;
	private int height;
	private int index;
	boolean faceUp;
	private Image cardBack;
	private Image cardFront;

	public Card(Rank r, Suit s, int i) {
		super();
		this.rank = r;
		this.suit = s;
		this.index = i;
		this.width = 72;
		this.height = 96;
		this.faceUp = false;
		this.cardBack = new Image("card_images/backCard.png");
		this.cardFront = new Image("card_images/" + this.index + ".png");
		super.setImage(setImageForImageView());
//		super.setImage(cardFront);
//		super.setPreserveRatio(false); // aspect ratio
//		super.setSmooth(true); // aspect ratio
		super.setPickOnBounds(true); // to respond to mouse clicks

	}

	public Card(String joker, String jokerColor, int i) {
		super();
		this.joker = joker;
		this.jokerColor = jokerColor;
		this.index = i;
		this.width = 72;
		this.height = 96;
		this.faceUp = false;
		this.cardBack = new Image("card_images/backCard.png");
		this.cardFront = new Image("card_images/" + this.index + ".png");
		super.setImage(setImageForImageView());
//		super.setImage(cardFront);
//		super.setPreserveRatio(false); // aspect ratio
//		super.setSmooth(true); // aspect ratio
		super.setPickOnBounds(true); // to respond to mouse clicks
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
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

	public Image getCardBack() {
		return cardBack;
	}

	public Image setImageForImageView() {
		if (faceUp) {
			return getCardFront();
		}
		return getCardBack();
	}

	public void set_card_position(double position_x, double position_y) {
		setX(position_x);
		setY(position_y);
	}

}
