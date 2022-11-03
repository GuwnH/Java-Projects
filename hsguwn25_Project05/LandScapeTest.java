package CS231.hsguwn25_Project05;
/**
File: LandScapeTest.java
Author: Hesed Guwn
Date: 10/18/2022
Project05
Course: CS231 B
**/
import java.util.ArrayList;

public class LandScapeTest 
{
    public static void main(String[] args) 
    {
        // case 1: Constructor/toString
        {
            // setup
            Landscape landscape = new Landscape(20,20,0.2);

            // verify
            System.out.println(landscape);

            // test
            assert landscape != null : "Error in Landscape::Landscape()";
        }

        // case 2: getStart, getTarget
        {
             // setup
             Landscape landscape = new Landscape(20,20,0.2);

             // verify
             System.out.println(landscape.getStart());
             System.out.println(landscape.getTarget());
 
             // test
             assert landscape.getStart() != null: "Error in Landscape::getStart()";
             assert landscape.getTarget() != null : "Error in Landscape::getTarget()";
        }

        // case 3: getRows and getCols
        {
            // setup
            Landscape board = new Landscape(20,20,0.2);

            // verify
            System.out.println(board);
            System.out.println(board.getRows() + " == 20");
            System.out.println(board.getCols() + " == 20");

            // test
            assert board.getRows() == 20 : "Error in Landscape::getRows()";
            assert board.getCols() == 20 : "Error in Landscape::getCols()";
        }

        // case 4: getCell and reset
        {
            // setup
            Landscape board = new Landscape(20,20,0.2);
            Landscape board2 = new Landscape(20,20,0.2);

            // verify
            System.out.println(board);
            board.getCell(5,5);
            System.out.println(board.getCell(5,5).getType() + " != null");
            board2.reset();
            System.out.println(board2.getCell(0,0).getType() + " == null");

            // test
            assert board.getCell(5,5).getType() != null : "Error in Landscape::getCell(int r, int c)";
            assert board2.getCell(5,5).getType() == null : "Error in Landscape::reset()";
        }

        // case 5: getNeighbors 
        {
            // setup
            Landscape board = new Landscape(20,20,0.2);

            // verify
            System.out.println(board);
            ArrayList<Cell> neighbors = board.getNeighbors(board.getCell(5, 5));
            System.out.println(neighbors + " != null");
            
            // test
            assert neighbors != null : "Error in Landscape::getNeighbors(Cell c)";
        }
        
    }        
}
