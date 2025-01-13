package uk.co.fabiopulvirenti.blackjack.actors;

import uk.co.fabiopulvirenti.blackjack.model.Card;
import uk.co.fabiopulvirenti.blackjack.model.Deck;
import uk.co.fabiopulvirenti.blackjack.model.PlayerChoice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class Dealer {

    private Deck deck;
    private Map<Player,Integer> playersScore= new HashMap<>();

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    /**
     *
     * @param playerList
     */
    public void dealOpenHand(List<Player> playerList){
        this.playersScore.clear();// it empties the map when a new hand starts

        for(Player player : playerList){
            Card card1 = deck.getCard();
            Card card2 = deck.getCard();
            player.openingHand(card1, card2);
        }

    }


    /**
     *
     * @param player
     * @param playerChoice
     */
    public void valueChoiceOfPlayer(Player player, PlayerChoice playerChoice){

        if(playerChoice==PlayerChoice.HIT){
            Card card = deck.getCard();
            player.hitCard(card);
        } else if (playerChoice==PlayerChoice.STAND){
            evaluatePlayer(player);
        }

    }

    public int evaluatePlayer(Player player){
        int score = player.getScore();
        playersScore.put(player,score);

        return score;
    }



    /**
     *
     * @param player
     * @return
     */
    public boolean isPlayerEvaluated(Player player){
        return playersScore.containsKey(player);
    }







}
