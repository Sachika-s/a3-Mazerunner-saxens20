package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompassTest {

    @Test
    void testInitialDirection() {
        Compass compass = new Compass(Compass.Direction.UP, new char[5][5], 5, 5);
        assertEquals(Compass.Direction.UP, compass.getCompass());
    }

    @Test
    void testSetDirectionUp() {
        Compass compass = new Compass(Compass.Direction.UP, new char[5][5], 5, 5);
        compass.Direction();
        assertEquals(-1, compass.getRow());
        assertEquals(0, compass.getCol());
    }

    @Test
    void testSetDirectionDown() {
        Compass compass = new Compass(Compass.Direction.DOWN, new char[5][5], 5, 5);
        compass.Direction();
        assertEquals(1, compass.getRow());
        assertEquals(0, compass.getCol());
    }

    @Test
    void testSetDirectionLeft() {
        Compass compass = new Compass(Compass.Direction.LEFT, new char[5][5], 5, 5);
        compass.Direction();
        assertEquals(0, compass.getRow());
        assertEquals(-1, compass.getCol());
    }

    @Test
    void testSetDirectionRight() {
        Compass compass = new Compass(Compass.Direction.RIGHT, new char[5][5], 5, 5);
        compass.Direction();
        assertEquals(0, compass.getRow());
        assertEquals(1, compass.getCol());
    }

    @Test
    void testTurnRightFromUp() {
        Compass compass = new Compass(Compass.Direction.UP, new char[5][5], 5, 5);
        compass.currentDirection("R");
        assertEquals(Compass.Direction.RIGHT, compass.getCompass());
    }

    @Test
    void testTurnRightFromRight() {
        Compass compass = new Compass(Compass.Direction.RIGHT, new char[5][5], 5, 5);
        compass.currentDirection("R");
        assertEquals(Compass.Direction.DOWN, compass.getCompass());
    }

    @Test
    void testTurnLeftFromUp() {
        Compass compass = new Compass(Compass.Direction.UP, new char[5][5], 5, 5);
        compass.currentDirection("L");
        assertEquals(Compass.Direction.LEFT, compass.getCompass());
    }

    @Test
    void testTurnLeftFromLeft() {
        Compass compass = new Compass(Compass.Direction.LEFT, new char[5][5], 5, 5);
        compass.currentDirection("L");
        assertEquals(Compass.Direction.DOWN, compass.getCompass());
    }

    @Test
    void testMultipleTurns() {
        Compass compass = new Compass(Compass.Direction.UP, new char[5][5], 5, 5);
        compass.currentDirection("R");
        compass.currentDirection("R");
        compass.currentDirection("L");
        assertEquals(Compass.Direction.RIGHT, compass.getCompass());
    }
}
