package uk.co.fabiopulvirenti.blackjack.actors;

import uk.co.fabiopulvirenti.blackjack.model.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a player in the game and holds the list of cards for each hand
 */
public class Player {

    private final String name;
    private final int score;
    private final List<Card> cardsList;


    /**
     * It creates an instance of Player with a given name.
     * It initialises the score to 0 and the cards list as empty
     *
     * @param name the name of the player which will be used when printed out
     */
    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.cardsList = new ArrayList<>();

    }


    /**
     * It adds the two initial cards of the hand.
     * It also updates the score with the new value.
     *
     * @param card1 an instance of Card
     * @param card2 an instance of Card
     */
    public void openingHand(Card card1, Card card2) {
        cardsList.add(card1);
        cardsList.add(card2);

    }

    public int getNumberOfCards() {
        return cardsList.size();
    }

    /**
     * It calculates the value of the hand
     * @return an integer of the current value of the hand
     */
    public int valueHand() {

        int sum = 0;
        for (Card card : cardsList) {
            int cardValue = 0;
            switch (card.getRank()) {
                case TWO:
                    cardValue = 2;
                    break;
                case THREE:
                    cardValue = 3;
                    break;
                case FOUR:
                    cardValue = 4;
                    break;
                case FIVE:
                    cardValue = 5;
                    break;
                case SIX:
                    cardValue = 6;
                    break;
                case SEVEN:
                    cardValue = 7;
                    break;
                case EIGHT:
                    cardValue = 8;
                    break;
                case NINE:
                    cardValue = 9;
                    break;
                case TEN:
                    cardValue = 10;
                    break;
                case JACK:
                case QUEEN:
                case KING:
                    cardValue = 10;
                    break;
            }
            sum = sum + cardValue;
        }


        return sum;
    }

    public void hitOrStand() {


    }

    /**
     * It adds a new card to the list of cards in the hand and updates the score
     *
     * @param card an instance of Card
     */
    public void hitCard(Card card) {
        cardsList.add(card);
    }

    /**
     * It returns the current score
     *
     * @return an integer with value of the current score
     */
    public int getScore() {
        return score;

    }


}
