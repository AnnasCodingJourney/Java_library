

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class MemberTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MemberTest
{
    private Member member1;
    private Member member2;
    private Author author1;
    private PhysicalBooks physical1;

    /**
     * Default constructor for test class MemberTest
     */
    public MemberTest()
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
        member1 = new Member("Harry", "Potter");
        member2 = new Member("Darth", "Vader");
        author1 = new Author("Strath", "Clyde");
        physical1 = new PhysicalBooks(author1, "Hello world");
        member2.setBorrowedBooks(physical1);
        member2.numberOfBorrowedBooks();
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
     * tests how many books are borrowed by a member.
     * Member2 has 1 book in the list of borrowed books. 
     * Member1 has 0.
     */
    public void testNoOfBorrowedBooks()
    {
        assertEquals(1, member2.numberOfBorrowedBooks());
        assertEquals(0, member1.numberOfBorrowedBooks());
    }
}

