package cardgame.controller;

import cardgame.model.Card;
import cardgame.model.Deck;
import cardgame.model.Player;
import cardgame.view.ViewJavaFX;

public class CardGameController {
	enum State {
		AddPlayers, CardsDealt, CardsRevealed, EmptyDeck;
	}

	private Deck deck;
	private Player player;
//	private ViewCLI viewCLI;
	private ViewJavaFX viewJavaFX;
	private int cardCounter;
	private State state;

	public CardGameController(ViewJavaFX view, Deck deck, Player player) {
		this.viewJavaFX = view;
		this.deck = deck;
		this.setPlayer(player);
		state = State.AddPlayers;
	}

	public void run() {

		while (true) {
			switch (state) {
			case AddPlayers:
//				viewCLI.displayPlayerName();
				viewJavaFX.displayPlayerName();
				startGame();
				break;
			case CardsDealt:
//				viewCLI.promptFlip();
				viewJavaFX.promptFlip();
				break;
			case CardsRevealed:
//				viewCLI.promptForNewGame();
				viewJavaFX.promptForNewGame();
				break;
			case EmptyDeck:
//				viewCLI.promptToReshuffleDeck();
				viewJavaFX.promptToReshuffleDeck();
				break;
			}
		}
	}

	public void startGame() {
		System.out.println("Start game");
		if (state != State.CardsDealt) {
			for (int i = 0; i < 4; i++) { // deal 4 cards
				getPlayer().addCardToHand(deck.removeTopCardFromDeck());
			}
			this.cardCounter += 4;
			state = State.CardsDealt;
		}
		if (this.cardCounter >= 54) { // if all cards are dealt,
			this.cardCounter = 0; // reset counter;
			state = State.EmptyDeck;
		}
	}

	public void flipCards() {
		for (int i = 0; i < 4; i++) {
			Card card = getPlayer().getCard(i);
			card.flip();
//			viewCLI.showCardForPlayer(card.getRank().toString(), card.getSuit().toString());
			viewJavaFX.showCardForPlayer(card.getRank().toString(), card.getSuit().toString());
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
