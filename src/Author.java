
/**
 * Information about the author of a resource (book, e-resource)
 * Shows the first and last name of the author and their address and prints these details.
 * Is used to add the author to a resource.
 *
 * @author (Anatasia Dandara)
 * @version (09.12.24)
 */
public class Author
{
    private String firstName;
    private String lastName;
    private String address; 

    /**
     * Constructor for objects of class Author
     * 
     * @param firstName, lastName  author's first & last name
     */
    public Author(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        address = "not set yet"; // indicates that it has not yet been edited 
    }

    /**
     * Returns author's first name
     */
    public String getFirstName()
    {
        return firstName;
    }
    
    /**
     * Returns author's last name
     */
    public String getLastName()
    {
        return lastName;
    }
    
    /**
     * Returns author's address
     */
    public String getAddress()
    {
        return address;
    }
    
    /**
     * In case of mistakes, first name can be changed here
     * 
     * @param firstName  enter the new first name
    */
    public void changeFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    /**
     * In case of mistakes, last name can be added here
     * 
     * @param lastName  enter the new last name
    */
    public void changeLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    /**
     * Method to set the author's address.
     * 
     * @param address  enter author's address
    */
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    /**
     * A method that prints details about the author, such as their first & last name and address.
     * Method checks whether fields are set.
    */
    public void printDetails()
    {
        if (firstName == null)
        {
            System.out.println("Author's first name is not given, please enter the author's first name first \n");
        }
        else
        {
            System.out.println("Author's first name: "+firstName+" ");
        }
        
        if (lastName == null)
        {
            System.out.println("Author's last name is not given, please enter the author's last name first \n");
        }
        else
        {
            System.out.println("Author's last name: "+lastName+" ");
        }
        
        if (address == null)
        {
            System.out.println("Author's address is not given, please enter author's address first");
        }
        else
        {
            System.out.println("Author's address: "+address+" ");
        }

    }
}


