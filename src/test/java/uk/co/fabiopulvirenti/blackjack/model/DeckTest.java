package uk.co.fabiopulvirenti.blackjack.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    private Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck();
    }

    @Test
    @DisplayName("Deck has 52 cards at the beginning")
    void deckHas52CardsAtTheBeginning() {
        assertEquals(52, deck.getCardCount());
    }


    @Test
    @DisplayName("Deck has one card less after giving a card")
    void getCard() {
        assertEquals(52, deck.getCardCount());
        Card card = deck.getCard();

        assertNotNull(card);
        assertNotNull(card.getRank());
        assertNotNull(card.getSuit());

        assertEquals(51, deck.getCardCount());
    }

    @Test
    @DisplayName("Deck has 4 card less after giving 4 card")
    void getCardCount() {
        assertEquals(52, deck.getCardCount());

        deck.getCard();
        deck.getCard();
        deck.getCard();
        deck.getCard();

        assertEquals(48, deck.getCardCount());

    }

    @Test
    @DisplayName("Deck has is well formed with 4 aces, kings, queens and jacks")
    void thereAre4AcesKingsQueensJacks() {
        List<Card> aces = new ArrayList<>();
        List<Card> kings = new ArrayList<>();
        List<Card> queens = new ArrayList<>();
        List<Card> jacks = new ArrayList<>();

        for (int i = 0; i < 52; i++) {
            Card card = deck.getCard();

            if (card.getRank() == Rank.ACE) {
                aces.add(card);
            } else if (card.getRank() == Rank.KING) {
                kings.add(card);
            } else if (card.getRank() == Rank.QUEEN) {
                queens.add(card);
            } else if (card.getRank() == Rank.JACK) {
                jacks.add(card);
            }
        }

        assertEquals(4, aces.size());
        assertEquals(4, kings.size());
        assertEquals(4, queens.size());
        assertEquals(4, jacks.size());
    }

    @Test
    @DisplayName("Deck is empty after dealing 52 cards")
    void isEmpty() {
        assertFalse(deck.isEmpty());
        for (int i = 0; i < 52; i++) {
            deck.getCard();
        }
        assertTrue(deck.isEmpty());
    }

    //Attempt to test the shuffling is working
    @Test
    @DisplayName("After creation the Deck is shuffled randomly.")
    void differentCards() {
        Card card1Deck1 = deck.getCard();
        Card card2Deck1 = deck.getCard();

        Deck deck2 = new Deck();
        Card card1Deck2 = deck2.getCard();
        Card card2Deck2 = deck2.getCard();

        assertNotEquals(card1Deck1, card1Deck2);
        assertNotEquals(card2Deck1, card2Deck2);
    }
}
