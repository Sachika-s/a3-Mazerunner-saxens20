package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MazeSolverTest {

    @Test
    void testFactorizedToCanonicalConversion() {
        String factForm = "4F3R2F";
        String expected = "FFFFRRRFF";
        String output = MazeSolverTemplate.factorToCan(factForm);
        assertEquals(expected, output );
    }

    @Test
    void testCanonicalToFactorizedConversion() {
        String canForm = "FFFFRRRFF";
        String expected = "4F3R2F";
        String output = MazeSolverTemplate.canToFactor(canForm);
        assertEquals(expected, output);
    }



  
}
