package cardgame.controller;

import java.util.ArrayList;
import java.util.List;

import cardgame.model.Card;
import cardgame.model.Game;
import cardgame.model.Player;

public class CardGameController {
	enum State {
		AddPlayers, CardsDealt, CardsRevealed, EmptyDeck;
	}

	private Game game;
	private List<Card> cards;
	private State state;

	public CardGameController(int cardsPerHand, ArrayList<Player> players) {
		this.game = new Game(cardsPerHand, players); // controller instantiates new Game
		this.cards = new ArrayList<>();
		this.state = State.AddPlayers;
		run(); // automatically run game when controller is instantiated

	}

	public void run() {
		switch (state) {
		case AddPlayers:
			dealCards();
			break;
		case CardsDealt:
//			displayCards();
			break;
		case CardsRevealed:
			break;
		case EmptyDeck:
			break;
		}
	}

	public void dealCards() {
		// deal cards to players by getting hand from player. // send this
		// to the application
		System.out.println("dealCards() called");
		for (int i = 0; i < game.getCardsPerHand(); i++) { // depending on the number of cards per hand
			for (Player p : game.getPlayers()) { // for each player in the list of players,
				p.addCardToHand(game.getDeck().removeTopCardFromDeck()); // distribute top card from deck to player
			}
		}

		List<Card> cards = new ArrayList<>();

		for (Player p : game.getPlayers()) {
			for (Card c : p.getHand().getCards()) {
				cards.add(c);
			}
		}
		setCards(cards);
		state = State.CardsDealt;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public void flipCard() {

	}

	public void resetHand() {
//		player.clearHand();
	}

	public void reshuffleDeck() {
		game.getDeck().shuffle();
	}
}