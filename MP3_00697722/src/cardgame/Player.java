package cardgame;

public class Player {
	String name;
	Hand hand;

	public Player(String name) {
		this.name = name;
		this.hand = new Hand();
	}

	public String getName() {
		return name;
	}

	public void addCardToHand(Card c) {
		hand.addCard(c);
	}

	public Card getCard(int i) {
		return hand.getCard(i);
	}

	public void clearHand() {
		hand.clearHand();
	}

}