package uk.co.fabiopulvirenti.blackjack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uk.co.fabiopulvirenti.blackjack.actors.Dealer;
import uk.co.fabiopulvirenti.blackjack.actors.Player;
import uk.co.fabiopulvirenti.blackjack.model.Deck;
import uk.co.fabiopulvirenti.blackjack.model.PlayerChoice;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
            Given I have a valid hand of cards
            When I choose to 'hit'
            Then I receive another card
            And my score is updated
            """)
    void hitCardTest(){
        this.dealer.dealOpenHand(List.of(this.player));
        assertEquals(2, this.player.getNumberOfCards());
        int score = this.player.getScore();

        this.dealer.valueChoiceOfPlayer(this.player, PlayerChoice.HIT);

        //Then I receive another card
        assertEquals(3, this.player.getNumberOfCards());

        //And my score is updated
        assertTrue(score < this.player.getScore());

//        Card card1 = new Card(Rank.NINE, Suit.SPADE);
//        Card card2 = new Card(Rank.THREE, Suit.SPADE);
//        Card card3 = new Card(Rank.TWO, Suit.SPADE);
//
//        assertEquals(0, player1.getScore());
//
//        player1.openingHand(card1,card2);
//        assertEquals(12, player1.getScore());
//
//        player1.hitCard(card3);
//        assertEquals(14,player1.getScore());
    }

    @Test
    @DisplayName("""
            Given I have a valid hand of cards
            When I choose to ‘stand’
            Then I receive no further cards
            And my score is evaluated
            """)
    void standCardTest(){
        this.dealer.dealOpenHand(List.of(this.player));
        assertEquals(2, this.player.getNumberOfCards());
        assertTrue(player.hasValidHand());

        assertFalse(this.dealer.isPlayerEvaluated(this.player));

        this.dealer.valueChoiceOfPlayer(this.player, PlayerChoice.STAND);
        assertEquals(2, this.player.getNumberOfCards());

        assertTrue(this.dealer.isPlayerEvaluated(this.player));

    }








}
