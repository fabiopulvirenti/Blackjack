package uk.co.fabiopulvirenti.blackjack.actors;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uk.co.fabiopulvirenti.blackjack.model.Deck;

import java.util.ArrayList;
import java.util.List;

public class DealerTest {


    private Dealer dealer;
    private Deck deck;

    @BeforeEach
    void setUpEachTest() {
        this.deck  = new Deck();
        this.dealer = new Dealer();
        this.dealer.setDeck(deck);
    }

    @Test
    @DisplayName("")
    void dealOpenHandTest() {

        Player player1=new Player("Fabio");
        Player player2=new Player("Davide");
        Player player3=new Player("Thomas");
        List<Player>listOfPlayers = List.of(player1,player2,player3);

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



}



























