package ca.mcmaster.se2aa4.mazerunner;


public class MazeSolver {
    protected Compass.Direction direction;
    private Compass travel;
    private RightHandAlgo algo;

    private char[][] maze;
    private int width, length;
    private int r, c;
    private int entry, exit;  
    private int[] pos;

    public MazeSolver(char[][] maze, int width, int length, int entry, int exit, String direction) {
        this.maze = maze;
        this.direction = Compass.Direction.valueOf(direction.toUpperCase());
        this.algo = new RightHandAlgo(maze);
        this.entry = entry;
        this.exit = exit;
        this.pos = new int[]{entry, 0};
        this.width = width;
        this.length = length;
    }

    public String findPath() {
        StringBuffer path = new StringBuffer();
        travel = new Compass(direction, maze, width, length);
        travel.Direction();
        direction = travel.getCompass();
        r = travel.getRow();
        c = travel.getCol();

        while (pos[0] != exit || pos[1] != width - 1) {
            int newR = pos[0] + r;
            int newC = pos[1] + c;

            if (newR >= 0 && newR < length && newC >= 0 && newC < width) {
                String move = algo.Play(direction, pos[0], pos[1], r, c);
                travel.currentDirection(move);
                travel.Direction();
                direction = travel.getCompass();
                r = travel.getRow();
                c = travel.getCol();
                path.append(move);
                if (move.contains("F")) {
                    pos[0] += r;
                    pos[1] += c;
                }
            }
        }
        System.out.println("Computed Path: " + path.toString());
        return path.toString();
    }


    public static String factorToCan(String path) {
        StringBuilder expandedP = new StringBuilder();
        int i = 0;
        StringBuilder repeat = new StringBuilder();
    
        while (i < path.length()) {
            char current = path.charAt(i);
    
            if (Character.isDigit(current)) {
                repeat.append(current);
            } else if (current == ' ') {
                i++; 
                continue;
            } else {
                int Counter = repeat.length() > 0 ? Integer.parseInt(repeat.toString()) : 1;
                repeat.setLength(0); 
    
                for (int j = 0; j < Counter; j++) {
                    expandedP.append(current);
                }
            }
            i++;
        }
    
        return expandedP.toString();
    }
    

    public static String canToFactor(String path) {


        StringBuilder factorized = new StringBuilder();
        char prev = path.charAt(0);
        int count = 1;

        for (int i = 1; i < path.length(); i++) {
            char curr = path.charAt(i);
            if (curr == prev) {
                count++;
            }   else {
                if (count > 1) {
                    factorized.append(count);
             }
             factorized.append(prev);
                prev = curr;
                count = 1;
          }
    }

        if (count > 1) {
            factorized.append(count);
        }
        factorized.append(prev);

        return factorized.toString();
}

public String FactorizedPath() {
    return canToFactor(findPath()); 
}

public String CanonicalPath() {
    return factorToCan(findPath()); 
}

}

