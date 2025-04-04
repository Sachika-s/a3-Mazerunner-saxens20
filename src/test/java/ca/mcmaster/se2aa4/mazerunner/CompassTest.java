package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompassTest {

    @Test  
    void testInitialDirection() {
        Compass compass = new Compass(Compass.Direction.UP, new char[10][10], 10, 10);

        assertEquals(Compass.Direction.UP, compass.getCompass());
    }
 //testing if runner moves to right positon according to given direction commands 
    @Test
    void testDirectionUp() {
        Compass compass = new Compass(Compass.Direction.UP, new char[10][10], 10, 10);
        compass.Direction();
        assertEquals(-1, compass.getRow());
        assertEquals(0, compass.getCol());
    }

    @Test
    void testDirectionDown() {
        Compass compass = new Compass(Compass.Direction.DOWN, new char[10][10], 10, 10);
        compass.Direction();
        assertEquals(1, compass.getRow());
        assertEquals(0, compass.getCol());
    }

    @Test
    void testDirectionLeft() {
        Compass compass = new Compass(Compass.Direction.LEFT, new char[10][10], 10, 10);
        compass.Direction();
        assertEquals(0, compass.getRow());
        assertEquals(-1, compass.getCol());
    }

    @Test
    void testDirectionRight() {
        Compass compass = new Compass(Compass.Direction.RIGHT, new char[10][10], 10, 10);
        compass.Direction();
        assertEquals(0, compass.getRow());
        assertEquals(1, compass.getCol());
    }

    //testing right and leff turns from various directions 
    
    @Test
    void testTurnRfromU() {  //turning right from direction up
        Compass compass = new Compass(Compass.Direction.UP, new char[10][10], 10, 10);
        compass.currentDirection("R");
        assertEquals(Compass.Direction.RIGHT, compass.getCompass());
    }

    @Test
    void testTurnRfromR() {  //turning right from direction right 
        Compass compass = new Compass(Compass.Direction.RIGHT, new char[10][10], 10, 10);
        compass.currentDirection("R");
        assertEquals(Compass.Direction.DOWN, compass.getCompass());
    }

    @Test
    void testTurnLfromU() {  //turning left from direction up
        Compass compass = new Compass(Compass.Direction.UP, new char[10][10], 10, 10);
        compass.currentDirection("L");
        assertEquals(Compass.Direction.LEFT, compass.getCompass());
    }

    @Test
    void testTurnLfromL() { //turning left from direction left

        Compass compass = new Compass(Compass.Direction.LEFT, new char[10][10], 10, 10);
        compass.currentDirection("L");
        assertEquals(Compass.Direction.DOWN, compass.getCompass());
    }

   
}
