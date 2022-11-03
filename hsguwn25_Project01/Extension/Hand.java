/**
File: Hand.java
Author: Hesed Guwn
Date: 09/17/2022
Project01
Course: CS231 B
**/
import java.util.ArrayList;

public class Hand {

    //Creates a list of cards as a hand
    private ArrayList<Card> hand;
    /**
     * Creates an empty hand as an ArrayList of Cards.  
     */
    public Hand()
    {
        this.hand = new ArrayList<Card>(); 
    }

    /**
     * Removes any cards currently in the hand. 
     */
    public void reset()
    {
        this.hand.clear();;
    }

    /**
     * Adds the specified card to the hand.
     * @param card the card to be added to the hand
     */
    public void add(Card card)
    {
        this.hand.add(card);
    }

    /**
     * Returns the number of cards in the hand.
     * @return the number of cards in the hand
     */
    public int size()
    {
        return this.hand.size();
    }

    /**
     * Returns the card in the hand specified by the given index. 
     * @param index the index of the card in the hand.
     * @return the card in the hand at the specified index.
     */
    public Card getCard(int index)
    {
        return this.hand.get(index);
    }

    /**
     * Returns the summed value over all cards in the hand.
     * @return the summed value over all cards in the hand
     */
    public int getTotalValue()
    {
        //sum of the value
        int val = 0;

        //iterates through each card in the hand and adds the value
        for(int i=0; i < this.hand.size(); i++)
        {
            Card currCard = this.hand.get(i);
            int cardVal = currCard.getValue();
            val += cardVal;
        }
        return val;
    }

    /**
     * Returns a string representation of the hand.
     * @return a string representation of the hand
     */
    public String toString()
    {
        return "" + this.hand;
    }
}