/**
File: Grid.java
Author: Hesed Guwn
Date: 09/20/2022
Project02
Lab02
Course: CS231 B
**/

import java.util.Random;

public class Grid {
    
    //Task 6 Checks if content of arrays are equal
    public static boolean gridEquals(int[][] arr1, int[][] arr2)
    {
        if(arr1.length == arr2.length)
        {
            for(int i=0; i < arr1.length; i++)
            {
                if(arr1[i].length != arr2[i].length)
                {
                    return false;
                }
                else
                {
                    for(int j =0; j<arr1.length; j++)
                    {
                        if(arr1[i][j] != arr2[i][j])
                        {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        else
        {
            return false;
        }
    }
    
    // Task 7 Rotates an array 90 degrees
    public static int[][] rotate(int[][] arr)
    {
        int width = arr[0].length;
        int height = arr.length;
        int[][]newArr = new int[width][height];

        for(int i=0; i < width; i++)
        {
            for(int j = 0; j < height; j++)
            {
                newArr[i][j] = arr[j][i];
                newArr[i] = arr[j];
            }
        }
        return newArr;
    }

    public static void main(String[] args) {
       
        //Task 3 Check if arguments are provided in the command line
        if(args.length == 0)
        {
            System.out.println("Provide a command line argument");
            return;
        }
        else
        {
            //Task2 Make a for loop that prints out the command line array
            for(int i=0; i < args.length; i++)
            {
                System.out.println(args[i]);
            }

            //Task 4 Making a 2D Array
            
            String[][] grid;
            // grid = new String[3][5];
            // System.out.print(grid);
            // System.out.print(grid[0][0]);

            grid = new String[3][]; 
            for(int i = 0; i < 3; i++)
            {
                grid[i] = new String[i+3];
                //System.out.println(grid);
            } 
            
            Random ran = new Random();
            char letterA = (char) ran.nextInt(66,89);
            //System.out.println(letterA); 

            for(int i=0;i<grid.length;i++) 
            {
                for(int j=0;j<grid[i].length;j++)
                {
                    grid[i][j] = "" + letterA;
                }   
            }
            
            //Task5 Printing out array contents
            
            // for(int i = 0; i < grid.length; i++)
            // {    
            //     for(int j = 0; j < grid[i].length; j++)
            //     {
            //         System.out.print(grid[i][j]);
            //     }
            //     System.out.print(grid[i]);
            // }

            //Task6 Checking If Arrays Are Equal
            
            int[][] arr1 = new int[2][2];
            int[][] arr2 = new int[2][2];
            int[][] arr3;
            for(int i = 0; i < 2; i++)
            {
                for(int j = 0; j < 2; j++)
                {
                    arr1[i][j] = i+j;
                    arr2[i][j] = i+j;
                }
            } 
            arr3 = arr1;
            // System.out.println(arr1 == arr2);
            // System.out.println(arr1 == arr3);
            int[][] arr4;
            arr4 = new int[2][3];
            for(int i=0;i<arr4.length;i++) 
            {
                for(int j=0;j<arr4[i].length;j++)
                {
                    arr4[i][j] = j;
                }   
            }
            System.out.print(arr4);
            System.out.print(rotate(arr4));

            // System.out.println(gridEquals(arr1,arr2));

        }
    }
}
