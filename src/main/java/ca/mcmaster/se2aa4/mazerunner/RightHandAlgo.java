package ca.mcmaster.se2aa4.mazerunner;


public class RightHandAlgo {

    private char[][] maze;
//CONSTRUCTOR 

    public RightHandAlgo(char[][] maze ) {
        this.maze = maze;
    }
/*function - checks for wall
 * parameter - x and y coordinates 
 * 
 */
    private boolean checkWall(int y, int x){
        return isInBounds(y,x)&& maze[y][x] == '#';
    }
/*function - checks for pASS
 * parameter - x and y coordinates 
 * 
 */
    private boolean checkEmpty(int y, int x){
        return isInBounds(y,x) && maze[y][x] == ' ';


    }
/*function - ensures not going out of bounds
 * parameter - x andy coordinates 
 * 
 */
    private boolean isInBounds(int y , int x){
        return y >= 0 && y< maze.length && x >= 0 && x < maze[0].length;
    }
/*function - implemnts the righ thand alorigm , trys to take a right if possible
 * parameter - direciton, position coordinates of x and y, row and col 
 * 
 */
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
