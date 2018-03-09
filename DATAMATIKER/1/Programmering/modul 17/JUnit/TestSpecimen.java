

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestSpecimen.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestSpecimen {
    /**
     * Default constructor for test class TestSpecimen
     */
    public TestSpecimen() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }

    @Test
    public void testAddGood(){
        Specimen specimen2 = new Specimen();
        assertEquals(2, specimen2.add(1, 1));
    }

    @Test
    public void testMultiply(){
        Specimen specimen1 = new Specimen();
        assertEquals(1, specimen1.multiply(1, 1));
        assertEquals(6, specimen1.multiply(2, 3));
    }

    @Test
    public void testDivisible() {
        Specimen specimen1 = new Specimen();
        assertEquals(true, specimen1.isDivisible(4, 2));
    }

    @Test
    public void isDivisible() {
        Specimen specimen1 = new Specimen();
        assertEquals(false, specimen1.isDivisible(3, 2));
        assertEquals(false, specimen1.isDivisible(1212, 222));
    }

    @Test
    public void testSpanish() {
        Specimen specimen1 = new Specimen();
        assertEquals("Hola", specimen1.helloInSpanish());
    }
}





