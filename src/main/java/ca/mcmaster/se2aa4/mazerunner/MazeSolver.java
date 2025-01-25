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




}