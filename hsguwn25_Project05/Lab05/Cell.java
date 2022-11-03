/**
File: Cell.java
Author: Hesed Guwn
Date: 10/18/2022
Project05
Course: CS231 B
**/
package CS231.hsguwn25_Project05.Lab05;

public class Cell 
{
    //Gives cell a type
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
    }
}
