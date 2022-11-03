package CS231.hsguwn25_Project05;

import CS231.hsguwn25_Project05.Cell.Type;

/**
File: CellTests.java
Author: Hesed Guwn
Date: 10/24/2022
Project05
Course: CS231 B
**/
public class CellTests {
    
    public static void main(String[] args){
        // case 1: Constructor
        {
            // setup
            Cell c1 = new Cell(1,1,Type.FREE);
            Cell c2 = new Cell(1, 2, Type.FREE);
            Cell c3 = new Cell(1,3, Type.OBSTACLE);

            // verify
            System.out.println(c1 + " == FREE");
            System.out.println(c2 + " == FREE");
            System.out.println(c3 + " == OBSTACLE");

            // test
            assert c1!=null : "Error in Cell::Cell()";
            assert c2!=null : "Error in Cell::Cell()";
            assert c3!=null : "Error in Cell::Cell()";
        }

        // case 2: getType
        {
            // setup
            Cell c1 = new Cell(1,1,Type.START);
            Cell c2 = new Cell(1, 2, Type.FREE);
            Cell c3 = new Cell(1,3, Type.OBSTACLE);

            // verify
            System.out.println(c1.getType() + " == START");
            System.out.println(c2.getType() + " == FREE");
            System.out.println(c3.getType() + " == OBSTACLE");

            // test
            assert c1.getType() == Type.START : "Error in Cell::getType()";
            assert c2.getType() == Type.FREE : "Error in Cell::getType()";
            assert c3.getType() == Type.OBSTACLE : "Error in Cell::getType()";
        }

        // case 3: getRow, getCol, visited
        {
            // setup
            Cell c1 = new Cell(1, 2, Type.FREE);
            Cell c2 = new Cell(5, 9, Type.FREE);

            // verify
            System.out.println(c1.getRow() + " == 1");
            System.out.println(c1.getCol() + " == 2");
            System.out.println(c1.visited() + " == false");
            System.out.println(c2.getRow() + " == 5");
            System.out.println(c2.getCol() + " == 9");
            System.out.println(c2.visited() + " == false");

            // test
            assert c1.getRow() == 1: "Error in Cell::getRow()";
            assert c1.getCol() == 2: "Error in Cell::getCol()";
            assert c1.visited() == false: "Error in Cell::visited()";
            assert c1.getRow() == 5: "Error in Cell::getRow()";
            assert c1.getCol() == 9: "Error in Cell::getCol()";
            assert c1.visited() == false: "Error in Cell::visited()";
        }

        // case 4: getPrev, visitedFrom, reset
        {
            // setup
            Cell c1 = new Cell(1, 2, Type.FREE);
            Cell c2 = new Cell(1, 3, Type.FREE);

            // verify
            c1.visitFrom(c2);
            System.out.println(c1.visited() + " == true");
            System.out.println(c1.getPrev() + " == FREE");
            c2.reset();
            System.out.println(c2.visited + " == false");
            System.out.println(c2.getPrev() + " == null");

            // test
            assert c1.visited() == true: "Error in Cell::visitFrom()";
            assert c1.getPrev() != null: "Error in Cell::getPrev()";
            assert c2.visited() == false: "Error in Cell::reset()";
            assert c2.getPrev() != null: "Error in Cell::reset()";
            

        }
        System.out.println("Done Testing!");
    }

}