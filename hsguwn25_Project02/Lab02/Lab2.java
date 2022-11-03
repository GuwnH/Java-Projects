/**
File: Lab2.java
Author: Hesed Guwn
Date: 09/20/2022
Project02
Lab02
Course: CS231 B
**/

public class Lab2 {
    public static void main(String[] args) {
        
        int[][] ints = new int[3][5];
        for(int r=0; r < ints.length; r++)
        {
            for(int c=0; c < ints[r].length; c++ )
            {
                ints[r][c] = r * c;
            }
        }
        for(int r=0; r < ints.length; r++)
        {
            for(int c=0; c < ints[r].length; c++ )
            {
                System.out.println(ints[r][c]);
            }
            System.out.println();
        }
        
    }

}
