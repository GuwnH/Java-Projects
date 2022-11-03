/**
File: CellQueue.java
Author: Hesed Guwn
Date: 10/18/2022
Project05
Course: CS231 B
**/

package CS231.hsguwn25_Project05;

public class CellQueue 
{
    //Creates a node that holds data
    private class Node 
    {
        Node next;
        Cell cell;
        Node prev;

        public Node(Cell c)
        {
            next = null;
            prev = null;
            cell = c;
        }
    }
    
    Node head; //front node of queue
    Node tail; //end node of queue
    int size; //size of queue

    //Initializes fields to null
    public CellQueue()
    {
        head = null;
        tail = null;
        size = 0;
    }

    //Adds a node to the end of the queue
    public void offer(Cell c)
    {
        Node newNode = new Node(c);

        if(size == 0)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    //Returns the head of queue
    public Cell peek()
    {
        return this.head.cell;
    }

    //Removes and returns the current head of queue
    public Cell poll()
    {
        if(size == 0)
        {
            return null;
        }
        if(size == 1)
        {
            Node value = this.head;
            this.head = null;
            this.tail = null;
            size--;
            return value.cell;
        }
        else 
        {
            Node value = this.head;
            this.head = head.next;
            size--;
            return value.cell;
        }
    }

    //Returns string representation of queue
    public String toString()
    {
        //Empty list string
        if(this.head == null)
        {
            return "[]";
        }
        //Iterates through the linked list and adds to the accumulator string and returns it
        else
        {    
            String accumulator = "[";
            Node walker = this.head;

            for(int i=0; i < this.size(); i++)
            {
                accumulator = accumulator + walker.cell.getType() + ", ";
                walker = walker.next;
            }

            //Creates a copy that is better formatted
            String accumulator2 = accumulator.substring(0, accumulator.length()-2);
            accumulator2 = accumulator2 + "]";

            return accumulator2;
        }
    }
    

    //Returns the size of queue
    public int size()
    {
        return this.size;
    }
}
