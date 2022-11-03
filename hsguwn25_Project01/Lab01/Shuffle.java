/**
File: Shuffle.java
Author: Hesed Guwn
Date: 09/13/2022
Project01
Lab01 
Course: CS231 B
**/

import java.util.ArrayList;
import java.util.Random;

public class Shuffle 
{
    public static void main(String[] args)
    {
        //Creates list and creates random number generator
        ArrayList<Integer> arr = new ArrayList<Integer>(); 
        Random ran = new Random();

        //List that is shuffled into
        ArrayList<Integer> arr2 = new ArrayList<Integer>();

        for(int i = 0; i < 10; i++)
        {
            //Task 5 Generates random numbers, adds them to the array, and prints them
            
            // int val = ran.nextInt(100);
            // System.out.println("Random Number Generated: " + val);
            
            //Task 8 Changes the array to be numbers 1-10 instead of random numbers
            
            arr.add(i+1);
        }
        
        for(int j = 0; j < 10; j++)
        {
            //Task 6 Prints out the content of the array
            int x = arr.get(j);
            System.out.println("Content Index " + j + ": " + x);
        }

        System.out.println(arr);

        for(int i = 0; i < 10; i++)
        {
            //Task 7 Randomly selects an index and removes the number and prints the removed number and the new array
            int idx = ran.nextInt(arr.size());
            int removedVal = arr.get(idx);

            //Task 9 Creates a new shuffled list
            arr2.add(removedVal);

            System.out.print("Index Removed: " + idx + " ");
            arr.remove(idx);
            System.out.println(arr);

            //Task 9 Prints shuffled list
            System.out.println("New List: " + arr2);
        }
    }
}