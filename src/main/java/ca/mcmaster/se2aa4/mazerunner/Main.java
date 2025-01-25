package ca.mcmaster.se2aa4.mazerunner;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;


public class Main {

    private static final Logger logger = LogManager.getLogger();


    public static void main(String[] args) {
        Options options = new Options();
        logger.info("** Starting Maze Runner");

        Option iFlag = new Option("i", true, "Maze File to be used");
        options.addOption(iFlag);

        try {
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options,args);
            String fileFlag = cmd.getOptionValue("i");
            
            logger.info("**** Reading the maze from file " + fileFlag);
            Maze maze = new Maze(fileFlag);
            
            logger.info("**** Computing path");

            MazeSolver solution = new MazeSolver();
            String answer = solution.findPath(maze);

            logger.info("Canonical Path " + answer);

        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
            logger.info("PATH NOT COMPUTED");
        }

        logger.info("** End of MazeRunner");
    }
}

