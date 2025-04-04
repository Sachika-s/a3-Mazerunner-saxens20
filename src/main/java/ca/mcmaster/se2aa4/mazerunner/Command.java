package ca.mcmaster.se2aa4.mazerunner;
import ca.mcmaster.se2aa4.mazerunner.Compass;

public interface Command {
   // void execute(int[] pos, Compass.Direction direction, int r, int c, int width, int length);
    String execute(int[] pos, Compass.Direction direction, int r, int c, int width, int length);
}
