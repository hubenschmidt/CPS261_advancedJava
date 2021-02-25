package cardgame.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private Deck deck;
	private int cardsPerHand;
	private List<Player> players;

	public Game(int cardsPerHand, ArrayList<Player> players) {
		System.out.println("initializing Game");
		this.deck = new Deck();
		this.cardsPerHand = cardsPerHand;
		this.players = players;
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

}