

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class EResourcesTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class EResourcesTest
{
    private Author author1;
    private EResources eResourc1;
    private EResources eResourc2;
    private User user1;

    /**
     * Default constructor for test class EResourcesTest
     */
    public EResourcesTest()
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
        eResourc1 = new EResources("BlueJ", author1, true);
        eResourc2 = new EResources("BlueJ 2", author1, false);
        user1 = new User("An", "Na");
        eResourc1.downloadResources(eResourc1, user1);
        eResourc1.downloadResources(eResourc1, user1);
        eResourc1.noOfDownloads();
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
     * Tests if the number of downloads is getting updated after a resource is being downloaded.
     * eResource1 is downloaded 2, eResource2 is not being downloaded.
     */
    public void testGetNoDownloads()
    {
        assertEquals(2, eResourc1.noOfDownloads());
        assertEquals(0, eResourc2.noOfDownloads());
    }
    
    @Test
    /**
     * Tests if the download availability reflects what has been set.
     * eResource1 can be downloaded, thus true is expected.
     * eResource2 cannot be downloaded, thus false is expected 
     */
    public void testGetDownloadAvailability()
    {
        assertEquals(true, eResourc1.getDownloadAvailability());
        assertEquals(false, eResourc2.getDownloadAvailability());
    }
}



