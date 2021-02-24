package cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
	ArrayList<Card> cards;

	public Deck() {
		cards = new ArrayList<Card>();
		for (Rank rank : Rank.values()) {
			for (Suit suit : Suit.values()) {
				System.out.println("Initializing deck. Create card: [" + rank + " " + suit + "]");
				cards.add(new Card(rank, suit));
			}
		}

		shuffle();

	}

	public void shuffle() {
		Random random = new Random();
		for (int i = 0; i < cards.size(); i++) {
			Collections.swap(cards, i, random.nextInt(cards.size()));
		}
	};

	public Card removeTopCard() {
		return cards.remove(0);
	}
//
//	public void returnCardToDeck(Card c) {
//		cards.add(c);
//	}

}
