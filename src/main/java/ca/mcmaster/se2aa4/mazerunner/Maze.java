package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Maze{
    private static final Logger logger = LogManager.getLogger();
    private int width;
    private char[][]mazeArray;
    private List<char[]> newMaze;

/**
 * Function - Construcutor of the Maze class
 * Parameter - file given by user  
**/
    public Maze(String filePath){
    
        mazeArray = readMaze(filePath);
        width = mazeArray[0].length;
    }

/**
 * Function - coverts given file into a 2D array. Uses BufferReader  
 * Parameter - file given by user  
**/
    public char[][] readMaze(String filePath){
        newMaze = new ArrayList<>();

        try{
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String row;
        while((row = reader.readLine()) != null){
            if(row.trim().length() != 0){
                newMaze.add(row.toCharArray());
            }
        }
        reader.close();
        return newMaze.toArray(new char[0][]);

    }catch(Exception e){
        logger.error("An error has occured");
        return null;
    }
    }

/**
 * Function - boolean check to verfiy is path is free to move
 * Parameter - coordinates from array  
**/

    public boolean emptyspaceCheck(int x, int y ){
        boolean check = mazeArray[y][x] == ' ';
        return check; 
    }
/**
 * Function - boolean check to verfiy for WALL
 * Parameter - coordinates from array  
**/
    public boolean wallCheck(int x, int y ){
        boolean check = mazeArray[y][x] == '#';
        return check; 
    }
/**
 * Function - getter method for Maze Array
 * Parameter - no parameters needed   
**/

    public char[][] getMazeArray() {
        return mazeArray;
    }

 /**
 * Function - getter for width of array
 * Parameter - no parameters   
**/
    public int getWidth() {
        return width;
    }


}