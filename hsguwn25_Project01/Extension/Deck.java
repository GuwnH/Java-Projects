/**
File: Deck.java
Author: Hesed Guwn
Date: 09/17/2022
Project01
Course: CS231 B
**/
import java.util.ArrayList;
import java.util.Random;

public class Deck {

    //Intializes the array list of cards as deck and generates the randomizer
    private ArrayList<Card> deck;
    private Random ran = new Random();
    
    /**
     * Creates the underlying deck as an ArrayList of Card objects. 
     * Calls build() as a subroutine to build the deck itself.
     */
    public Deck() 
    {
        this.deck = new ArrayList<Card>();
        build();
        // this.shuffle();
    }

    /**
     * Builds the underlying deck as a standard 52 card deck. 
     * Replaces any current deck stored. 
     */
    public void build() 
    {
        //Clears the deck to rebuild
        this.deck.clear();

        //Loops 4 times to create 4 copies of every card 2-11 
        for(int i=0; i < 4; i++)
        {
           for(int num = 2; num < 12; num ++)
           {
                this.deck.add(new Card(num));
           }   
        }
        //Creates the remaining 12 needed 10 value cards
        for (int i=0; i < 12; i++ )
        {
            this.deck.add(new Card(10));
        }
    }

    /**
     * Returns the number of cards left in the deck. 
     * @return the number of cards left in the deck
     */
    public int size() 
    {
        return this.deck.size();
    }

    /**
     * Returns and removes the first card of the deck.
     * @return the first card of the deck
     */
    public Card deal() 
    {
        Card first = this.deck.get(0);
        this.deck.remove(0);
        return first;
    }

    /**
     * Shuffles the cards currently in the deck. 
     */
    public void shuffle() 
    {
        //Iterates from the end of the deck to the top
        for(int i = 51; i > 0; i--)
        {
            //Chooses between the current card at i or the card next to i
            int j = ran.nextInt(i + 1);
            //Gets that card and sets the card to be at the position
            Card temp = deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j, temp);
        }
    }

    /**
     * Returns a string representation of the deck.
     * @return a string representation of the deck
     */
    public String toString() 
    {
        return "" + this.deck;
    }

    //Main function, tests if the deck shuffles right and builds right
    public static void main(String[] args)
    {
        Deck deck1 = new Deck();
        System.out.println(deck1);
        // deck1.shuffle();
        System.out.println(deck1);
        // Deck deck2 = new Deck();
        // System.out.println(deck2);
        // deck2.shuffle();
        // System.out.println(deck2);
    }
}