package uk.co.fabiopulvirenti.blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uk.co.fabiopulvirenti.blackjack.actors.Player;
import uk.co.fabiopulvirenti.blackjack.model.Card;
import uk.co.fabiopulvirenti.blackjack.model.Rank;
import uk.co.fabiopulvirenti.blackjack.model.Suit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScenariosTest {

    @Test
    @DisplayName("""
                Given I play a game of blackjack
                When I am dealt my opening hand
                Then I have two cards
            """)
    void openingHandTest() {
        Player player1= new Player("Fabio");
        Card card1 = new Card(Rank.QUEEN, Suit.HEART);
        Card card2 = new Card(Rank.ACE, Suit.DIAMOND);

        assertEquals(0, player1.getNumberOfCards());


        player1.openingHand(card1,card2);
        assertEquals(2,player1.getNumberOfCards());
    }



    @Test
    @DisplayName("""
            Given I have a valid hand of cards
            When I choose to 'hit'
            Then I receive another card
            And my score is updated
            """)
    void hitCardTest(){
        Player player1 = new Player("Fabio");
        Card card1 = new Card(Rank.NINE, Suit.SPADE);
        Card card2 = new Card(Rank.THREE, Suit.SPADE);
        Card card3 = new Card(Rank.TWO, Suit.SPADE);

        assertEquals(0, player1.getScore());

        player1.openingHand(card1,card2);
        assertEquals(12, player1.getScore());

        player1.hitCard(card3);
        assertEquals(14,player1.getScore());
    }








}