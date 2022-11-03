/**
File: BoardTest.java
Author: Hesed Guwn
Date: 10/04/2022
Project04
Course: CS231 B
**/

/**setFinished is my own made up method to allow me to access the private boolean finished method from board when I use the Sudoku solve method, there is no need to test it as if it
    didn't work, then none of my Sudoku tests would run. Same with draw method, except I didn't make that.
**/


public class BoardTest 
{
    public static void main(String[] args) 
    {
        // case 1: Constructor/toString
        {
            // setup
            Board board = new Board();

            // verify
            System.out.println(board);

            // test
            assert board != null : "Error in Board::Board()";
        }

        // case 2: Constructor with int parameter
        {
            // setup
            Board board = new Board(10);

            // verify
            System.out.println(board);

            // test
            assert board != null : "Error in Board::Board(int numLock)";
        }

        // case 3: numLocked method
        {
            // setup
            Board board = new Board(10);

            // verify
            System.out.println(board);
            System.out.println(board.numLocked() + " == 10");

            // test
            assert board.numLocked() == 10 : "Error in Board::numLocked()";
        }

        // case 4: getRows and getCols
        {
            // setup
            Board board = new Board(10);

            // verify
            System.out.println(board);
            System.out.println(board.getRows() + " == 9");
            System.out.println(board.getCols() + " == 9");

            // test
            assert board.getRows() == 9 : "Error in Board::getRows()";
            assert board.getCols() == 9 : "Error in Board::getCols()";
        }

        // case 5: get and set
        {
            // setup
            Board board = new Board();

            // verify
            System.out.println(board);
            board.set(5, 5, 9);
            System.out.println(board.get(5,5).getValue() + " == 9");

            // test
            assert board.get(5,5).getValue() == 9 : "Error in Board::get(int r, int c)";
        }

         // case 6: get and set and isLocked
         {
            // setup
            Board board = new Board();

            // verify
            System.out.println(board);
            board.set(5, 5, 9,true);
            System.out.println(board.get(5,5).getValue() + " == 9");
            System.out.println(board.isLocked(5, 5) + " == true");

            // test
            assert board.get(5,5).getValue() == 9 : "Error in Board::get(int r, int c)";
            assert board.isLocked(5, 5) == true : "Error in Board::isLocked()";
        }

        // case 7: value 
        {
            // setup
            Board board = new Board();

            // verify
            System.out.println(board);
            board.set(5, 5, 9);
            System.out.println(board.value(5, 5) + " == 9");
            
            // test
            assert board.value(5,5) == 9 : "Error in Board::value(int r, int c)";
        }

        // case 8: read and validSolution and validValue
        {
            // setup
            Board board = new Board();

            // verify
            System.out.println(board);
            board.read("BoardSolved.txt");
            System.out.println(board.validSolution() + " == true");
            System.out.println(board.validValue(5,5,board.value(5, 5)) + " == true");
            
            // test
            assert board.validSolution() == true : "Error in Board::validSolution()";
            assert board.validValue(5,5,board.value(5,5)) == true : "Error in Board::validValue(int r, int c)";
        }

        // case 9: findNextCell
        {
            // setup
            Board board = new Board(10);

            // verify
            System.out.println(board);
            System.out.println(board.findNextCell() + " != null");
            
            // test
            assert board.findNextCell() != null : "Error in Board::getRows()";
        }

        System.out.println("Done testing");
        
    }    
}
