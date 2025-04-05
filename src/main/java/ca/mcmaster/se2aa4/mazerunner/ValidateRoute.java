package ca.mcmaster.se2aa4.mazerunner;
/*
 * Purpsoe - class checks for the - p flag 
 * methods - constructor , getInput, CheckPath
 */
public class ValidateRoute {
    private String input;

    private String path;
   
    private char[][] maze;
    private int width;
    private int length;
    private int[] pos;
    private int r;
    private int c;
    private int entry;
    private int exit;

    private String direction;
    private Compass travel;
   /*
    * constructor
    */
    public ValidateRoute(String input, char[][] maze, int width, int length, int entry, int exit, String direction) {
        this.width = width;
        this.entry = entry;
        this.exit = exit;
        this.direction = direction;
        this.input = input;
        this.pos = new int[]{entry, 0};
        this.maze = maze;
        this.length = length;
      

    }

    /*
     * get input from user. 
     * returns - path in string format 
     */
 
    public String getInput() {
        String verifyPath;
        if (Character.isDigit(input.charAt(0))) {
            verifyPath = MazeSolverTemplate.factorToCan(input);
        }
        else {
            verifyPath = input;
        }

        return verifyPath;
    }

   /*
     *verfiy input is valid solution to exit path 
     * returns - string "Valid Path" is path given is correct. "Path inputted is incorrect" is path given is incorrect. 
     * "Path inputted is incorrect" - if path input is incorrect 
     */
    public String checkPath() {
        travel = new Compass(Compass.Direction.valueOf(direction), maze, width, length);
        travel.Direction();
        direction = travel.getCompass().toString();
        r = travel.getRow();
        c = travel.getCol();
        path = getInput();
        

        for (int j = 0 ; j < path.length(); j++){
            char step = path.charAt(j);

            if(step != 'F' && step != 'R' && step != 'L'){
                return "Incorrect format" ;
                
            }
        }

        for (int i = 0; i < path.length(); i++) {
            
            char move = path.charAt(i);

            travel.currentDirection(String.valueOf(move));
            travel.Direction();
            direction = travel.getCompass().toString();
            r = travel.getRow();
            c = travel.getCol();

            if (move == 'F' && maze[pos[0]+r][pos[1]+c] == ' ') {
                pos[0] += r;
                pos[1] += c;
            }

        }

        if (pos[0] != exit || pos[1] != width-1) {
            return "Path inputted is incorrect";
        }

        return "Valid Path";
    }

  
}

