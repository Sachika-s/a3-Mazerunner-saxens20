package ca.mcmaster.se2aa4.mazerunner;
import ca.mcmaster.se2aa4.mazerunner.Compass;
public class ForwardCommand implements Command{

//following command dp - explorer moves forward 
    @Override 
    public String execute(int [] pos, Compass.Direction direction, int r, int c, int width, int length){
        int newR = pos[0] + r;
        int newC = pos[1] + c;

        if(newR >= 0 && newR < length && newC >=0 && newC < width){
            pos[0] = newR;
            pos[1]= newC;
        }

        return "F";
    }
    
}
