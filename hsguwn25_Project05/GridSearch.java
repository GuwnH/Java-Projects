/**
File: GridSearch.java
Author: Hesed Guwn
Date: 10/18/2022
Project05
Course: CS231 B
**/
package CS231.hsguwn25_Project05;

import java.util.ArrayList;

public class GridSearch 
{
    //Field landscape and landscapeDiplsay to set up the simulation
    private Landscape landscape;
    private LandscapeDisplay landscapeDisplay;    

    //Intializes fields
    public GridSearch()
    {
        this.landscape = new Landscape(30, 30, .2);
        this.landscapeDisplay = new LandscapeDisplay(this.landscape, 20);
    }

    //Intializes fields to given arguments
    public GridSearch(int row, int col, double chance, int scale)
    {
        this.landscape = new Landscape(row, col, chance);
        this.landscapeDisplay = new LandscapeDisplay(this.landscape, scale);
    }

    //Depth first search algorithim that returns boolean whether maze has solution or not
    public boolean depthFirstSearch(int delay) throws InterruptedException 
    {
        
        //Using last week's CellStack, create an empty Stack of Cells.
        CellStack stack = new CellStack();
        //Mark the start as visited
        this.landscape.getStart().visited = true;  
        //Push the start onto the stack
        stack.push(this.landscape.getStart());
        //while the stack isn't empty 
        while(stack.size() != 0)
        {
            if(delay > 0)
            {
                Thread.sleep(delay);
                this.landscapeDisplay.repaint();
            }
         
            //pop a cell off the stack, let's call it cur
            Cell cur = stack.pop();
            //for each neighbor n of cur
            for (Cell neighbor : this.landscape.getNeighbors(cur)) 
            {
                //if n isn't an obstacle and hasn't been visited
                if(neighbor.getType() != Cell.Type.OBSTACLE && neighbor.visited() != true)
                {
                    //set n as visited from cur
                    neighbor.visitFrom(cur);
                    //if n is the target, return true
                    if(neighbor.getType() == Cell.Type.TARGET)
                    {
                        return true;
                    }
                    //push n onto the stack  
                    stack.push(neighbor);
                } 
            }
        }
          
        //return false
        return false;
         
    }

    //Beadth first search algorithim that returns boolean whether maze has solution or not
    public boolean breadthFirstSearch(int delay) throws InterruptedException {
        
        //Using this week's CellQueue, create an empty Queue of Cells.
        CellQueue queue = new CellQueue();
        //Mark the start as visited
        this.landscape.getStart().visited = true;
        //Offer the start into the queue
        queue.offer(this.landscape.getStart());
         
        //while the queue isn't empty 
        while(queue.size() != 0)
        {
            //if (delay > 0)
            if(delay > 0)
            {
                Thread.sleep(delay);
                this.landscapeDisplay.repaint();
            }
         
            //poll a cell off the queue, let's call it cur
            Cell cur = queue.poll();
            
            //for each neighbor n of cur
            for (Cell neighbor : this.landscape.getNeighbors(cur)) 
            {
                //if n isn't an obstacle and hasn't been visited
                if(neighbor.getType() != Cell.Type.OBSTACLE && neighbor.visited() != true)
                {
                    //set n as visited from cur
                    neighbor.visitFrom(cur);
                    //if n is the target, return true
                    if(neighbor.getType() == Cell.Type.TARGET)
                    {
                        return true;
                    }
                    //push n onto the stack  
                    queue.offer(neighbor);
                }
            }
        }
        // return false
        return false;
    }

    public static void main(String[] args) throws InterruptedException 
    {
        double solveCount = 0.0;
        for(int i=0; i<10; i++)
        {
            GridSearch search = new GridSearch(30, 30, .20, 20);
            // search.depthFirstSearch(100);
            boolean solved = search.breadthFirstSearch(0);
            if(solved)
            {
                solveCount += 1.0;
            }
        }
        solveCount = solveCount / 50.0;
        System.out.println(solveCount);
          
    }
}
