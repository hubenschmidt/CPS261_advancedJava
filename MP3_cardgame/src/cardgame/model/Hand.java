package cardgame.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	List<Card> cards;

	public Hand() {
		cards = new ArrayList<Card>();
	}

	public void addCard(Card c) {
		cards.add(c);
	}

	public List<Card> getCards() {
		return cards;
	}

	public void clearHand() {
		cards.clear();
	}

}
