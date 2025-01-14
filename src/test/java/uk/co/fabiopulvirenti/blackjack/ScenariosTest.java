package uk.co.fabiopulvirenti.blackjack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uk.co.fabiopulvirenti.blackjack.actors.Dealer;
import uk.co.fabiopulvirenti.blackjack.actors.Player;
import uk.co.fabiopulvirenti.blackjack.model.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing the Given Scenarios
 */
public class ScenariosTest {

    private Player player;
    private Dealer dealer;


    @BeforeEach
    void setUpEachTest() {
        Deck deck = new Deck();
        this.dealer = new Dealer();
        this.dealer.setDeck(deck);
        this.player = new Player("Fabio");
    }


    @Test
    @DisplayName("""
                Scenario 1:
                Given I play a game of blackjack
                When I am dealt my opening hand
                Then I have two cards
            """)
    void openingHandTest() {
        assertEquals(0, this.player.getNumberOfCards());

        this.dealer.dealOpenHand(List.of(this.player));

        assertEquals(2, this.player.getNumberOfCards());
    }


    @Test
    @DisplayName("""
                Scenario 2:
                Given I have a valid hand of cards
                When I choose to 'hit'
                Then I receive another card
                And my score is updated
            """)
    void hitCardTest() {
        this.dealer.dealOpenHand(List.of(this.player));
        assertEquals(2, this.player.getNumberOfCards());

        int score = this.player.getScore();

        this.dealer.valueChoiceOfPlayer(this.player, PlayerChoice.HIT);

        //Then I receive another card
        assertEquals(3, this.player.getNumberOfCards());

        //And my score is updated
        assertTrue(score != this.player.getScore());
    }

    @Test
    @DisplayName("""
                Scenario 3:
                Given I have a valid hand of cards
                When I choose to ‘stand’
                Then I receive no further cards
                And my score is evaluated
            """)
    void standCardTest() {
        this.dealer.dealOpenHand(List.of(this.player));
        assertEquals(2, this.player.getNumberOfCards());
        assertTrue(player.hasValidHand());

        assertFalse(this.dealer.isPlayerEvaluated(this.player));

        // When I choose to 'stand'
        this.dealer.valueChoiceOfPlayer(this.player, PlayerChoice.STAND);
        //Then I receive no further cards
        assertEquals(2, this.player.getNumberOfCards());

        // And my score is evaluated
        assertTrue(this.dealer.isPlayerEvaluated(this.player));

    }


    @Test
    @DisplayName("""
                Scenario 4:
                Given my score is updated or evaluated
                When it is 21 or less
                Then I have a valid hand
            """)
    void validHandScore21OrLessTest() {
        this.dealer.dealOpenHand(List.of(this.player));
        assertEquals(2, this.player.getNumberOfCards());

        dealer.evaluatePlayer(this.player);
        // At this stage the score is always 21 or less,
        // because the opening card won't exceed it

        assertTrue(this.player.hasValidHand());
        assertFalse(this.player.isBust());
    }


    @Test
    @DisplayName("""
                Scenario 5:
                Given my score is updated
                When it is 22 or more
                Then I am ‘bust’ and do not have a valid hand
            """)
    void scoreUpdated22OrMoreTest() {
        assertEquals(0, this.player.getNumberOfCards());
        this.dealer.dealOpenHand(List.of(this.player));
        assertEquals(2, this.player.getNumberOfCards());
        Card card = new Card(Rank.JACK, Suit.SPADE);
        this.player.hitCard(card);
        assertEquals(3, this.player.getNumberOfCards());
        int score = this.player.getScore();

        if (score < 22) {
            Card card1 = new Card(Rank.TEN, Suit.SPADE);
            this.player.hitCard(card1);
            assertEquals(4, this.player.getNumberOfCards());
            // now for sure the score is greater than 21
        }
        assertTrue(this.player.getScore() > 21);
        assertTrue(this.player.isBust());
        assertFalse(this.player.hasValidHand());
    }


    @Test
    @DisplayName("""
                Scenario 6:
                Given I have a king and an ace
                When my score is evaluated
                Then my score is 21
            """)
    void kingAceHandTest() {
        Card card1 = new Card(Rank.KING, Suit.SPADE);
        Card card2 = new Card(Rank.ACE, Suit.HEART);
        this.player.openingHand(card1, card2);

        int score = this.player.getScore();
        assertEquals(21, score);
    }

    @Test
    @DisplayName("""
                Scenario 7:
                Given I have a king, a queen, and an ace
                When my score is evaluated
                Then my score is 21
            """)
    void kingQueenAceHandTest() {
        Card card1 = new Card(Rank.KING, Suit.SPADE);
        Card card2 = new Card(Rank.QUEEN, Suit.HEART);
        Card card3 = new Card(Rank.ACE, Suit.CLUB);
        this.player.openingHand(card1, card2);
        this.player.hitCard(card3);

        int score = this.player.getScore();
        assertEquals(21, score);
    }


    @Test
    @DisplayName("""
                Scenario 8:
                Given I have a nine, an ace, and another ace
                When my score is evaluated
                Then my score is 21
            """)
    void nineAceAceHandTest() {
        Card card1 = new Card(Rank.NINE, Suit.DIAMOND);
        Card card2 = new Card(Rank.ACE, Suit.HEART);
        Card card3 = new Card(Rank.ACE, Suit.CLUB);
        this.player.openingHand(card1, card2);
        this.player.hitCard(card3);

        int score = this.player.getScore();
        assertEquals(21, score);
    }

}
