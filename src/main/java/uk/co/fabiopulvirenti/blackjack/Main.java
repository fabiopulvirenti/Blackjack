package uk.co.fabiopulvirenti.blackjack;

import uk.co.fabiopulvirenti.blackjack.actors.Dealer;
import uk.co.fabiopulvirenti.blackjack.actors.Player;
import uk.co.fabiopulvirenti.blackjack.model.Deck;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        startGame();
    }


    public static void startGame(){
        Player player1 = new Player("Fabio");
        Player player2 = new Player("Davide");
        Player player3 = new Player("Thomas");
        Player player4 = new Player("Dante");
        List<Player> listOfPlayers = List.of(player1, player2, player3, player4);

        Dealer dealer = new Dealer();
        Deck deck = new Deck();


        dealer.setDeck(deck);
        dealer.dealOpenHand(listOfPlayers);


        for (Player player : listOfPlayers) {
            String cards = player.displayCards();
            System.out.println(player.getName() + ": " + cards);
        }
    }


}
