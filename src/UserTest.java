

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class UserTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class UserTest
{
    private User user1;
    private User user2;

    /**
     * Default constructor for test class UserTest
     */
    public UserTest()
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
        user1 = new User("Harry", "Potter");
        user2 = new User("Darth", "Vader");
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
     * tests whether an Id is set correctly. 
     * Returns true if 6 digits are entered, false otherwise.
     */
    public void testSetId()
    {
        assertEquals(true, user1.setId(123456));
        assertEquals(false, user2.setId(12345));
    }
}

