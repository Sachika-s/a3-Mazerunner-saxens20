package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import org.apache.commons.cli.*;

public class Main {

    public static void main(String[] args) {
    
        Options options = new Options();

      
        Option iFlag = new Option("i", true, "Maze File to be used");
        options.addOption(iFlag);

        Option pFlag = new Option("p", true, "verify path used");
        options.addOption(pFlag);

        CommandLineParser parser = new DefaultParser();

        try {
           
            CommandLine cmd = parser.parse(options, args);

            if (!cmd.hasOption("i")) {
                System.err.println("Missing argument '-i' before inputting a maze file");
                System.exit(1);
            }

            String inputFile = cmd.getOptionValue("i");

    

            System.out.println("**** Reading the maze from file " + inputFile);
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line;

        
            while ((line = reader.readLine()) != null) {
    
            }

            
            BufferedReader reader1 = new BufferedReader(new FileReader(inputFile));
            BufferedReader reader2 = new BufferedReader(new FileReader(inputFile));
        
            Maze maze = new Maze(reader1, reader2);
            maze.sizeArray();
            char[][] mazeArr = maze.mazetoArray();
            int width = maze.getWidth();
            int length = maze.getLength();
            int entry = maze.getEntry();
            int exit = maze.getExit();

            String givenPath = null;
            
        
            if (cmd.hasOption("p")) {
                givenPath = cmd.getOptionValue("p");
            }

           
            
            if (givenPath == null) {
                String direction = "RIGHT";

                System.out.println("**** Computing path");
                MazeSolverTemplate pathSolver = new RightHandSolver(mazeArr, width, length, entry, exit, direction);
                String path = pathSolver.FactorizedPath();
                System.out.println(path);
            }
           
          
            else {
                String direction = "RIGHT";
                ValidateRoute check = new ValidateRoute(givenPath, mazeArr, width, length, entry, exit, direction);
                System.out.println(check.checkPath());
            }

        } catch (Exception e) {
            System.err.println("/!\\ An error has occurred /!\\");
            //e.printStackTrace();
        }


        System.out.println("** End of MazeRunner");
    }
}

