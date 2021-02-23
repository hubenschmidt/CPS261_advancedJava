package cards;

import java.util.ArrayList;

public class Hand {
	ArrayList<Card> cards;

	public Hand() {
		cards = new ArrayList<Card>();
	}

	public void addCard(Card c) {
		cards.add(c);
	}

	public Card getCard(int index) {
		return cards.get(index);
	}

	public Card removeCard() {
		return cards.remove(0);
	}

}
