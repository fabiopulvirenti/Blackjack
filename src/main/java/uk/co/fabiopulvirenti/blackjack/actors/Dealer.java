package uk.co.fabiopulvirenti.blackjack.actors;

import uk.co.fabiopulvirenti.blackjack.model.Card;
import uk.co.fabiopulvirenti.blackjack.model.Deck;
import uk.co.fabiopulvirenti.blackjack.model.PlayerChoice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class deals the cards to players created elsewhere and evaluate the choice 'hit' and 'stand' of each player
 */
public class Dealer {

    private Deck deck;
    private Map<Player, Integer> playersScore = new HashMap<>();

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    /**
     * It deals the opening Hand to the list of players given as input
     *
     * @param playerList List of Players for which the hand is dealt
     */
    public void dealOpenHand(List<Player> playerList) {

        if (playerList == null) {
            throw new IllegalArgumentException("Player List cannot be null.");
        }
        this.playersScore.clear();// it empties the map when a new hand starts

        for (Player player : playerList) {
            Card card1 = deck.getCard();
            Card card2 = deck.getCard();
            player.openingHand(card1, card2);
        }

    }


    /**
     * It checks the choice of the Player and either gives a card to the player if it has chosen 'Hit' or evaluates its
     * score it has chosen 'Stand'
     *
     * @param player       Player that makes the choice
     * @param playerChoice the choice to evaluate
     */
    public void valueChoiceOfPlayer(Player player, PlayerChoice playerChoice) {

        if (playerChoice == PlayerChoice.HIT) {
            Card card = deck.getCard();
            player.hitCard(card);
        } else if (playerChoice == PlayerChoice.STAND) {
            evaluatePlayer(player);
        }

    }

    /**
     * It evaluates the choice of score of the player and add it to the players' scores map.
     *
     * @param player Player for which evaluation happens
     * @return the score of the current player
     */
    public int evaluatePlayer(Player player) {
        int score = player.getScore();
        playersScore.put(player, score);

        return score;
    }


    /**
     * It checks if the player has been already evaluated
     *
     * @param player Player for which checking
     * @return true if the player has been evaluated, false otherwise
     */
    public boolean isPlayerEvaluated(Player player) {
        return playersScore.containsKey(player);
    }


}
