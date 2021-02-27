package cardgame.controller;

import java.util.ArrayList;
import java.util.List;

import cardgame.model.Card;
import cardgame.model.Game;
import cardgame.model.Player;
import cardgame.view.ViewJavaFX;
import javafx.stage.Stage;

public class CardGameController {
	public enum State {
		AddPlayers, CardsDealt, CardsRevealed, EmptyDeck;
	}

	private Game game;
	private List<Card> cards;
	private State state;
	private ViewJavaFX view;
	private Stage stage = new Stage();

	public CardGameController(int cardsPerHand, ArrayList<Player> players) {
		this.game = new Game(cardsPerHand, players); // controller instantiates new Game
		this.cards = new ArrayList<>();
		this.state = State.AddPlayers;

	}

	/*
	 * rudimentary state management
	 */
	public void run() {
		switch (state) {
		case AddPlayers:
			dealCards();
			break;
		case CardsDealt:
			break;
		case CardsRevealed:
			break;
		case EmptyDeck:
			reshuffleDeck();
			game.setCardCounter(0);
			System.out.println(game.getCardCounter());
			setState(State.AddPlayers);
			view.displayGUI(stage);
			break;
		}
	}

	/*
	 * deals cards
	 */
	public void dealCards() {
		resetHand();
		cards.clear();

		int cardCount = game.getCardCounter();
		game.setCardCounter(cardCount += 4);

		for (int i = 0; i < game.getCardsPerHand(); i++) { // depending on the number of cards per hand
			for (Player p : game.getPlayers()) { // for each player in the list of players,
				if (game.getCardCounter() <= 54) {
					p.addCardToHand(game.getDeck().removeTopCardFromDeck()); // distribute top card from deck to player
				}

				else if (game.getDeck().removeTopCardFromDeck() == null) {
					setState(State.EmptyDeck);
					System.out.println("game over");
					run();
				}
			}

			List<Card> cards = new ArrayList<>();
			if (cards.size() == game.getCardsPerHand()) {
				for (Player p : game.getPlayers()) {
					int counter = 0;
					for (Card c : p.getHand().getCards()) {
						cards.set(counter++, c);
					}
				}
			}

			for (Player p : game.getPlayers()) {
				for (Card c : p.getHand().getCards()) {
					cards.add(c);
				}
			}
			setCards(cards);
			state = State.CardsDealt;
		}
	}

	/*
	 * getters and setters
	 */
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public void clearCards() {
		cards.clear();
	}

	/*
	 * resets each player's hand
	 */
	public void resetHand() {
		for (Player p : game.getPlayers()) {
			p.getHand().clearHand();
		}
	}

	/*
	 * shuffles the deck
	 */
	public void reshuffleDeck() {
		game.getDeck().shuffle();
	}
}