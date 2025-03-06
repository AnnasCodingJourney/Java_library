

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class LibraryTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LibraryTest
{
    private Library library1;
    private Author author1;
    private Resources resource1;
    private EResources eResourc1;
    private PhysicalBooks physical1;
    private Author author2;
    private Member member1;
    private PhysicalBooks physical2;

    /**
     * Default constructor for test class LibraryTest
     */
    public LibraryTest()
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
        library1 = new Library();
        author1 = new Author("Micheal", "Jackson");
        resource1 = new Resources(author1, "Hello world");
        eResourc1 = new EResources("ABC", author1, true);
        physical1 = new PhysicalBooks(author1, "Welcome to Java");
        author2 = new Author("Darth", "Vader");
        member1 = new Member("Harry", "Potter");
        physical2 = new PhysicalBooks(author2, "Harry Potter");
        physical2.setMember(member1);
        library1.setLibraryCatalogue(resource1);
        library1.setLibraryCatalogue(eResourc1);
        library1.setLibraryCatalogue(physical1);
        library1.setLibraryCatalogue(physical2);
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
     * Tests, whether the resources have been added successfully to the catalogue,
     * by accessing the size of the catalogue.
     */
    public void testGetNoOfResources()
    {
        assertEquals(4, library1.getNumberOfResources());
    }

    @Test
    /**
     * Tests, whether the a resource can be found by entering a resource in the searching method. 
     * Since the catalogue contains the resouce, true is returned.
     */
    public void testFindByResource()
    {
        assertEquals(true, library1.findResourceByResource(eResourc1));
    }

    @Test
    /**
     * Tests, whether the a resource can be found by entering the title (ignoring upper and lowercase).
     * Test was applied to a title that should return 1 match and to one that is not in the list and should return 0.
     */
    public void testFindByTitle()
    {
        assertEquals(1, library1.findResourceByTitle("abc"));
        assertEquals(0, library1.findResourceByTitle("def"));
    }

    @Test
    /**
     * Tests, whether the a resource can be found by entering the author's surname.
     * Several resources have the same author, thus 3 should be returned as a matching score.
     * In the second example the surname is not in the list, thus 0 is expected to be returned.
     */
    public void testFindBySurname()
    {
        assertEquals(3, library1.findResourceBySurname("jackson"));
        assertEquals(0, library1.findResourceBySurname("swift"));
    }

    @Test
    /**
     * Tests, whether a resource can be removed by entering the resource.
     * First removing the resource and then checking the size of the list.
     */
    public void testRemoveResourceByResource()
    {
        library1.removeResourceByResource(eResourc1);
        assertEquals(3, library1.getNumberOfResources());
    }

    @Test
    /**
     * Tests, whether a resource can be removed by entering an index.
     */
    public void testRemoveByIndex()
    {
        library1.removeResourceByIndex(0);
    }

    @Test
    /**
     * Tests, whether a resource can be lended.
     * Physical2 is not available for leding, thus returns false.
     * physical1 is available for lending and can be lended, thus returns true
     */
    public void testLendingBook()
    {
        assertEquals(false, library1.lendingBook(physical2, member1));
        assertEquals(true, library1.lendingBook(physical1, member1));
    }

    @Test
    /**
     * Tests, if a book can be returned.
     * Returning a book means the member needs to be set to null. 
     * Thus will retrn null. 
    */
    public void testReturningBook()
    {
        assertEquals(null, library1.returningBook(physical2, false, "none"));
    }
}








