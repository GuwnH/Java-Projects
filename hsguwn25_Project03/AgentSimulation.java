/**
File: AgentSimulation.java
Author: Hesed Guwn
Date: 10/03/2022
Project03
Course: CS231 B
**/
import java.util.Random;

public class AgentSimulation 
{
    public static void main(String[] args) throws InterruptedException
    {
        //Creates landscape and random number generator
        Landscape scape = new Landscape(500, 500);
        Random gen = new Random();

        // Creates 100 SocialAgents and 100 AntiSocialAgents (200 Agents in total)
        for (int i = 0; i < 100; i++) 
        {
            scape.addAgent(new SocialAgent(gen.nextDouble() * scape.getWidth(),
                    gen.nextDouble() * scape.getHeight(),
                    15));
            scape.addAgent(new AntiSocialAgent(gen.nextDouble() * scape.getWidth(),
                    gen.nextDouble() * scape.getHeight(),
                    50));
        }

        LandscapeDisplay display = new LandscapeDisplay(scape);

        // Uncomment below when updateAgents() has been implemented
        for(int i=0; i<200; i++)
        {
            Thread.sleep(250);
            scape.updateAgents();
            display.repaint();
        }
    }   
}
