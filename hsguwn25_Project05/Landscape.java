/**
File: Landscape.java
Author: Hesed Guwn
Date: 10/18/2022
Project05
Course: CS231 B
**/
package CS231.hsguwn25_Project05;

import java.util.Random;

import CS231.hsguwn25_Project05.Cell.Type;

import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

public class Landscape 
{

    int rows, cols; //size of the board
    double chance; //chance of obstacle
    Cell[][] cellGrid; //grid of cells
    Cell start, target; //designated start and target cell

    //Constructs landscape of cells of int rows by int columns size with double chance of creating obstacles
    public Landscape(int rows, int cols, double chance)
    {
        this.rows = rows;
        this.cols = cols;
        this.chance = chance;
        this.cellGrid = new Cell[rows][cols];

        Random obstacleChance = new Random();
        Random randRow = new Random();
        Random randCol = new Random();

        //Fills each cell with either obstacle or free cell
        for(int r=0; r < this.rows; r++)
        {
            for(int c=0; c < this.cols; c++)
            {
                if(obstacleChance.nextDouble(0,1) < this.chance)
                {
                    this.cellGrid[r][c] = new Cell(r,c,Type.OBSTACLE);
                }
                else
                {
                    this.cellGrid[r][c] = new Cell(r,c,Type.FREE);
                }
            }
        }
        
        //Randomly generates rows and columns for where the target and start are located 
        int startRow = randRow.nextInt(0,this.rows);
        int startCol = randCol.nextInt(0,this.cols);

        int targetRow = randRow.nextInt(0,this.rows);
        int targetCol = randCol.nextInt(0,this.cols);

        //Makes sure they do not overlap
        while(startRow == targetRow && startCol == targetCol)
        {
            startRow = randRow.nextInt(0,this.rows);
            startCol = randCol.nextInt(0, this.cols);
        }

        //Sets the location of start
        this.cellGrid[startRow][startCol] = new Cell(startRow,startCol,Type.START);
        this.start = this.cellGrid[startRow][startCol];

        //Sets location of target
        this.cellGrid[targetRow][targetCol] = new Cell(targetRow,targetCol,Type.TARGET);
        this.target = this.cellGrid[targetRow][targetCol];

        
    }   
    
    //returns the start Cell
    public Cell getStart()
    {
        return this.start;
    } 
    
    //returns the target Cell
    public Cell getTarget() 
    {
        return this.target;
    }
    
    //returns the number of rows
    public int getRows() 
    {
        return this.rows;
    }
    
    //returns the number of columns
    public int getCols() 
    {
        return this.cols;
    }

    //returns the Cell at the specified row and column.
    public Cell getCell(int row, int col) 
    {
        return this.cellGrid[row][col];
    }
    
    //resets all the Cells in the Landscape
    public void reset() 
    {
        for(int i=0; i<this.rows; i++)
        {
            for(int j=0; j<this.cols; j++)
            {
                cellGrid[i][j].reset();
            }
        }
    }

    //returns an ArrayList of Cells containing all the adjacent (diagonals not included) neighbors of the specified Cell in the grid. 
    public ArrayList<Cell> getNeighbors(Cell c) 
    {
        ArrayList<Cell> neighborList = new ArrayList<Cell>(4);

        if (c.getRow() - 1 >= 0 && this.cellGrid[c.getRow() - 1][c.getCol()].getType() != Cell.Type.OBSTACLE &&
            this.cellGrid[c.getRow() - 1][c.getCol()].visited() == false){
            neighborList.add(this.cellGrid[c.getRow() - 1][c.getCol()]);
        }

        if (c.getRow() + 1 < this.rows && this.cellGrid[c.getRow() + 1][c.getCol()].getType() != Cell.Type.OBSTACLE &&
        this.cellGrid[c.getRow() + 1][c.getCol()].visited() == false){
            neighborList.add(this.cellGrid[c.getRow() + 1][c.getCol()]);
        }

        if (c.getCol() - 1 >= 0 && this.cellGrid[c.getRow()][c.getCol() - 1].getType() != Cell.Type.OBSTACLE &&
        this.cellGrid[c.getRow()][c.getCol() - 1].visited() == false){
            neighborList.add(this.cellGrid[c.getRow()][c.getCol() - 1]);
        }

        if (c.getCol() + 1 < this.cols && this.cellGrid[c.getRow()][c.getCol() + 1].getType() != Cell.Type.OBSTACLE &&
        this.cellGrid[c.getRow()][c.getCol() + 1].visited() == false){
            neighborList.add(this.cellGrid[c.getRow()][c.getCol() + 1]);
        }

        return neighborList;
    }

    //Draws graphic representation of landscape
    public void draw(Graphics g, int scale) {
        for(int r = 0; r < getRows(); r++){
            for(int c = 0; c < getCols(); c++){
                getCell(r, c).draw(g, scale, this);
            }
        }
        g.setColor(Color.RED);
        CellQueue queue = new CellQueue();
        queue.offer(start);
        while (!(queue.size() == 0)) {
            Cell cur = queue.poll();
    
            for (Cell neighbor : getNeighbors(cur)) {
                if (neighbor.getPrev() == cur) {
                    queue.offer(neighbor);
                    g.drawLine(cur.getCol() * scale + scale / 2, cur.getRow() * scale + scale / 2,
                            neighbor.getCol() * scale + scale / 2, neighbor.getRow() * scale + scale / 2);
                }
            }
        }
    
        if (target.visited()) {
            Cell cur = target.getPrev();
            while (cur != start) {
                g.setColor(Color.GREEN);
                g.fillRect(cur.getCol() * scale + 2, cur.getRow() * scale + 2, scale - 4, scale - 3);
                cur = cur.getPrev();
            }
            cur = target;
            while (cur != start) {
                g.setColor(Color.BLUE);
                g.drawLine(cur.getCol() * scale + scale / 2, cur.getRow() * scale + scale / 2,
                        cur.getPrev().getCol() * scale + scale / 2, cur.getPrev().getRow() * scale + scale / 2);
                cur = cur.getPrev();
            }
        }
    }

}
