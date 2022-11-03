/**
File: WordCounter.java
Author: Hesed Guwn
Date: 10/29/2022
Project06
Course: CS231 B
**/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;

public class WordCounter 
{
    //Field wordCount is the total amount of words, map is a BSTMap 
    int wordCount;
    BSTMap<String, Integer> map;

    //Default Constructor, initializes empty map and 0 word count
    public WordCounter()
    {
        this.wordCount = 0;
        this.map = new BSTMap<String, Integer>();
    }

    //Reads a file one line at a time and generates word counts for words 
    public void analyze(String filename)
    {
        try
        {
            // assign to a variable of type FileReader a new FileReader object, passing filename to the constructor
            FileReader fr = new FileReader(filename);
            // assign to a variable of type BufferedReader a new BufferedReader, passing the FileReader variable to the constructor
            BufferedReader br = new BufferedReader(fr);
            
            // assign to a variable of type String line the result of calling the readLine method of your BufferedReader object.
            String line = br.readLine();
            
            // reset wordcount before counting
            this.wordCount = 0;
            this.map.clear();

            //While there are still lines to read
            while(line!=null)
            {
                // split line into words. The regular expression can be interpreted as split on anything that is not (^) (a-z or A-Z or 0-9 or ').
                String[] words = line.split("[^a-zA-Z0-9']");

                for (int i = 0; i < words.length; i++) 
                {
                    String word = words[i].trim().toLowerCase();
                    // Might want to check for a word of length 0 and not process it
                    if(word.length() == 0)
                    {
                        continue;
                    }
                    // Write code to update the map
                    if(map.containsKey(word))
                    {
                        this.map.put(word, map.get(word)+1);
                    }
                    else
                    {
                        this.map.put(word,1);
                    }
                    this.wordCount ++;
                    // System.out.println(this.wordCount);
                }
                //continues reading
                line = br.readLine();
            }

            br.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("WordCounter.analyze():: unable to open file " + filename );
          }
          catch(IOException ex) {
            System.out.println("WordCounter.analyze():: error reading file " + filename);
          }
        
    }

    //Returns int field wordCount
    public int getTotalWordCount()
    {
        return this.wordCount;
    }

    //Returns int the amount of unique words
    public int getUniqueWordCount()
    {
        return this.map.size();
    }

    //Returns int the count of a word
    public int getCount( String word )
    {
        if(this.map.containsKey(word))
        {
            return this.map.get(word);
        }
        else 
        {
            return 0;
        }
    }

    //Returns double the frequency/percentage of the word out of the total words
    public double getFrequency( String word )
    {

        if(this.map.containsKey(word))
        {
            double specificWordCount = this.map.get(word);
            double totalWords = this.wordCount;
            return specificWordCount/totalWords;
        }
        else 
        {
            return 0.0;
        }
    }

    //Creates and writes a text file that contains each key value pair inside the tree
    public void writeWordCountFile( String filename )
    {
        try 
        {
            //Opens file writer
            FileWriter fw = new FileWriter(filename);
            //Writes total word count
            fw.write("totalWordCount : " + this.getTotalWordCount());
            
            //Writes each key value pair inside the tree in pre-order format
            for (MapSet.KeyValuePair<String, Integer> kvp : this.map.entrySet()) 
            {
                fw.write("\n");
                fw.write(kvp.getKey() + " " + kvp.getValue());    
            }

            //Close file writer
            fw.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("WordCounter.writeWordCountFile():: unable to open file " + filename );
          }
          catch(IOException ex) {
            System.out.println("WordCounter.writeWordCountFile():: error writing file " + filename);
          }
    }

    //Reads a file that is formatted similarly to a file made by writeWordCountFile and reconstructs the fields of WordCounter based off of it
    public void readWordCountFile( String filename )
    {
        map.clear();
        this.wordCount = 0;

        try
        {
            //Opens file reader
            FileReader fr = new FileReader(filename);
            //Opens buffered file reader
            BufferedReader bfr = new BufferedReader(fr);

            //Reads word count seperately from the key values
            String line = bfr.readLine();
            String[] words = line.split("[^a-zA-Z0-9']");
            this.wordCount = Integer.parseInt(words[3]);
            line = bfr.readLine();

            //While there are sitll lines to read
            while(line != null)
            {
                //Splits the key and value
                words = line.split("[^a-zA-Z0-9']");
                //Gets key from file
                String key = words[0];
                //Gets value from file
                int value = Integer.parseInt(words[1]);
                //Puts the current key value into the map
                map.put(key, value);
                //Continues to read next line
                line = bfr.readLine();
            }

        }
        catch(FileNotFoundException ex) {
            System.out.println("WordCounter.readWordCountFile():: unable to open file " + filename );
          }
          catch(IOException ex) {
            System.out.println("WordCounter.readWordCountFile():: error reading file " + filename);
          }
        
    }

    public static void main(String[] args) 
    {
        WordCounter counter = new WordCounter();

        //Tests every method here

        // counter.analyze("countTest.txt");
        // counter.writeWordCountFile("new.txt");
        // counter.readWordCountFile("new.txt");
        // System.out.println(counter.getTotalWordCount());
        // System.out.println(counter.getUniqueWordCount());
        // System.out.println(counter.getCount("it"));
        // System.out.println(counter.getFrequency("it"));
        // System.out.println(counter.map);

        //Part 7 of the project here 

        for (String filename : args) 
        {
            long startTime=System.nanoTime();
            counter.analyze(filename);
            long endTime=System.nanoTime();
            System.out.println(filename + " took: " + (endTime-startTime) + " nanoseconds");
            System.out.println("Total word count for this file is: " + counter.getTotalWordCount());
            System.out.println("Unique word count for this file is: " + counter.getUniqueWordCount());
            counter.writeWordCountFile(filename.substring(0, filename.length()-4)+"_word_Counts.txt");  
        }
    }

}
