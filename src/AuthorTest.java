

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class AuthorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AuthorTest
{
    private Author author1;

    /**
     * Default constructor for test class AuthorTest
     */
    public AuthorTest()
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
        author1 = new Author("An", "Na");
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
     * Tests if a first name is changed correctly by entering the new name in the setter method and checking the getter value.
     */
    public void testChangeFirstName()
    {
        author1.changeFirstName("Darth");
        assertEquals("Darth", author1.getFirstName());
    }

    @Test
    /**
     * Tests if a last name is changed correctly by entering the new name in the setter method and checking the getter value.
     */
    public void testChangeLastName()
    {
        author1.changeLastName("Vader");
        assertEquals("Vader", author1.getLastName());
    }
}


