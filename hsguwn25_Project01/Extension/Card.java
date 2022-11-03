/**
File: Card.java
Author: Hesed Guwn
Date: 09/17/2022
Project01
Course: CS231 B
**/
public class Card {

    /**
     * The value of the card.
     */
    private int value;

    /**
     * Constructs a card with the specified value.
     * @param val
     */
    public Card(int val) 
    {
        //Checks if the val paremeter is within the legal range of cards (2-11) 
        if(2 <= val || val <= 11)
        {
            this.value = val;
        }
        else
        {
            //If value is not within range then card is set to its default value
            System.out.println("Not within card range");
            this.value = 2;
        }
        
    }

    /**
     * Returns the value of the card.
    */
    public int getValue() {
        return this.value;
    }
    
    /**
     * Returns a string representation of this card.
     */
    public String toString() {
        return "" + this.value; 
    }
}