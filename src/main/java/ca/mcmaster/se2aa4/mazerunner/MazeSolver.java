package ca.mcmaster.se2aa4.mazerunner;
public class MazeSolver{
    private Compass compass;

/**
 * Function - constructor of mazeSolver class 
 * Parameter - none needed  
**/
    public MazeSolver() {
       this.compass = new Compass();
    }
/**
 * Function - identfies starting point 
 * Parameter - array maze 
**/
    public int entryPoint(char[][] maze){
        for(int i = 0; i < maze[0].length; i++){
            if(maze[0][i] == ' '){
                return i;
            }
        }
        return 0;
    }
/**
 * Function - implements a simple algorithm to move through straight maze
 * Parameter - maze object from Maze class 
**/
    public String findPath(Maze maze){
        
        char[][] mazeArray = maze.getMazeArray();
        int entry = entryPoint(mazeArray);
        int y = 0;
        

        for ( int x = entry ; x < maze.getWidth(); x++){
            if(maze.wallCheck(x,y) == true){
                compass.move(Direction.FORWARD);
            }else{
                break;
            }
        }
        return compass.getPath();
        }



}