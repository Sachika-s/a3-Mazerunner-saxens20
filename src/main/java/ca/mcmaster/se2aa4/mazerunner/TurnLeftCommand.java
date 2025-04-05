package ca.mcmaster.se2aa4.mazerunner;
import ca.mcmaster.se2aa4.mazerunner.Compass;

import ca.mcmaster.se2aa4.mazerunner.Compass;

public class TurnLeftCommand implements Command{

//following command dp - explorer turns left 
    @Override 
    public String execute(int[] pos, Compass.Direction direction, int r, int c, int width, int length ){
       Compass compass = new Compass(direction, null, width, length);
       compass.currentDirection("L");
       direction = compass.getCompass();
       compass.Direction();

       r= compass.getRow();
       c= compass.getCol();

       return "L";



    }
    
}
