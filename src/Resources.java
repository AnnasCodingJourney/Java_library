import java.util.ArrayList;

/**
 * This class represents resources and is a superclass to Eresources and PhysicalBooks.
 * It allows title, author and isbn to be set and accessed through this class and the corresponding subclasses.
 * Futhermore, this information can be printed and overriden in the subclasses.
 * Resources can either be downloaded, if they are e-resources or borrowed, if they are physical books.
 * (This class was created to fulfil the inheritance requirement.)
 *
 * @author (Anastasia Dandara)
 * @version (10.12.24)
 */
public class Resources
{
    protected String resourceTitle; // protected, thus can be accessed by subclasses
    protected int isbn;
    protected Author author;
    protected ArrayList<Resources> allResources; // list of all the resources (books, eResources)
    
    /**
     * Constructor for objects of class Resources.
     * 
     * @param author, resourceTitle    This is the author of the resource and the tilte of the resource.
     *  
     * Sometimes the author might not be given, thus initially 2 constructors were created.
     * However, this lead to issues in the library class when casting was used. 
     * Thus, was changed to a single constructor to proparly initialise the class and avoid null pointer exceptions.
     */
    public Resources(Author author, String resourceTitle)
    {
        this.author = author;
        this.isbn = 0; // indicates it has not been set yet
        allResources = new ArrayList<>(); //list with all resources 
        this.resourceTitle = resourceTitle;
    }
    
    /**
     * Method to return the tilte of the resource
     */
    public String getResourceTitle()
    {
        return resourceTitle;
    }
    
    /**
     * Method to return the author of a resource
     */
    public Author getAuthor()
    {
        return author;
    }
    
    /**
     * Methed to return the size of the array list (the number of resources that are in the list)
     */
    public int getSizeOfAllResources()
    {
        return allResources.size(); 
    }
    
    /**
     * Methed to return the isbn of a resource
     */
    public int getIsbn()
    {
        return isbn;
    }
    
    /**
     * A method that returns all resources that have been added to the ArrayList. (Resources can be phyiscal books or e-ressources)
     */
    public ArrayList getAllResources()
    {
        return allResources;
    }
    
    /**
     * A method that allows the isbn to be set 
     */
    public void setISBN(int isbn)
    {
        this.isbn = isbn;
    }
    
    /**
     * A method that allows the title to be changed, in case of an error
     * 
     * @param resourceTitle  new title
     */
    public void changeTitle(String resourceTitle)
    {
        this.resourceTitle = resourceTitle;
    }
    
    /**
     * A method that allows the author to be changed, in case of an error
     * 
     * @param author  new author
     */
    public void changeAuthor(Author author)
    {
        this.author = author;
    }

    /**
     * A method to add ressources(physical books, e-resources) to the array list "allResources"
     * 
     * @param resource  resource that is added to the array list
     */
    public void addResources(Resources resource)
    {
        allResources.add(resource);
    }
    
    /**
     * A method printing the details of physical books or e-resources, such as the 
     * isbn, title, author.
     * Checks if field are set or if they contain null or 0.
     */
    public void printDetails()
    {
        if (isbn == 0)
        {
            System.out.println("Isbn Number is not defined \n");
        }
        else
        {
            System.out.println("ISBN: "+getIsbn()+ "\n");
        }
        if (resourceTitle == "not set yet")
        {
            System.out.println("The tilte is not set, please enter the title \n");
        }
        else
        {
            System.out.println("Title: "+getResourceTitle()+ "\n");
        }
        if (author == null)
        {
            System.out.println("Author not given, please enter the author first \n");
        }
        else
        {
            System.out.println("Author: "+author.getFirstName()+" ");
            System.out.println("Author: "+author.getLastName()+" ");
            System.out.println("Author: "+author.getAddress()+"\n");
        }
    }
}
