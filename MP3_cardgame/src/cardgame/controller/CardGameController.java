package cardgame.controller;

import cardgame.model.Card;
import cardgame.model.Deck;
import cardgame.model.Player;
import cardgame.model.Rank;
import cardgame.model.Suit;
import cardgame.view.ViewJavaFX;
import javafx.scene.image.Image;

public class CardGameController {
	enum State {
		AddPlayers, CardsDealt, CardsRevealed, EmptyDeck;
	}

	private Card card;
	private Deck deck;
	private Player player;
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
		switch (state) {
		case AddPlayers:
//	viewJavaFX.displayPlayerName();
			startGame();
			break;
		case CardsDealt:
			viewJavaFX.promptFlip();
			break;
		case CardsRevealed:
			viewJavaFX.promptForNewGame();
			break;
		case EmptyDeck:
			viewJavaFX.promptToReshuffleDeck();
			break;

		}
//JavaFX does not appear to be compatible with infinite loop
//		while (true) {
//			switch (state) {
//			case AddPlayers:
////				viewJavaFX.displayPlayerName();
//				startGame();
//				break;
//			case CardsDealt:
//				viewJavaFX.promptFlip();
//				break;
//			case CardsRevealed:
//				viewJavaFX.promptForNewGame();
//				break;
//			case EmptyDeck:
//				viewJavaFX.promptToReshuffleDeck();
//				break;
//			}
//		}
	}

	public void startGame() {
		System.out.println("Start game");
		if (state != State.CardsDealt) {
			for (int i = 0; i < 4; i++) { // deal 4 cards
				getPlayer().addCardToHand(deck.removeTopCardFromDeck());

//				viewJavaFX.displayCardsFaceDown();
			}
			this.cardCounter += 4;
			state = State.CardsDealt;
			run(); // checks state change. JavaFX incompatible with infinite loop?
		}
		if (this.cardCounter >= 54) { // if all cards are dealt,
			this.cardCounter = 0; // reset counter;
			state = State.EmptyDeck;
			run(); // checks state change. JavaFX incompatible with infinite loop?
		}
	}

	public Image getCardSide() {
		if (card.isFaceUp()) {
			return card.getCardFront();
		}
		return card.getCardBack();
	}

	public void flipCards() {
		for (int i = 0; i < 4; i++) {
			Card card = getPlayer().getCard(i);
			card.flip();
//			viewJavaFX.showCardForPlayer(card.getIndex());
			System.out.println(card.getIndex() + " " + card.getRank() + " " + card.getSuit());
		}
		state = State.CardsRevealed;
		run(); // checks state change. JavaFX incompatible with infinite loop?
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

	public void setCardFront(Image cardFront) {
		card.setCardFront(cardFront);
	}

	public Image getCardFront() {
		return card.getCardFront();
	}

	public void setCardBack(Image cardBack) {
		card.setCardBack(cardBack);
	}

	public Image getCardBack() {
		return card.getCardBack();
	}

	public Rank getCardRank() {
		return card.getRank();
	}

	public Suit getCardSuit() {
		return card.getSuit();
	}

}
