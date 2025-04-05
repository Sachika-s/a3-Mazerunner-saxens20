package ca.mcmaster.se2aa4.mazerunner;
//implement the template design pattern 

public class RightHandSolver extends MazeSolverTemplate {
    private RightHandAlgo algo;

    public RightHandSolver(char[][] maze, int width, int length, int entry, int exit, String direction) {
        super(maze, width, length, entry, exit, direction);
        //this.algo = new RightHandAlgo(maze);
    }

    @Override
    protected String NextMove(Compass.Direction direction, int currentY, int currentX, int r, int c) {
        return algo.Play(direction, pos[0], pos[1], r, c);
    }
}
