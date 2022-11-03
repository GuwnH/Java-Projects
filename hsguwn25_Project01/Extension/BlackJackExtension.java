/**
File: BlackJackExtension.java
Author: Hesed Guwn
Date: 09/17/2022
Project01
Course: CS231 B
Extension context at line 17 and actual extension at line 67 

**/
public class BlackJackExtension {

    //initializes deck, player and dealer hands, and the number of cards left in the deck to signal reshuffling
    private Hand playerHand;
    private Hand dealerHand;
    private Deck deck;
    private int reshuffleCutoff;
    
    //Allows the aim for when the player should stop hitting to be up to the user
    private int playerCardLimit;

    //Constructs the BlackJack game taking into account the reshuffling cutoff
    public BlackJackExtension(int reshuffleCutoff, int playerCardLimit)
    {
        this.reshuffleCutoff = reshuffleCutoff;
        this.playerHand = new Hand();
        this.dealerHand = new Hand();
        this.deck = new Deck();
        this.playerCardLimit = playerCardLimit;
    }
    
    //Constructs the BlackJack game with default settings
    public BlackJackExtension()
    {
        this.reshuffleCutoff = 30;
        this.playerHand = new Hand();
        this.dealerHand = new Hand();
        this.deck = new Deck();
        this.playerCardLimit = 16;
    }

     //Resets the game by emptying the hands of the player and dealer and reshuffling the deck if the number of cards are too low
    public void reset()
    {
        //resets the player and dealer hands
        this.playerHand.reset();
        this.dealerHand.reset();
        
        //Checks if cutoff is met and reshuffles
        if(this.deck.size() <= this.reshuffleCutoff)
        {
            this.deck.build();
            this.deck.shuffle();
        }
    }

    //Gives out the 2 initial cards in hand for the player and dealer
    public void deal()
    {
        for(int i = 0; i < 2; i++)
        {
            Card card = this.deck.deal();
            playerHand.add(card);
            Card cardDealer = this.deck.deal();
            dealerHand.add(cardDealer); 
        }
        
    }
    //Extension starts here
    //Emulates the players turn and returns a boolean that signifies if the player has busted or has gotten an ideal number
    public boolean playerTurn()
    {
        //Checks the player hand value and runs while the cards are less than the ideal amount (playerCardLimit)
        while(this.playerHand.getTotalValue() < this.playerCardLimit)
        {
            Card card = this.deck.deal();
            playerHand.add(card);    
        }
        //Checks if player value is above 21 and returns false to signify bust
        if(this.playerHand.getTotalValue() > 21)
        {
            return false;
        }
        //Returns true otherwise
        else
        {
            return true;
        }
    }

    //Emulates the dealer's turn and returns a boolean that signifies if the dealer has busted or has gotten an ideal number
    public boolean dealerTurn()
    {
        //Checks the dealer hand value and runs while the cards are less than the ideal amount (17)
        while(this.dealerHand.getTotalValue() < 17)
        {
            Card card = this.deck.deal();
            dealerHand.add(card); 
        }
        //Checks if dealer value is above 21 and returns false to signify bust
        if(this.dealerHand.getTotalValue() > 21)
        {
            return false;
        }
        //Returns true otherwise
        else
        {
            return true;
        }
    }

    //Sets the cut off for when to reshuffle the deck
    public void setReshuffleCutoff(int cutoff)
    {
        this.reshuffleCutoff = cutoff;
    }

    //Gets the cut off value for when to reshuffle the deck
    public int getReshuffleCutoff()
    {
        return this.reshuffleCutoff;
    }

    //Returns a string representation of the game state (player and dealer card values and their hands)
    public String toString()
    {
        return "Player Hand: " + this.playerHand + "Player Value: " + this.playerHand.getTotalValue() + 
        " Dealer Hand: " + this.dealerHand + "Dealer Value: " + this.dealerHand.getTotalValue(); 
    }

    /*Returns an integer value between -1 to 1 to signify who wins after emulating a game. Takes in boolean parameter to allow seeing initial and final hands
    of player and dealer*/
    public int game(boolean verbose)
    {
        //Clears everything and sets up playey and dealer hands and runs their turns
        this.reset();
        this.deal();
        boolean playerResult = this.playerTurn();
        // System.out.println(this.playerTurn() + ": player result");
        boolean dealerResult = this.dealerTurn();
        // System.out.println(this.dealerTurn() + ": dealer result");

        //If verbose is set to true initial and final hands are seen
        if(verbose == true)
        {
            System.out.println("Initial Hands: " + this.toString());   
        }

        //Checks if player busts and dealer doesnt    
        if(playerResult == false)
        {
            if(verbose == true)
            {
                System.out.println("Final Hands: " + this.toString());   
            }
            //dealer win
            return -1;
        }
        
        //Checks if dealer busts and player doesnt
        if(dealerResult == false)
        {
            if(verbose == true)
            {
                System.out.println("Final Hands: " + this.toString());   
            }
            //player win
            return 1;
        }

        // //Checks if player and dealer both bust
        // if(this.playerTurn() == false && this.dealerTurn() == false)
        // {
        //     if(verbose == true)
        //     {
        //         System.out.println("Final Hands: " + this.toString());   
        //     }
        //     //push
        //     return 0;   
        // }

        //Checks if neither bust
        if(playerResult == true && dealerResult == true)
        {
            if(verbose == true)
            {
                System.out.println("Final Hands: " + this.toString());   
            }
            //Checks if player hand is higher
            if(this.playerHand.getTotalValue() > this.dealerHand.getTotalValue())
            {
                //player wins
                return 1;
            }
            //Checks if dealer hand is higher
            if(this.playerHand.getTotalValue() < this.dealerHand.getTotalValue())
            {
                //dealer wins
                return -1;
            }    
        }
        //push otherwise
        return 0;
    }

    public static void main(String[] args)
    {
        BlackJackExtension aGame = new BlackJackExtension(52, 12);
        
        // BlackJack aGame1 = new BlackJack(52);
        // int winner1 = aGame1.game(true);
        for(int i = 0; i <3; i++)
        {
            int winner = aGame.game(true);
            // System.out.println(aGame.deck.toString());
            // System.out.println(aGame1.deck.toString());
            if(winner == 1)
            {
                System.out.println("Player Win");
            }
            if(winner == -1)
            {
                System.out.println("Dealer Win");
            }
            if(winner == 0)
            {
                System.out.println("Push!");
            }
        }    
    }
}
