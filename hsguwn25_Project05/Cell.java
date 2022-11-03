/**
File: Cell.java
Author: Hesed Guwn
Date: 10/18/2022
Project05
Course: CS231 B
**/
package CS231.hsguwn25_Project05;

import java.awt.Graphics;
import java.awt.Color;

public class Cell 
{
    //Gives cells type
    public enum Type {
        FREE, OBSTACLE, START, TARGET
    }
    
    boolean visited; //for determining whether we've visited this Cell yet
    Cell prev; //for determining which Cell we came from to visit this Cell
    int row, col; //for determining which row and column this Cell belongs to in the Landscape
    Type type; //for determining which type of Cell this is

    //Constructor that sets up the row, col, and type as specified; remaining fields should be null
    public Cell (int row, int col, Type type)
    {
        this.row = row;
        this.col = col;
        this.type = type;
        this.prev = null;
        this.visited = false;
    }

    //returns the row
    public int getRow() 
    {
        return this.row;
    }
    
    //returns the column
    public int getCol()
    {
        return this.col;
    }

    //returns the type
    public Type getType() 
    {
        return this.type;
    }
    
    //returns visited
    public boolean visited() 
    {
        return this.visited;
    }
    
    //returns previous cell
    public Cell getPrev() 
    {
        return this.prev;
    }
    
    //sets visited to true and prev to c
    public void visitFrom(Cell c) 
    {
        this.visited = true;
        this.prev = c;
    }

    //sets visited to false and prev to null
    public void reset() 
    {
        this.visited = false;
        this.prev = null;
        this.type = null;
    }

    //Returns string representation of cell
    public String toString()
    {
        return "" + this.type;
    }

    //Draws graphic representation of cell
    public void draw(Graphics g, int scale, Landscape scape) {
        g.setColor(Color.BLACK);
        g.drawRect(getCol() * scale, getRow() * scale, scale, scale);
        switch (getType()) {
            case FREE:
                g.setColor(visited() ? Color.YELLOW : Color.GRAY);
                break;
            case OBSTACLE:
                g.setColor(Color.BLACK);
                break;
            case START:
                g.setColor(Color.BLUE);
                break;
            case TARGET:
                g.setColor(Color.RED);
                break;
        }
        g.fillRect(getCol() * scale + 2, getRow() * scale + 2, scale - 4, scale - 3);
    
        g.setColor(Color.RED);
        if (getPrev() != null && getPrev() != this) {
            int midX = ((getCol() + getPrev().getCol()) * scale + scale) / 2;
            int midY = ((getRow() + getPrev().getRow()) * scale + scale) / 2;
            g.drawLine(getCol() * scale + scale / 2, getRow() * scale + scale / 2,
                    midX, midY);
        }
        for (Cell neighbor : scape.getNeighbors(this)) {
            if (neighbor.getPrev() == this) {
                int midX = ((getCol() + neighbor.getCol()) * scale + scale) / 2;
                int midY = ((getRow() + neighbor.getRow()) * scale + scale) / 2;
                g.drawLine(getCol() * scale + scale / 2, getRow() * scale + scale / 2,
                        midX, midY);
            }
        }
    } 
}
