package CS231.hsguwn25_Project05;
/**
File: GridSearchTest.java
Author: Hesed Guwn
Date: 10/18/2022
Project05
Course: CS231 B
**/
public class GridSearchTest 
{
    public static void main(String[] args) throws InterruptedException{
        
        // case 1: GridSearch constructor 1
        {
            // setup
            GridSearch search = new GridSearch();

            // verify
            System.out.println(search);

            // test
            assert search != null : "Error in GridSearch::GridSearch()";
        }

        // case 2: Gridsearch constructor 2
        {
            // setup
            GridSearch search = new GridSearch(30,30,.2,20);

            // verify
            System.out.println(search);
            
            // test
            assert search != null : "Error in GridSearch::GridSearch(int row, int col, double chance, int scale)";
        }

        // case 3: DFS
        {
             // setup
             GridSearch search = new GridSearch(30,30,.2,20);

             // verify
             boolean test = search.depthFirstSearch(0);
             System.out.println(test + " == true");
             
             // test
             assert test == true : "Error in GridSearch::depthFirstSearch(int delay)";
        }

        // case 4: BFS
        {
            // setup
            GridSearch search = new GridSearch(30,30,.2,20);

            // verify
            boolean test = search.breadthFirstSearch(0);
            System.out.println(test + " == true");
            
            // test
            assert test == true : "Error in GridSearch::depthFirstSearch(int delay)";
       }
    }    
}
