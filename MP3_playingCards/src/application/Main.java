package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
// Scene, Group, Node, etc.
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
// Text, Font
import javafx.scene.text.Text;
import javafx.stage.Stage;

//ImageStore is a class that contains only static members.
//It will be used to store references to Image objects that
//need to be accessed from the Card class. The Image objects
//will be created when this program starts executing.

class ImageStore {
	static Image card_back_image;

	static HashMap<String, Image> card_face_images;
}

class Card extends ImageView {
	int card_rank;
	int card_suit;

	Image card_faceup_image;

	// face-up = card suit and rank are visible
	// face-down = card suit and rank are not visible

	// boolean this_card_is_face_up = false ;

	// The following static data fields can be accessed from
	// other classes by writing Card.HEARTS, Card.DIAMONDS, etc.

	public static final int HEARTS = 1;
	public static final int DIAMONDS = 2;
	public static final int SPADES = 3;
	public static final int CLUBS = 4;

	public static final int CARD_WIDTH = 150;
	public static final int CARD_HEIGHT = 215;

	public Card(int given_card_rank, int given_card_suit) {
		card_rank = given_card_rank;
		card_suit = given_card_suit;

		// A reference to an Image object will be retrieved by using
		// a string as a key. For example, with the string "spades1" the
		// image of the Ace of Spades is found.

		if (card_suit == HEARTS) {
			card_faceup_image = ImageStore.card_face_images.get("hearts" + card_rank);
		} else if (card_suit == DIAMONDS) {
			card_faceup_image = ImageStore.card_face_images.get("diamonds" + card_rank);
		} else if (card_suit == SPADES) {
			card_faceup_image = ImageStore.card_face_images.get("spades" + card_rank);
		} else if (card_suit == CLUBS) {
			card_faceup_image = ImageStore.card_face_images.get("clubs" + card_rank);
		}

		setImage(ImageStore.card_back_image); // Initially the card is face-down
	}

	public int get_rank() {
		return card_rank;
	}

	public int get_suit() {
		return card_suit;
	}

	public void turn_card() {
		if (getImage() == card_faceup_image) {
			setImage(ImageStore.card_back_image);
		} else {
			setImage(card_faceup_image);
		}
	}

	public void turn_card_face_up() {
		setImage(card_faceup_image);
	}

	public void turn_card_face_down() {
		setImage(ImageStore.card_back_image);
	}

	public boolean card_is_face_up() {
		return (getImage() == card_faceup_image);
	}

	public boolean card_is_face_down() {
		return (getImage() != card_faceup_image);
	}

	public void set_card_position(double given_position_x, double given_position_y) {
		setX(given_position_x);
		setY(given_position_y);
	}

	public double get_card_position_x() {
		return getX();
	}

	public double get_card_position_y() {
		return getY();
	}

	public String get_suit_as_string() {
		String string_to_return = "";

		switch (card_suit) {
		case HEARTS:
			string_to_return = "Hearts";
			break;
		case DIAMONDS:
			string_to_return = "Diamonds";
			break;
		case SPADES:
			string_to_return = "Spades";
			break;
		case CLUBS:
			string_to_return = "Clubs";
			break;
		default:
			string_to_return = "Program error!!!";
		}

		return string_to_return;
	}

	// With the following methods it is possible to compare
	// "this" card to anohter card.

	// Making general comparisons between cards is somewhat
	// difficult as different card games value cards in
	// different ways. All the following methods are not
	// suitable for all card games. One known problem is that
	// an Ace is considered the smallest card by the methods.

	public boolean belongs_to_suit_of(Card another_card) {
		return (card_suit == another_card.card_suit);
	}

	public boolean does_not_belong_to_suit_of(Card another_card) {
		return (card_suit != another_card.card_suit);
	}

	public boolean is_smaller_than(Card another_card) {
		return (card_rank < another_card.card_rank);
	}

	public boolean is_greater_than(Card another_card) {
		return (card_rank > another_card.card_rank);
	}

	public boolean has_equal_rank_as(Card another_card) {
		return (card_rank == another_card.card_rank);
	}

	public boolean has_different_rank_as(Card another_card) {
		return (card_rank != another_card.card_rank);
	}

	public boolean contains_point(double given_point_x, double given_point_y) {
		// We'll think here that if a Card's position is ( 0, 0 )
		// then no real position has been set, i.e., the Card
		// has not yet been put to the 'table'.

		return (getX() != 0 && getY() != 0 && given_point_x >= getX() && given_point_x <= getX() + CARD_WIDTH
				&& given_point_y >= getY() && given_point_y <= getY() + CARD_HEIGHT);
	}
}

class CardDeck {
	static int[] suits = { Card.HEARTS, Card.DIAMONDS, Card.SPADES, Card.CLUBS };

	ArrayList<Card> cards_in_this_deck = new ArrayList<Card>();

	public CardDeck() {
		for (int suit_index = 0; suit_index < 4; suit_index++) {
			for (int card_rank = 1; card_rank < 14; card_rank++) {
				add_card(new Card(card_rank, suits[suit_index]));
			}
		}
	}

	public void shuffle() {
		// The cards in an ArrayList-based dynamic array can be
		// ordered randomly by using the static method shuffle() of
		// the Collections class.

		Collections.shuffle(cards_in_this_deck);
	}

	public void add_card(Card given_card) {
		if (cards_in_this_deck.size() < 52) {
			cards_in_this_deck.add(given_card);
		}
	}

	public Card get_card() {
		// Value null is returned if there are no available cards
		// in the deck.

		// If cards are left in the deck, the last card in the array
		// is returned, and the returned card is removed from the deck.

		Card card_to_return = null;

		if (cards_in_this_deck.size() > 0) {
			// ArrayList method remove() returns a reference to the
			// object that it removes from the array.

			card_to_return =

					cards_in_this_deck.remove(cards_in_this_deck.size() - 1);
		}

		return card_to_return;
	}
}

public class Main extends Application {
	CardDeck card_deck;

	// A StackPane will be the root pane for all visible things on the screen.

	StackPane root_stack = new StackPane();

	Text initial_instructions = new Text("CLICK THE CARDS AFTER DEALING.");

	Group row_of_cards = new Group();

	Group group_for_lonesome_card = new Group();

	Card lonesome_card;

	Card selected_card;

	@Override
	public void start(Stage stage) {
		try {

			stage.setTitle("PlayingCardsFX.java");

			// The files that contain card face images have
			// names such as hearts1.png, hearts2.png, hearts3.png, etc.
			// They are located in a folder named playing_cards_images.
			// Next we'll programmatically create the file names and
			// corresponding Image objects.

			// The Image objects will be stored in a data structure called
			// HashMap so that the file name body can be used as a key
			// to get references to the Image objects.

			ImageStore.card_back_image = new Image("card_images/back.png");

			ImageStore.card_face_images = new HashMap<String, Image>();

			String[] words_in_image_file_names = { "hearts", "diamonds", "spades", "clubs" };

			for (int suit_index = 0; suit_index < 4; suit_index++) {
				for (int card_rank = 1; card_rank < 14; card_rank++) {
					String image_file_name = "card_images/" + words_in_image_file_names[suit_index] + card_rank
							+ ".png";

					Image card_faceup_image = new Image(image_file_name);

					String key_for_image = words_in_image_file_names[suit_index] + card_rank;

					ImageStore.card_face_images.put(key_for_image, card_faceup_image);
				}
			}

			// Now, that we have loaded the card images, we can create the deck.

			card_deck = new CardDeck();

			// Next, we'll create two buttons and specify the actions that
			// will be performed when the buttons are pressed.

			Button button_to_deal_cards = new Button("DEAL");
			Button button_to_shuffle_deck = new Button("SHUFFLE");

			button_to_deal_cards.setOnAction((ActionEvent event) -> {
				// Before the fist dealing of cards we'll remove the Text
				// from the screen.

				if (initial_instructions != null) {
					root_stack.getChildren().remove(initial_instructions);
					initial_instructions = null;
				}

				// We'll first empty the list 'inside' the Group

				row_of_cards.getChildren().clear();

				for (int card_index = 0; card_index < 5; card_index++) {
					Card new_card = card_deck.get_card();

					double card_position_x = 40 + (Card.CARD_WIDTH + 20) * card_index;
					double card_position_y = 50;

					new_card.set_card_position(card_position_x, card_position_y);

					row_of_cards.getChildren().add(new_card);
				}

				lonesome_card = card_deck.get_card();
				lonesome_card.set_card_position(188, 300);

				group_for_lonesome_card.getChildren().clear();
				group_for_lonesome_card.getChildren().add(lonesome_card);
			});

			button_to_shuffle_deck.setOnAction((ActionEvent event) -> {
				card_deck.shuffle();
			});

			HBox pane_for_buttons = new HBox(16); // space between buttons is 16

			pane_for_buttons.getChildren().addAll(button_to_deal_cards, button_to_shuffle_deck);

			pane_for_buttons.setAlignment(Pos.CENTER); // The Box is centered
			// With an Insets object we can specify empty space around the HBox.
			// There will be 20 pixels padding below the HBox.
			pane_for_buttons.setPadding(new Insets(0, 0, 20, 0));

			BorderPane border_pane = new BorderPane();

			border_pane.setBottom(pane_for_buttons);

			Group main_group_for_cards = new Group();

			// With the following statement we disable the automatic layout
			// management of the Card objects.
			main_group_for_cards.setManaged(false);

			main_group_for_cards.getChildren().addAll(row_of_cards, group_for_lonesome_card);

			initial_instructions.setFont(new Font(24));

			root_stack.getChildren().addAll(border_pane, main_group_for_cards, initial_instructions);

			Scene scene = new Scene(root_stack, 910, 600);

			scene.setOnMouseClicked((MouseEvent event) -> {
				double clicked_point_x = event.getSceneX();
				double clicked_point_y = event.getSceneY();

				if (row_of_cards.getChildren().size() == 5) {
					for (Node card_as_node : row_of_cards.getChildren()) {
						Card card_in_row = (Card) card_as_node;

						if (card_in_row.contains_point(clicked_point_x, clicked_point_y)) {
							card_in_row.turn_card();

							// selected_card will point to the clicked card.
							// In this program, however, selected_card is not
							// used for any purpose.

							selected_card = card_in_row;
						}
					}

					if (lonesome_card != null && lonesome_card.contains_point(clicked_point_x, clicked_point_y)) {
						lonesome_card.turn_card();
					}

				}
			});

			// By eliminating the background specifications of the StackPane,
			// we can make the fill of the Scene visible.

			root_stack.setBackground(null);

			scene.setFill(Color.LAWNGREEN);

			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
