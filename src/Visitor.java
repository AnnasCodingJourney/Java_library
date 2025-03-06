import java.util.ArrayList;

/**
 * This is a subclass of the superclass User.
 * Visitors cannot borrow books, they can access e-resources while they are in the library.
 * Futhermore, they can only access the library 3 days/ month.
 * This class contains the information of a visitor, such as the number of current & remaining visits, their id, 
 * and first and last name.
 * (This class was created to fulfil the inheritance requirement.)
 *
 * @author (Anastasia Dandara)
 * @version (13.12.24)
 */
public class Visitor extends User
{
    private int maxDuration; // The maximal duration (3 days/month)
    private int currentVisits; // How often they have visited the library already
    private String visitorFirstName;
    private String visitorLastName;
    private int visitorId;
    private int remainingVisits; // How many times they can still visit the library in this month

    /**
     * Constructor for objects of class Visitor
     * 
     * @param firstName, lastName  visitor's first and last name
     * 
     */
    public Visitor(String firstName, String lastName)
    {
        super(firstName, lastName);
        maxDuration = 3; // set to 3 days as this is the maximum duration they can visit the library
        currentVisits = 0; // 0 as they have not yet access the library
        visitorFirstName = firstName;
        visitorLastName = lastName;
        visitorId = id;
    }
    
    /**
     * Returns the number of current visits, which is set in the method bellow "noOfVisits"
     */
    public int getNoOfVisits()
    {
         return currentVisits;   
    }
    
    /**
     * Returns the remaining number of visits, which is calculated & updated in the method bellow "noOfVisits"
     */
    public int getRemainingVisits()
    {
        return remainingVisits;
    }

    /**
     * Method that makes sure the maximum of 3 days is not exceeded.
     * Furthermore, the remaining visits are calculated by substracting the current visits from the maximum duration.
     * 
     * @param currentVisits  corresponds to the number of visits that have already taken place by the visitor.
     * 
     * @return false  if a duration is entered that is over the maximum (3 days). Error message is printed. 
     * true  currentVisits is accepted and updated, the method prints a confirmation.
     * 
     */
    public boolean noOfVisits(int currentVisits)
    {
        if (currentVisits > maxDuration)
        {
            System.out.println("The maximum duration of 3 days is reached and cannot be exceeded \n");
            return false;
        }
        else
        {
            System.out.println("Current visits have been updated \n");
            this.currentVisits = currentVisits; // update current visits
            remainingVisits = maxDuration - currentVisits; // update remaining visits
            return true;
        }
    }
    
    @Override
    /**
     * This method redifines the "printDetails" method in the superclass (User).
     * It calls the superclass method by using super and adds the details of the current number of visits
     * and the remaining number of visits of the visitor, which is specific to the subclass.
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Number of current visits:" +getNoOfVisits()+" "); // calls getter method for number of current visits
        System.out.println("Remaining visits: "+getRemainingVisits()+ "\n"); // calls getter method for number of remaining visits
    }
}
