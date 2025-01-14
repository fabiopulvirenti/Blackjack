package uk.co.fabiopulvirenti.blackjack.actors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uk.co.fabiopulvirenti.blackjack.model.Deck;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DealerTest {


    private Dealer dealer;
    private Deck deck;

    @BeforeEach
    void setUpEachTest() {
        this.deck = new Deck();
        this.dealer = new Dealer();
        this.dealer.setDeck(deck);
    }

    @Test
    @DisplayName("Test DealOpenHand with a valid list of players")
    void dealOpenHand_ValidListTest() {
        Player player1 = new Player("Fabio");
        Player player2 = new Player("Davide");
        Player player3 = new Player("Thomas");
        List<Player> listOfPlayers = List.of(player1, player2, player3);

        assertEquals(0, player1.getNumberOfCards());
        assertEquals(0, player2.getNumberOfCards());
        assertEquals(0, player3.getNumberOfCards());

        assertEquals(52, deck.getCardCount());

        dealer.dealOpenHand(listOfPlayers);
        assertEquals(2, player1.getNumberOfCards());
        assertEquals(2, player2.getNumberOfCards());
        assertEquals(2, player3.getNumberOfCards());
        assertEquals(46, deck.getCardCount());
    }

    @Test
    @DisplayName("Test DealOpenHand with an empty list of players")
    void dealOpenHand_EmptyListTest() {
        List<Player> listOfPlayers = List.of();
        assertEquals(52, deck.getCardCount());

        dealer.dealOpenHand(listOfPlayers);
        assertEquals(52, deck.getCardCount());
    }

    @Test
    @DisplayName("Test DealOpenHand with a null list of players")
    void dealOpenHand_NullListTest() {
        assertEquals(52, deck.getCardCount());

        try {
            dealer.dealOpenHand(null);
        } catch (IllegalArgumentException e) {
            assertEquals("Player List cannot be null.", e.getMessage());
        }

        assertEquals(52, deck.getCardCount());
    }


}



























