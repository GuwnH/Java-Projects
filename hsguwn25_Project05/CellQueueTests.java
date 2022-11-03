/**
File: CellQueueTests.java
Author: Hesed Guwn
Date: 10/18/2022
Project05
Course: CS231 B
**/
package CS231.hsguwn25_Project05;
import CS231.hsguwn25_Project05.Cell.Type;

public class CellQueueTests {

    public static void main(String[] args){
        // case 1: Constructor
        {
            // setup
            CellStack queue = new CellStack();

            // verify
            System.out.println(queue.toString());

            // test
            assert queue != null : "Error in CellQueue::CellQueue()";
        }

        // case 2: offer(), size()
        {
            // setup
            CellQueue queue = new CellQueue();
            for(int i = 0; i < 5; i++){
                queue.offer(new Cell(i,i,Type.FREE));
            }

            // verify
            System.out.println(queue.size() + " == 5");
            
            // test
            assert queue.size() == 5 : "Error in CellQueue::()";
        }

        // case 3: peek(), size()
        {
            // setup
            CellQueue queue = new CellQueue();
            for(int i = 0; i < 5; i++){
                queue.offer(new Cell(i,i,Type.FREE));
            }
            Cell peek = queue.peek();

            // verify
            System.out.println(peek.getType() + " == FREE");
            System.out.println(queue.size() + " == 5");

            // test
            assert peek.getType() == Type.FREE : "Error in CellQueue::peek()"; 
            assert queue.size() == 4 : "Error in CellQueue::peek()";
        }

        // case 4: poll()
        {
            // setup
            CellQueue queue = new CellQueue();
            for(int i = 0; i < 5; i++){
                queue.offer(new Cell(i,i,Type.FREE));
            }
            Cell poll = queue.poll();

            // verify
            System.out.println(poll.getType() + " == FREE");
            System.out.println(queue.size() + " == 4");

            // test
            assert poll.getType() == Type.FREE : "Error in CellQueue::poll()"; 
            assert queue.size() == 3 : "Error in CellQueue::poll()";
        }
        System.out.println("Done Testing!");
    }

}  

