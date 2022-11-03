/**
File: Simulation.java
Author: Hesed Guwn
Date: 09/17/2022
Project01
Course: CS231 B
Extension Explanation Starts Line 22
**/
public class SimulationExtension {
    
    //Runs 1000 games and calculates and displays how many times player wins, dealer wins, and pushes and their percentages as a whole
    public static void main(String[] args)
    {
        //Initial wins, pushes, and percentages
        float playerWins = 0;
        float dealerWins = 0;
        float pushes = 0;
        float playerWinPercent;
        float dealerWinPercent;
        float pushPercent;

        //Creates a similar BlackJack game, but now the player's behavior for when they want to stop being dealt cards is configurable
        BlackJackExtension game = new BlackJackExtension(25,17);
        int games = game.game(false);

        //Loop that runs 1000 a game 1000 times and calculates the wins and pushes
        for(int i=0; i < 1000; i++)
        {
            games = game.game(false);
            if(games == 1)
            {
                playerWins += 1;
            }
            if(games == -1)
            {
                dealerWins += 1;
            }
            if(games == 0)
            {
                pushes += 1;
            }
        }

        //Calculates the win and push percentages
        playerWinPercent = (playerWins / 1000) * 100;
        dealerWinPercent = (dealerWins / 1000) * 100;
        pushPercent = (pushes / 1000) * 100;

        //Displays information
        System.out.println("Over 1000 games, Player Wins " + playerWinPercent + "% of the time with " + playerWins + " wins");
        System.out.println("Over 1000 games, Dealer Wins " + dealerWinPercent + "% of the time with " + dealerWins + " wins");
        System.out.println("Over 1000 games, Neiter Wins " + pushPercent + "% of the time with " + pushes + " pushes");
    }
}
