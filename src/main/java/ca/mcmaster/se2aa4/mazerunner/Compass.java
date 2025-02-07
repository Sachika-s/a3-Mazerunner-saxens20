package ca.mcmaster.se2aa4.mazerunner;

public class Compass {

   //created enum for directions  
    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }



    private Direction compass;

    private int row;
    private int col;


//constructor class , parameters are compass, maze,width, length
    public Compass(Direction compass, char[][] maze, int width, int len) {
        this.compass = compass;

    }
/*function - direciton responsible of setting r and c values
 * parameter - nothing 
 * 
 */
    public void Direction() {
        switch (compass) {
            case UP:
                row = -1;
                col = 0;
                break;
            case DOWN:
                row = 1;
                col = 0;
                break;
            case LEFT:
                row = 0;
                col = -1;
                break;
            case RIGHT:
                row = 0;
                col = 1;
                break;
        }
    }
        
/*function - getter method
 * parameter - nothing
 * 
 */
    public Direction getCompass() {
        return compass;
    }

/*function - update current direction based on move
 * parameter - move 
 * 
 */
    public void currentDirection(String move) {
        if (move.contains("R")) {
            switch (compass) {
                case UP -> compass = Direction.RIGHT;
                case RIGHT -> compass = Direction.DOWN;
                case DOWN -> compass = Direction.LEFT;
                case LEFT -> compass = Direction.UP;
            }
        } else if (move.contains("L")) {
            switch (compass) {
                case UP -> compass = Direction.LEFT;
                case LEFT -> compass = Direction.DOWN;
                case DOWN -> compass = Direction.RIGHT;
                case RIGHT -> compass = Direction.UP;
            }
        }
    }
/*function - getter methods 
 * parameter - nothing
 * 
 */
    public int getRow() {
        return row;
    }

/*function - getter methods 
 * parameter - nothings 
 * 
 */
    public int getCol() {
        return col;
    }
}


