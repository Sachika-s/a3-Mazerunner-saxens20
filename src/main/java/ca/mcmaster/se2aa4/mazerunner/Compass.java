package ca.mcmaster.se2aa4.mazerunner;

public class Compass{
    private final StringBuilder path;

    
/**
 * Constructor of the compass class
 * no parameters needed 
**/
    public Compass(){
        path = new StringBuilder();
    }


/**
 * Function - converts the directions into F,R or L. Easier for factorized and canonical representation
 * Parameter - direction class needed 
**/
    public void move(Direction direction) {
        switch (direction) {
            case FORWARD -> path.append("F");
            case RIGHT -> path.append("R");
            case LEFT -> path.append("L");
        }
    }
/**
 * Getter method, gets path and converts to string
 * no parameters needed 
**/
    public String getPath() {
        return path.toString();
    }


}