package ca.mcmaster.se2aa4.mazerunner;

public class Compass {

    
    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }



    private Direction compass;

    private int row;
    private int col;



    public Compass(Direction compass, char[][] maze, int width, int len) {
        this.compass = compass;

    }

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
        

    public Direction getCompass() {
        return compass;
    }


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

    public int getRow() {
        return row;
    }


    public int getCol() {
        return col;
    }
}


