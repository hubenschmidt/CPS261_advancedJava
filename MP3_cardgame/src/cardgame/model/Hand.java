package cardgame.model;

import java.util.ArrayList;

public class Hand {
	ArrayList<Card> cards;

	public Hand() {
		cards = new ArrayList<Card>();
	}

	public void addCard(Card c) {
		cards.add(c);
	}

	public Card getCard(int i) {
		return cards.get(i);
	}

	public void clearHand() {
		cards.clear();
	}

}
