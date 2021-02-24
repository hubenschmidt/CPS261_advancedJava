package cardgame.controller;

import cardgame.model.Card;
import cardgame.model.Deck;
import cardgame.model.Player;
import cardgame.view.ViewCLI;

public class CardGameController {
	enum State {
		AddPlayers, CardsDealt, CardsRevealed, EmptyDeck;
	}

	private Deck deck;
	private Player player;
	private ViewCLI view;
	private int cardCounter;
	private State state;

	public CardGameController(ViewCLI view, Deck deck, Player player) {
		this.view = view;
		this.deck = deck;
		this.setPlayer(player);
		state = State.AddPlayers;
	}

	public void run() {
		while (true) {
			switch (state) {
			case AddPlayers:
				view.displayPlayerName();
				startGame();
				break;
			case CardsDealt:
				view.promptFlip();
				break;
			case CardsRevealed:
				view.promptForNewGame();
				break;
			case EmptyDeck:
				view.promptToReshuffleDeck();
				break;
			}
		}
	}

	public void startGame() {
		if (state != State.CardsDealt) {

			for (int i = 0; i < 4; i++) { // deal 4 cards
				getPlayer().addCardToHand(deck.removeTopCardFromDeck());
			}
			this.cardCounter += 4;
			state = State.CardsDealt;
		}
		if (this.cardCounter >= 52) { // if all cards are dealt,
			this.cardCounter = 0; // reset counter;
			state = State.EmptyDeck;
		}
	}

	public void flipCards() {
		for (int i = 0; i < 4; i++) {
			Card card = getPlayer().getCard(i);
			card.flip();
			view.showCardForPlayer(card.getRank().toString(), card.getSuit().toString());
		}
		state = State.CardsRevealed;
	}

	public void resetHand() {
		getPlayer().clearHand();
	}

	public void reshuffleDeck() {
		deck = new Deck();
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
