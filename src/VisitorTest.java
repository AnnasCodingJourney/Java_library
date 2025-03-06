

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class VisitorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class VisitorTest
{
    private Visitor visitor1;
    private Visitor visitor2;

    /**
     * Default constructor for test class VisitorTest
     */
    public VisitorTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        visitor1 = new Visitor("Donald", "Duck");
        visitor2 = new Visitor("Daisy", "Duck");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    /**
     * Tests whether the no of visits can be set correctly.
     * They cannot be set to more than 3. 
     * Thus 4 results to false, 2 results to true.
     */
    public void testNoOfVisits()
    {
        assertEquals(false, visitor1.noOfVisits(4));
        assertEquals(true, visitor2.noOfVisits(2));
    }
}

