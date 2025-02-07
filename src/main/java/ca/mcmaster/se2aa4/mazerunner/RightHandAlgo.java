package ca.mcmaster.se2aa4.mazerunner;


public class RightHandAlgo {

    private char[][] maze;


    public RightHandAlgo(char[][] maze ) {
        this.maze = maze;
    }

    private boolean checkWall(int y, int x){
        return isInBounds(y,x)&& maze[y][x] == '#';
    }

    private boolean checkEmpty(int y, int x){
        return isInBounds(y,x) && maze[y][x] == ' ';


    }

    private boolean isInBounds(int y , int x){
        return y >= 0 && y< maze.length && x >= 0 && x < maze[0].length;
    }

    public String Play(Compass.Direction direction, int currentY, int currentX, int r, int c) {

        if (direction == Compass.Direction.RIGHT) {
           if (checkWall(currentY+1, currentX)) {
                if (checkEmpty(currentY+r,currentX+c)) {
                    return "F";
                }
                else {
                    return "L";
                }
            }
            else {
                if (checkEmpty(currentY + c, currentX + r)) {
                    currentY += r;
                    currentX += c;
                    return "RF";
                }
                else {
                    return "R";
                }
            }
        }
        else if (direction == Compass.Direction.LEFT) {
            if (checkWall(currentY-1 , currentX ) ) {
                if (checkEmpty(currentY + r , currentX+c )) {
                    currentY += r;
                    currentX += c;
                    return "F";
                }
                else {
                    return "L";
                }
            }
            else {
                if (checkEmpty(currentY+c ,currentX+r)) {
                    currentY += r;
                    currentX += c;
                    return "RF";
                }
                else {
                    return "R";
                }
               
            }
        }
        else if (direction == Compass.Direction.UP) {
            if (checkWall(currentY,currentX+1)) {
                if (checkEmpty(currentY+r , currentX+c)) {
                    currentY += r;
                    currentX += c;
                    return "F";
                }
                else {
                    return "L";
                }
            }
            else {
                if (checkEmpty(currentY-c,currentX-r)) {
                    currentY += r;
                    currentX += c;
                    return "RF";
                }
                    else {
                  return "R";
                }
            }
        }
        else if (direction == Compass.Direction.DOWN) {
            if (checkWall(currentY,currentX-1)) {
                if (checkEmpty(currentY+r , currentX+c )) {
                    currentY += r;
                    currentX += c;
                    return "F";
                }
                else {
                    return "L";
                }
            }
            else {
                if (checkEmpty(currentY-c,currentX-r)) {
                    currentY += r;
                    currentX += c;
                    return "RF";
                }
                else {
                    return "R";
                }
            }
        }
        else return "";
    }
 


    
}
