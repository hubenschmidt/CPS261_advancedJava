package cardgame;

import java.util.ArrayList;

public class Hand {
	ArrayList<Card> cards;

	public Hand() {
		cards = new ArrayList<Card>();
		System.out.println(cards);
	}

	public void addCard(Card c) {
		cards.add(c);
	}

	public Card getCard(int i) {
		return cards.get(i);
	}

	public Card removeCard() {
		return cards.remove(0);
	}

}
