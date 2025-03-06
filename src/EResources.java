
/**
 * This class represents an electronic resource, such as e-books, electronic journals etc.
 * They can be downloaded by users, if they are available for downloading.
 * Title, and author can be accessed and set through the superclass Resources.
 * This class contains information of the download availability of the resource and the number of downloads.
 * (This class was created to fulfil the inheritance requirement.)
 *
 * @author (Anastasia Dandara)
 * @version (09.12.24)
 */
public class EResources extends Resources
{
    private String eResourceTitle;
    private Author eResourceAuthor;
    private boolean download; //indicates whether the e-resource can be downloaded
    private int noOfDownloads; // indicates how often the e-resource was downloaded
    private int eResourceIsbn; //e-books can contain isbn 
    

    /**
     * Constructor for objects of class EResources.
     * 
     * @param author,resourceTitle,download    This is the author of the e-resource and the tilte of the e-resource,
     * and the download availability (true, if it can be downloaded; false, if not)
     */
    public EResources(String resourceTitle, Author author, boolean download)
    {
        super(author, resourceTitle); //calls the superclass constructor 
        eResourceTitle = resourceTitle;
        eResourceAuthor = author;
        this.download = download; //true indicates that download is available, false means that the resource cannot be downloaded
        noOfDownloads = 0; // at first, the number of downloads is 0, as no downloads have yet occured
        eResourceIsbn = isbn;
    }

    /**
     * Returns whether a download is available. 
     * True means it can be downloaded and false indicates that the download is not available.
     */
    public boolean getDownloadAvailability()
    {
        return download; 
    }
    
    /**
     * changes whether a download is available. 
     * 
     * @param download  new dowload availability
     * True means it can be downloaded and false indicates that the download is not available.
     */
    public void changeDownload(boolean download)
    {
        this.download = download;
    }
    
    /**
     * A method that allows a user to download e-resources, when they are available for download.
     * Method checks whether the download is supported. If it is, the number of downloads increases by 1.
     * If it is not available for download, an error message is printed.
     * 
     * @param eResource, user  which eResource is downloaded and by whom
     * 
     */
    public void downloadResources(EResources eResource, User user)
    {
         if(eResource.getDownloadAvailability() == true)
         {
             System.out.println("Successfully downloaded \n");
             noOfDownloads +=1; //updates the number of downloads
         }
         else
         {
             System.out.println("This e-resource is currently not available for download.\n");
         }
    }
    
    /**
     * A method that shows how often an e-resource has been downlaoded. 
     * This number is updated in the previous method "downloadResources".
     * If there are no downlaods, it will return 0, otherwise will return the number of downloads.
     */
    public int noOfDownloads()
    {
        if(noOfDownloads == 0)
        {
            System.out.println("E-resource has not yet been downloaded \n");
            return 0;
        }
        else
        {
            System.out.println("Number of downlods: "+noOfDownloads+"\n");
            return noOfDownloads;
        }
    }

    @Override
    /**
     * A method that redifines the printing details, by calling the superclass method and adding details specific to the subclass, 
     * such as the download availability and the number of downloads.
     */
    public void printDetails()
    {
        super.printDetails(); //calls the method of the superclass
        if (download == true)
        {
            System.out.println("This resource is available for download \n");
        }
        else
        {
            System.out.println("This resource is not available for download \n");
        }
        System.out.println("The number of downloads: "+noOfDownloads()+"\n ");
    }
}
