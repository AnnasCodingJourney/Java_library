import java.util.ArrayList;

/**
 * This is a subclass of the superclass User.
 * Members have full access to resources (EResources, PhysicalBooks).
 * They can lend and return books and access eResources. 
 * This class contains the information of a member, such as a list of their borrowed books, their id, 
 * and first and last name.
 * (This class was created to fulfil the inheritance requirement.)
 * 
 * @author (Anastasia Dandara)
 * @version (10.12.24)
 */
public class Member extends User
{
    private ArrayList<PhysicalBooks> borrowedBooks; // list that stores currently borrowed books by a member 
    private String memberFirstName;
    private String memberLastName;
    private int memberId; // Must be 6 digits long
    
    /**
     * Constructor for objects of class Member.
     * Calls the constructor in the superclass.
     * 
     * @param firstName, lastName  member's first and last name
     *
     */
    public Member(String firstName, String lastName)
    {
        super(firstName, lastName); // call the constructor of the superclass
        memberFirstName = firstName;
        memberLastName = lastName;
        memberId = id;
        borrowedBooks = new ArrayList<>();
    }
    
    /**
     * Method that returns the array list of borrowed books by the member
     */
    public ArrayList getBorrowedBooks()
    {
        return borrowedBooks;
    }
    
    /**
     * Method that appends borrowed books to the list.
     * If book is set to null, it cannot be added and an error message appears.
     * Otherwise, the book is added to the list with a confirmation message.
     * 
     * @param book  this corresponds to the book that the member borrows
     * 
     */
    public void setBorrowedBooks(PhysicalBooks book)
    {
        if(book == null)
        {
            System.out.println("Null cannot be added \n");
        }
        else if (borrowedBooks.contains(book)) 
        {
            System.out.println("This book is already added \n");
        }
        else
        {
            borrowedBooks.add(book);
        }
    }
    
    /**
     * Method that prints current books borrowed by the member by iterating through the list.
     * Method checks whether the array list is empty and prints an error message. 
     */
    public void printBorrowedBooks()
    {
        if (borrowedBooks.isEmpty())
        
        {
            System.out.println("There currently are no borrowed books \n");
        }
            else
            {
                for (PhysicalBooks book : borrowedBooks)
                {
                    System.out.println("Information about currently borrowed books: \n");
                    book.printDetails();
                }
            }
    }
    
    /**
     * Method that returns the number of books currently borrowed by the member.
     * If the array list is empty, the method prints an appropriate message.
     */
    public int numberOfBorrowedBooks()
    {
        if (borrowedBooks.isEmpty())
        {
            System.out.println("There currently are no borrowed books \n");
        }
        return(borrowedBooks.size());
    }
    
    @Override
    /**
     * This method redifines the "printDetails" method in the superclass (User).
     * It calls the superclass method by using super and adds the details of the borrowed books 
     * to the print statement, which is specific to the subclass.
     * Method checks whether the list is empty first.
     */
    public void printDetails()
    {
        super.printDetails();
        if (borrowedBooks.isEmpty())
        {
            System.out.println("There currently are no borrowed books");
        }
        else
        {
            System.out.println("These books are currently borrowed: \n");
            for (PhysicalBooks book : borrowedBooks)
            {
                book.printDetails();
            }
        }
    }
}
