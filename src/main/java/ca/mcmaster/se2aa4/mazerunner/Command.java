package ca.mcmaster.se2aa4.mazerunner;
import ca.mcmaster.se2aa4.mazerunner.Compass;

//command interface in place for Commnad Design Pattern 
public interface Command {
    String execute(int[] pos, Compass.Direction direction, int r, int c, int width, int length);
}
