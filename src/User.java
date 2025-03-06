
/**
 * This class represents a user and is a superclass to visitor and member.
 * It allows first names, last names and ids to be set and accessed, which are relevant to 
 * both members and visitors. 
 * Futhermore, this information can be printed and overriden in the subclasses.
 * Users can access Resources (Physical books or eResources).
 * Depending on whether a user is a visitor or a member, additional and specific methods and fields
 * are described in these subclasses.
 * (This class was created to fulfil the inheritance requirement.)
 *
 * @author (Anastasia Dandara)
 * @version (10.12.24)
 */
public class User
{
    protected int id; // describes the user id, unique to every user, must be 6 digits long
    protected String firstName; 
    protected String lastName;
    
    /**
     * Constructor for objects of class User.
     * 
     * @param firstName, lastName    The user's first and last name.
     *  
     * Since id is unique, an option would have been to use id as a second constructor. 
     * However, since the id must be 6 digits long, this condition can more easily be checked in the setter method, 
     * rather than in a constructor.
     */
    public User(String firstName, String lastName)
    {
        this.firstName = firstName; // user's first name
        this.lastName = lastName; // user's last name
        id = id;
    }

    /**
     * Method to return the user's id
     */
    public int getId()
    {
        return id; // unique to each user
    }
    
    /**
     * Method to return the user's first name
     */
    public String getFirstName()
    {
        return firstName;
    }
    
    /**
     * Method to return the user's last name
     */
    public String getLastName()
    {
        return lastName;
    }
    
    /**
     * Method to set the id.
     * 
     * @param user's id   The user's unique id.
     * 
     * @return false: if Id is not set successfully. Id needs to be set with 6 digits. Error message printed.
     * true: If Id is set correctly (6 digits). Confirmation message printed.
     */
    public boolean setId(int id)
    {
        if (String.valueOf(id).length() != 6)
        {
            System.out.print("Id must be 6 characters long!");
            return false;
        }
        else
        {
            System.out.println("Id has been updated successfully.");
            this.id = id;
            return true;
        }
    }
    
    /**
     * This method allows you to change a first name, in case a type error has occured.
     *
     *@param firstName  the updated first name
     */
    public void changeFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    /**
     * This method allows you to change a last name. Can be neccessary in case of marrige or type error.
     * 
     * @param lastName  the updated last name
     */
    public void changeLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    /**
     * A method printing the details of users. (can be overriden in subclasses)
     * It checks if values are set to null/0 and prints appropriate messages. 
     * If details are set correctly: the user's Id, first name and last name are printed, 
     * by accessing the getter methods.
     */
    public void printDetails()
    {
        if (id == 0)
        {
            System.out.println("Id is not defined" + "\n");
        }
        else
        {
            System.out.println("Id Information: "+getId()+ "\n");
        }
        if (firstName == null)
        {
            System.out.println("The first name is not entered. Please enter the first name.");
        }
        else
        {
            System.out.println("First name: "+getFirstName()+" ");
        }
        if (lastName == null)
        {
            System.out.println("The last name is not entered. Please enter the last name.");
        }
        else
        {
            System.out.println("Last name: "+getLastName()+ "\n");
        }
    }
}
