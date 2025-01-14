package uk.co.fabiopulvirenti.blackjack.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class represents the deck for French-suited playing cards.
 */
public class Deck {
    private final List<Card> cards;

    /**
     * It returns an instance of Deck with 52 cards already shuffled
     */
    public Deck() {
        this.cards = new ArrayList<>();

        //Create the cards of the deck
        for (final Suit suit : Suit.values()) {
            for (final Rank rank : Rank.values()) {
                Card card = new Card(rank, suit);
                this.cards.add(card);
            }
        }
        //Shuffling the cards to play the game
        Collections.shuffle(this.cards);
    }

    /**
     * It gets the first card on top of the deck and remove it from the deck.
     *
     * @return Card
     */
    public Card getCard() {
        return this.cards.removeFirst();
    }

    /**
     * It gets the number of cards currently in the deck.
     *
     * @return an integer representing the number of cards
     */
    public int getCardCount() {
        return this.cards.size();
    }

    /**
     * It checks if the deck has cards left.
     *
     * @return true if the deck is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.cards.isEmpty();
    }
}
