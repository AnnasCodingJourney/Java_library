

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ResourcesTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ResourcesTest
{
    private Author author1;
    private Resources resource1;
    private Author author2;
    private PhysicalBooks physical1;
    private EResources eResourc1;
    
    
    /**
     * Default constructor for test class ResourcesTest
     */
    public ResourcesTest()
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
        author1 = new Author("Dr.", "Who");
        resource1 = new Resources(author1, "The secrets of BlueJ");
        author2 = new Author("Micheal", "Jackson");
        physical1 = new PhysicalBooks(author2, "Welcome to java");
        eResourc1 = new EResources("Python vs Java", author2, true);
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
     * Tests if the resources are added succesfully to the list.
     * 3 resources are added, thus 3 shall be returned 
     */
    public void testGetSizeOfAllResources()
    {
        resource1.addResources(physical1);
        resource1.addResources(resource1);
        resource1.addResources(eResourc1);
        assertEquals(3, resource1.getSizeOfAllResources());
    }

    @Test
    /**
     * Tests if title is changed correctly by adding the new title and checking if the new tilte is in the 
     * same as what has been entered
     */
    public void testChangeTitle()
    {
        resource1.changeTitle("ABC");
        assertEquals("ABC", resource1.getResourceTitle());
    }
}


