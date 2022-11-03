/**
File: CellQueue.java
Author: Hesed Guwn
Date: 10/18/2022
Project05
Course: CS231 B
**/

package CS231.hsguwn25_Project05.Lab05;

public class CellQueue 
{
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
    
    Node head;
    Node tail;
    int size;

    public CellQueue()
    {
        head = null;
        tail = null;
        size = 0;
    }

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

    public Cell peek()
    {
        return this.head.cell;
    }

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

    public int size()
    {
        return this.size;
    }
}
