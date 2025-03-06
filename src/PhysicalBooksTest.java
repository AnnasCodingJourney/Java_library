

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class PhysicalBooksTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PhysicalBooksTest
{
    private Author author1;
    private PhysicalBooks physical1;
    private PhysicalBooks physical2;
    private Member member1;

    /**
     * Default constructor for test class PhysicalBooksTest
     */
    public PhysicalBooksTest()
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
        author1 = new Author("Hari", "Bo");
        physical1 = new PhysicalBooks(author1, "Hello world");
        physical2 = new PhysicalBooks(author1, "Hello world 2");
        member1 = new Member("An", "Na");
        physical1.setDemagedBooks(physical1);
        physical2.setMember(member1);
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
     * Tests the book availability. 
     * physical1 is available and returns true, 
     * physical2 is not available and returns false
     */
    public void testBookAvailability()
    {
        assertEquals(true, physical1.bookAvailability());
        assertEquals(false, physical2.bookAvailability());
    }

    @Test
    /**
     * Tests the size of demaged books and if objects are added succesfully.
     * physical1 is added to the list, thus the size is 1.
     * Physical2's list is empty and returns 0
     */
    public void testGetSizeDemagedBooks()
    {
        assertEquals(1, physical1.getSizeDemagedBooks());
        assertEquals(0, physical2.getSizeDemagedBooks());
    }
}


