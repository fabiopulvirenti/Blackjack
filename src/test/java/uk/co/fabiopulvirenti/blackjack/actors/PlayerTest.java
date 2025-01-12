package uk.co.fabiopulvirenti.blackjack.actors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uk.co.fabiopulvirenti.blackjack.model.Card;
import uk.co.fabiopulvirenti.blackjack.model.Rank;
import uk.co.fabiopulvirenti.blackjack.model.Suit;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    @DisplayName("queen six five cards,value is 21")
    void valueHand_QueenSixFive_Test(){
        Player player1 = new Player("Fabio");
        Card card1 = new Card(Rank.QUEEN, Suit.HEART);
        Card card2 = new Card(Rank.SIX, Suit.DIAMOND);

        player1.openingHand(card1, card2);
        assertEquals(6,player1.valueHand());

        Card card3 = new Card(Rank.FIVE, Suit.SPADE);
        player1.hitCard(card3);
        assertEquals(21,player1.valueHand());

    }

    @Test
    @DisplayName("three six five cards,value is 14")
    void valueHand_ThreeSixFive_Test(){
        Player player1 = new Player("Fabio");
        Card card1 = new Card(Rank.THREE, Suit.HEART);
        Card card2 = new Card(Rank.SIX, Suit.DIAMOND);

        player1.openingHand(card1, card2);
        assertEquals(9,player1.valueHand());

        Card card3 = new Card(Rank.FIVE, Suit.SPADE);
        player1.hitCard(card3);
        assertEquals(14,player1.valueHand());

    }

    @Test
    @DisplayName("Jack King Queen cards,value is 30")
    void valueHand_JackKingQueen_Test(){
        Player player1 = new Player("Fabio");
        Card card1 = new Card(Rank.JACK, Suit.HEART);
        Card card2 = new Card(Rank.KING, Suit.DIAMOND);

        player1.openingHand(card1, card2);
        assertEquals(20,player1.valueHand());

        Card card3 = new Card(Rank.QUEEN, Suit.SPADE);
        player1.hitCard(card3);
        assertEquals(30,player1.valueHand());

    }




}