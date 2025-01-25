package ca.mcmaster.se2aa4.mazerunner;
public class MazeSolver{
    private Compass compass;


    public MazeSolver() {
       this.compass = new Compass();
    }

    public int entryPoint(char[][] maze){
        for(int i = 0; i < maze[0].length; i++){
            if(maze[0][i] == ' '){
                return i;
            }
        }
        return 0;
    }

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