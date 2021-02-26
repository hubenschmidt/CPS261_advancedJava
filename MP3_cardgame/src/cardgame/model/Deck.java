package cardgame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
	ArrayList<Card> cards;
	int index = 1;

	public Deck() {
		System.out.println("Initializing deck");
		this.cards = new ArrayList<Card>();

		for (Rank rank : Rank.values()) {
			for (Suit suit : Suit.values()) {
				cards.add(new Card(rank, suit, index++));
			}
		}

		// add jokers
		cards.add(new Card("JOKER", "RED", index++));
		cards.add(new Card("JOKER", "BLACK", index++));

		for (int i = 0; i < this.cards.size(); i++) {

			System.out.println("Initializing deck. Create card: [" + cards.get(i).getRank() + " "
					+ cards.get(i).getSuit() + " " + cards.get(i).getJoker() + " " + cards.get(i).getJokerColor() + " "
					+ cards.get(i).getIndex() + "]");
		}

		shuffle(); // shuffle deck upon initialization
	}

	public void shuffle() {
		System.out.println("Shuffling deck");
		Random random = new Random();
		for (int i = 0; i < this.cards.size(); i++) {
			Collections.swap(this.cards, i, random.nextInt(this.cards.size()));
			System.out.println("% " + cards.get(i).getRank() + " " + cards.get(i).getSuit() + " "
					+ cards.get(i).getIndex() + " %");
		}
	};

	public Card removeTopCardFromDeck() {
		return cards.remove(0);
	}
}
