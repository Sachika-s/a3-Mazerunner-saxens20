package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidateRouteTest {


    private char[][] testStraightMaze() {  //tests straight maze 
        return new char[][]{
            {'#', '#', '#', '#', '#'},
            {' ', ' ', ' ', ' ', ' '},
            {'#', '#', '#', '#', '#'}
        };
    }

    @Test
    void testValidCanPath() {
        char[][] maze = testStraightMaze();
        String path = "FFFF";  // Straight right
        ValidateRoute test = new ValidateRoute(path, maze, 5, 3, 1, 1, "RIGHT");
        String output = test.checkPath();
        assertEquals("Valid Path", output );
    }

    @Test
    void testValidFactPath() {
        char[][] maze = testStraightMaze();
        String path = "4F"; 
        ValidateRoute test = new ValidateRoute(path, maze, 5, 3, 1, 1, "RIGHT");
        String output = test.checkPath();
        assertEquals("Valid Path", output );
    }

    @Test
    void testInvalidInput() {
        char[][] maze = testStraightMaze();
        String path = "RXRR";  // 'X' is invalid
        ValidateRoute test = new ValidateRoute(path, maze, 5, 3, 1, 1, "RIGHT");
        String result = test.checkPath();
        assertEquals("Incorrect format", result);
    }



    @Test
    void testPathHitsWall() {
        char[][] testmaze = {
            {'#', '#', '#', '#', '#'},
            {' ', ' ', '#', ' ', ' '},
            {'#', '#', '#', '#', '#'}
        };
        String path = "FFFF"; 
        ValidateRoute test = new ValidateRoute(path, testmaze, 5, 3, 1, 1, "RIGHT");
        String result = test.checkPath();
        assertEquals("Path inputted is incorrect", result);
    }

    
}
