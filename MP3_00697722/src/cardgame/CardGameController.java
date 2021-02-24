package cardgame;

import java.util.ArrayList;

public class CardGameController {
	enum State {
		AddPlayers, CardsDealt;
	}

	Deck deck;
	Player player;
	ArrayList<Player> players;
	CardGameView view;
	State state;

	public CardGameController(CardGameView view, Deck deck, Player player) {
		this.view = view;
		this.deck = deck;
		this.player = player;
		addPlayer(player);
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
			}
		}
	}

	public void addPlayer(Player player) {
		if (state == state.AddPlayers) {
			players.add(player);
		}
	}

	public void startGame() {
		if (state != State.CardsDealt) {
			deck.shuffle();

			// deal 4 cards
			for (int i = 0; i < 4; i++) {
				player.addCardToHand(deck.removeTopCard());
			}

			state = State.CardsDealt;
		}

	}

	public void flipCards() {
		Card card = player.getCard(0);
		card.flip();
		view.showCardForPlayer(card.getRank().toString(), card.getSuit().toString());
	}

}
