import java.util.ArrayList;

/**
 * This class represents physical book, that can be borrowed and returned by a member.
 * This is a subclass of the superclass Resources.
 * Title, author and isbn are defined in the superclass and can be accessed and set in the subclass.
 * Additionally, a list of demaged books can be set and accessed in this class, and if a book is borrowed
 * a member can be set.
 * (This class was created to fulfil the inheritance requirement.)
 *
 * @author (Anastasia Dandara)
 * @version (07.12.24)
 */
public class PhysicalBooks extends Resources
{
    private Member member; // the member who borrows the book
    private String bookTitle;
    private Author bookAuthor;
    private int bookIsbn;
    private ArrayList<PhysicalBooks> demagedBooks; // list of demaged books
    
    /**
     * Constructor for objects of class PhysicalBooks.
     * 
     * @param author,resourceTitle   This is the author of the book and the tilte of the book
     */
    public PhysicalBooks(Author author, String resourceTitle)
    {
        super(author,resourceTitle); //call to superclass constructor
        bookTitle = resourceTitle;
        bookAuthor = author;
        bookIsbn = isbn;
        member = member; 
        demagedBooks = new ArrayList<>(); 
    }
    
    /**
     * returns the member who borrows the book    
    */
    public Member getMember()
    {
        return member;
    }
    
    /**
     * returns the list of demaged books 
    */
    public ArrayList getDemagedBooks()
    {
        return demagedBooks;
    }
    
    /**
     * returns the number of demaged books in the list
    */
    public int getSizeDemagedBooks()
    {
        return demagedBooks.size();
    }
    
     public void setMember(Member member)
    {
        this.member = member; // member who borrows the book
    }
    
    /**
     * A method that sets the list of demaged books.
     * If the book is null an error message is printed, 
     * If the book is already in the list a message is printed,
     * else the book is added.
     * 
     * @param book  the demaged book that shall be added 
     * 
     */
    public void setDemagedBooks(PhysicalBooks book)
    {
        if (book == null)
        {
            System.out.println("Error: null cannot be added to demaged books!");
        }
        else if (demagedBooks.contains(book))
        {
            System.out.println("Error: book is already in the demaged books list");
        }
        else
        {
            System.out.println("Book has been successfully added to the list of demaged books");
            demagedBooks.add(book);
        }
    }
    
    /**
     * A method that checks the availability of the book and returns true if the member field is null, otherwise returns false
     */
    public boolean bookAvailability()
    {
        if (member == null)
        {
            System.out.println("This book is available");
            return true;
        }
        else
        {
            System.out.println("Sorry, but this book is currently not available.");
            return false;
        }
    }
    
    /**
     *  A method that prints details of the book.
     *  This method is already defined in the superclass and overriden here, adding book specific details,
     *  such as the list of demaged books, if books are in the list, and the member details if a member is set.
    */
    @Override
    public void printDetails()
    {
        super.printDetails();
        if (member == null)
        {
            System.out.println("There is no member currently borrowing this book");
        }
        else
        {
            System.out.println("Member currently having the book: "+member+" ");
        }
        if (demagedBooks.isEmpty())
        {
            System.out.println("There currently are no demaged books");
        }
        else
        {
            for (PhysicalBooks book : demagedBooks)
            {
                System.out.println("Information about demaged books: \n");
                if(isbn == 0)
                { 
                    System.out.println("ISBN is not set, please update. \n");
                }
                else
                {
                System.out.println("ISBN: "+getIsbn()+"\n");
                }
                if(resourceTitle == null)
                {
                    System.out.println("Title is not set. Please update.\n");
                }
                else
                {
                System.out.println("Book title: "+book.getResourceTitle()+"\n");
                }
                if(author == null)
                {
                    System.out.println("Author is not set. Please update.\n");
                }
                else
                {
                    System.out.println("Author: \n");
                    book.author.printDetails();
                }
            }
        }
    }
}
