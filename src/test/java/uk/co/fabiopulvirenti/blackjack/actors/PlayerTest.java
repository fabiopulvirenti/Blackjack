package uk.co.fabiopulvirenti.blackjack.actors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uk.co.fabiopulvirenti.blackjack.model.Card;
import uk.co.fabiopulvirenti.blackjack.model.Rank;
import uk.co.fabiopulvirenti.blackjack.model.Suit;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    @DisplayName("Queen six five cards,value is 21")
    void valueHand_QueenSixFive_Test(){
        Player player1 = new Player("Fabio");
        Card card1 = new Card(Rank.QUEEN, Suit.HEART);
        Card card2 = new Card(Rank.SIX, Suit.DIAMOND);

        player1.openingHand(card1, card2);
        assertEquals(16,player1.valueHand());

        Card card3 = new Card(Rank.FIVE, Suit.SPADE);
        player1.hitCard(card3);
        assertEquals(21,player1.valueHand());

    }

    @Test
    @DisplayName("Three six five cards,value is 14")
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

    @Test
    @DisplayName("Ace five five cards,value is 21")
    void valueHand_AceFiveFive_Test(){
        Player player1 = new Player("Fabio");
        Card card1 = new Card(Rank.ACE, Suit.HEART);
        Card card2 = new Card(Rank.FIVE, Suit.DIAMOND);

        player1.openingHand(card1, card2);
        assertEquals(16,player1.valueHand());

        Card card3 = new Card(Rank.FIVE, Suit.SPADE);
        player1.hitCard(card3);
        assertEquals(21,player1.valueHand());

    }

    @Test
    @DisplayName("Ten six Ace cards,value is 17")
    void valueHand_TenSixAceFive_Test(){
        Player player1 = new Player("Fabio");
        Card card1 = new Card(Rank.TEN, Suit.HEART);
        Card card2 = new Card(Rank.SIX, Suit.DIAMOND);

        player1.openingHand(card1, card2);
        assertEquals(16,player1.valueHand());

        Card card3 = new Card(Rank.ACE, Suit.SPADE);
        player1.hitCard(card3);
        assertEquals(17,player1.valueHand());

    }

    @Test
    @DisplayName("Jack two Ace cards,value is 13")
    void valueHand_JackTwoTwo_Test(){
        Player player1 = new Player("Fabio");
        Card card1 = new Card(Rank.JACK, Suit.HEART);
        Card card2 = new Card(Rank.TWO, Suit.DIAMOND);

        player1.openingHand(card1, card2);
        assertEquals(12,player1.valueHand());

        Card card3 = new Card(Rank.ACE, Suit.SPADE);
        player1.hitCard(card3);
        assertEquals(13,player1.valueHand());

    }

    @Test
    @DisplayName("Ace Ace two cards,value is 14")
    void valueHand_AceAceTwo_Test(){
        Player player1 = new Player("Fabio");
        Card card1 = new Card(Rank.ACE, Suit.HEART);
        Card card2 = new Card(Rank.ACE, Suit.DIAMOND);

        player1.openingHand(card1, card2);
        assertEquals(12,player1.valueHand());

        Card card3 = new Card(Rank.TWO, Suit.SPADE);
        player1.hitCard(card3);
        assertEquals(14,player1.valueHand());

    }

    @Test
    @DisplayName("Ace Ace Ace cards,value is 13")
    void valueHand_AceAceAce_Test(){
        Player player1 = new Player("Fabio");
        Card card1 = new Card(Rank.ACE, Suit.HEART);
        Card card2 = new Card(Rank.ACE, Suit.DIAMOND);

        player1.openingHand(card1, card2);
        assertEquals(12,player1.valueHand());

        Card card3 = new Card(Rank.ACE, Suit.SPADE);
        player1.hitCard(card3);
        assertEquals(13,player1.valueHand());

    }













}