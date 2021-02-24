package cardgame;

import java.util.ArrayList;

public class CardGameController {
	enum State {
		AddPlayers, CardsDealt, CardsRevealed, EmptyDeck;
	}

	Deck deck;
	Player player;
	ArrayList<Player> players;
	CardGameView view;
	int cardCounter;
	State state;

	public CardGameController(CardGameView view, Deck deck, Player player) {
		this.view = view;
		this.deck = deck;
		this.player = player;
//		addPlayer(player);
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

//	public void addPlayer(Player player) {
//		if (state == state.AddPlayers) {
//			players.add(player);
//		}
//	}

	public void startGame() {
		if (state != State.CardsDealt) {

			for (int i = 0; i < 4; i++) { // deal 4 cards
				player.addCardToHand(deck.removeTopCardFromDeck());
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
			Card card = player.getCard(i);
			card.flip();
			view.showCardForPlayer(card.getRank().toString(), card.getSuit().toString());
		}
		state = State.CardsRevealed;
	}

	public void resetHand() {
		player.clearHand();
	}

	public void reshuffleDeck() {
		deck = new Deck();
	}
}
