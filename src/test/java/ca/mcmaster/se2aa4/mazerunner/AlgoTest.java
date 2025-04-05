package ca.mcmaster.se2aa4.mazerunner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import org.apache.commons.cli.*;
import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//Purpose - tests several different mazes to test Right Hand algorithm 
public class AlgoTest {

    @Test
    public void testSimpleMaze() {
  
        String expected = "5F2L2FR2FR2F2L2FR2FR3F";

        Compass.Direction dir = Compass.Direction.RIGHT;
        Path mazePath = Paths.get("examples/tiny.maz.txt");

        try(
        BufferedReader reader1 = new BufferedReader(new FileReader(mazePath.toFile()));
        BufferedReader reader2 = new BufferedReader(new FileReader(mazePath.toFile())); ){
        Maze maze = new Maze(reader1, reader2);

        maze.sizeArray();
        char[][] mazeArr = maze.mazetoArray();

        int width = maze.getWidth();
        int length = maze.getLength();
        int entry = maze.getEntry();
        int exit = maze.getExit();
        String direction = "RIGHT";

        MazeSolverTemplate solver = new RightHandSolver(mazeArr, width, length, entry, exit, direction);
        String output = solver.FactorizedPath();

       
        assertEquals(expected, output);

        } catch (IOException e){
            System.err.println("Error in reading file" + e.getMessage());
        }
    




        
     
       
    }


 
    @Test
    public void testMaze2() {
  
        String expected = "FR6F2L8FR2FR2F2L2FR2FR4FR2FL4FL2F2L2FR4FR2FL2FR2FR4FR2F2L2FL2FR2FR4FR2F2L2FL2FR2F2L2FR2FR2F2L4FR2FR2F2L4FR2FR2F2L4FR2FR2F2L2FR10FR2FR8F2L8FL2FR4FR2FR2F2L2FR2FR14F2L12FR2FR6F2L4FR2FR6FR2FL6F2L6FR2FR8F2L12FR2FR10F2L6FR2FR4F2L4FL2FR4FL2FR2FL2FR2FL2FR2FL4FR2FR2F2L4FR2FR6FR2F2L2FR2FR4F2L2FR2FR4F2L4FR2FR2F2L2FR2FR4FR2FL2F2L2FR2FR6FL2FR8F2L8FR2FR10FR4FR2F2L2FR2F2L2FR2FR2FL4FR2F2L4F2L2FR4FR2FR2F2L4FR2FR6F2L6FR4FR2FR2FL2F2L2FR4FR2FR2F2L2FR2FR4F2L4FL4FR2FR4F2L2FR2F2L2FR2FR2F2L6FR2FR8FR6FR2F2L2FL2FRF";

        Compass.Direction dir = Compass.Direction.RIGHT;
        Path mazePath = Paths.get("examples/medium.maz.txt");

        try(
        BufferedReader reader1 = new BufferedReader(new FileReader(mazePath.toFile()));
        BufferedReader reader2 = new BufferedReader(new FileReader(mazePath.toFile())); ){
        Maze maze = new Maze(reader1, reader2);

        maze.sizeArray();
        char[][] mazeArr = maze.mazetoArray();

        int width = maze.getWidth();
        int length = maze.getLength();
        int entry = maze.getEntry();
        int exit = maze.getExit();
        String direction = "RIGHT";

        MazeSolverTemplate solver = new RightHandSolver(mazeArr, width, length, entry, exit, direction);
        String output = solver.FactorizedPath();

        // Compare to expected
        assertEquals(expected, output);

        } catch (IOException e){
            System.err.println("Error in reading file" + e.getMessage());
        }
    




        
     
       
    }
 
    @Test
    public void testStraightMaze() {
  
        String expected = "FR2FL3FRFLFRFL2F";

        Compass.Direction dir = Compass.Direction.RIGHT;
        Path mazePath = Paths.get("examples/direct.maz.txt");

        try(
        BufferedReader reader1 = new BufferedReader(new FileReader(mazePath.toFile()));
        BufferedReader reader2 = new BufferedReader(new FileReader(mazePath.toFile())); ){
        Maze maze = new Maze(reader1, reader2);

        maze.sizeArray();
        char[][] mazeArr = maze.mazetoArray();

        int width = maze.getWidth();
        int length = maze.getLength();
        int entry = maze.getEntry();
        int exit = maze.getExit();
        String direction = "RIGHT";

        MazeSolverTemplate solver = new RightHandSolver(mazeArr, width, length, entry, exit, direction);
        String output = solver.FactorizedPath();

        // Compare to expected
        assertEquals(expected, output);

        } catch (IOException e){
            System.err.println("Error in reading file" + e.getMessage());
        }
    




        
     
       
    }
 
}
