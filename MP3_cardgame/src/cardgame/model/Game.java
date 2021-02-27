package cardgame.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private Deck deck;
	private int cardsPerHand;
	private List<Player> players;
	private int cardCounter;

	public Game(int cardsPerHand, ArrayList<Player> players) {
		System.out.println("initializing Game");
		this.deck = new Deck();
		this.cardsPerHand = cardsPerHand;
		this.players = players;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public Deck getDeck() {
		return deck;
	}

	public int getCardsPerHand() {
		return cardsPerHand;
	}

	public void setCardsPerHand(int cardsPerHand) {
		this.cardsPerHand = cardsPerHand;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public int getCardCounter() {
		return cardCounter;
	}

	public void setCardCounter(int cardCounter) {
		this.cardCounter = cardCounter;
	}

}