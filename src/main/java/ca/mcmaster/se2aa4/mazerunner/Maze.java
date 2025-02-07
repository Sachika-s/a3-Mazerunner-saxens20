package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Maze{
    private char[][] maze;

    private int length ;
    private int width;
  
   
    private int entry;
    private int exit;

    private BufferedReader reader;
    private BufferedReader reader2;
    private String line;
//construtor of maze 
    public Maze(BufferedReader reader, BufferedReader reader2) {
        this.reader = reader;
        this.reader2 = reader2;
    }
/*function - convert maze file into array, eaier for navigating
 * parameter - nothing
 * 
 */
    public char[][] mazetoArray() {
        maze = new char[length][width];
        int count = 0;
        try{

            while ((line = reader2.readLine()) != null) {
                for (int i = 0; i < width; i++) {
                    if (i > line.length()-1) {
                        maze[count][i] = ' ';
                    }
                    else {
                        maze[count][i] = line.charAt(i);
                    }
                }
                count++;
            }
        } catch(Exception e) {
            System.out.print("/!\\ An error has occured /!\\");
        }
        return maze;
    }
/*function - getther method
 * parameter - 
 * 
 */
    public void sizeArray() {
        try{
            while ((line = reader.readLine()) != null) {
                length++;
                for (int i = 0; i < line.length(); i++) {
                    width = line.length();
                }
            }

        } catch(Exception e) {
            System.out.print("/!\\ An error has occured /!\\");
        }
    }



   /*ALL 4 functions below - getter methods 
 * parameter - NA
 * 
 */ 
   
    public int getWidth() {
        return width;
    }

   
    public int getLength() {
        return length;
    }

   
    public int getEntry() {
        for (int i = 0; i < length; i++) {
            if (maze[i][0] == ' ') {
                entry = i;
            }
        }
        return entry;
    }

  
    public int getExit() {
        for (int j = 0; j < length; j++) {
            if (maze[j][width-1] == ' ') {
                exit = j;
            }
        }
        return exit;
    }

}


