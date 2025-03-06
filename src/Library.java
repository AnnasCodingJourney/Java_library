import java.util.ArrayList;

/**
 * This class represents the Library.
 * It contains a catalogue of all resources in the library (books, eResources).
 * Furthermore, information about the library can be viewed, such as opening hours and membership information. 
 * Various searching methods are available that allow to search for a resource in the catalogue. 
 * Resources can be added and removed from the catalogue.
 * Information to the resources can be accessed. 
 * It also allows a member to lend and return a book.
 *
 * @author (Anastasia Dandara)
 * @version (13.12.24)
 */
public class Library
{
    private ArrayList<Resources> libraryCatalogue; // list that stores all the resources (physical books & e-resources)
    private int matchingResult; // supporting variable used to return number of matches in search methods below
    private Resources removingResource; // supporting variable, adds structure to "removeResourceByIndex" method 

    /**
     * Constructor for objects of class Library
     */
    public Library()
    {
        libraryCatalogue = new ArrayList<>();
    }

    /**
     * Returns the catalogue/list of resources 
     */
    public ArrayList getLibraryCatalogue()
    {
        return libraryCatalogue;
    }
    
    /**
     * A method that prints the details of the library, such as opening hours, the library catalogue, membership information
     */
    public void printDetails()
    {
        System.out.println("OPENING HOURS: \n");
        System.out.println("The library is open Mo-Sa from 9am-5pm");
        System.out.println("During exam session(01.12 - 20.12) the library extends opening hours:");
        System.out.println("Mo-Sa, 8am-8pm, additionally open on Sundays 9am-6pm");
        System.out.println("Here you can find our library catalogue with all available resources: \n");
        if (libraryCatalogue.size() == 0)
        {
            System.out.println("Unfortunately, there are no resources available. Add resources to the catalogue and check again.\n");
        }
        else
        {
        for (Resources resource : libraryCatalogue)
        {
            resource.printDetails();
        }
        }
        System.out.println("Here our membership information:\n");
        System.out.println("Users can become members for 30£/month.");
        System.out.println("Students of the University of Strathclyde are exempted and can access for free");
        System.out.println("Users can decide to access the library as visitors for free with limited access to resources.");
        System.out.println("In this case, only e-resources can be accessed during the library visit. Visits are limited to 3 days/month");
    }
    
    /**
     * A method that allows you to look for a resource within the library catalogue.
     * 
     * @param searchResource  Enter the resource you are looking for 
     * @Return  true: if there is a match and the resource you look for is in the catalogue.
     *          false: if there is no match
     */
    public boolean findResourceByResource(Resources searchResource)
    {
        if (libraryCatalogue.contains(searchResource))
        {
            System.out.println("The resource is available \n");
            return true;
        }
        else
        {
            System.out.println("Sorry, no match was found. The resource you entered is not in the catalogue at this moment.\n");
            return false;
        }
    }
    
    /**
     * A method that allows you to edit the author's first name of a resource in the library catalogue
     * If the resource you want to edit (editResource) is not in the catalogue and if the author's name is null,
     * an error message appears.
     * Otherwise, the author's first name is updated and a confirmation message appears.
     * 
     * @param editResource, newFirstName  enter the resource of which you would like to change the author's first name & the new first name
     * 
     */
    public void editAuthorsName(Resources editResource, String newFirstName)
    {
        if (! libraryCatalogue.contains(editResource))
        {
            System.out.println("You cannot edit the resource you entered, as it is not in the catalogue.\n");
        }
        else 
        {
            if(editResource.getAuthor() == null)
            {
                System.out.println("Authors first name is not set and cannot be changed \n");
            }
            else
            {
                System.out.println("The author's first name has been successfully edited to "+newFirstName+" \n");
                editResource.author.changeFirstName(newFirstName);
            }
        }
    }
    
    /**
     * A method that allows you to look for a resource within the library catalogue by entering 
     * the resource tilte you want to look for. (uppercase and lowercase are ignored)
     * If there is a match, the details are printed out. 
     * Else, an error message is printed. 
     * 
     * @param title  enter the title you are searching for
     * 
     * @return matchingResult  number of matches found
     * 
     */
    public int findResourceByTitle(String title)
    {
        matchingResult = 0;
        for (Resources resource : libraryCatalogue)
        {
        if (! title.equalsIgnoreCase(resource.resourceTitle))
        {
            continue;
        }
        else
        {
            matchingResult += 1; //updates number of matching results 
            resource.printDetails();
        }
        }
        System.out.println("The amount of results that match your searching title are: "+matchingResult+"\n");
        return matchingResult; // returns how many matches were found 
    }
    
    /**
     * A method that allows you to look for a resource within the library catalogue by entering 
     * the author's last name.
     * If the last name is null an error message is printed.
     * If the catalogue contains a resource with an author that corresponds to the surname searched for,
     * the details of this resource are printed.
     * 
     * @param authorSurname  enter the author's last name you are looking for 
     * 
     * @return matchingResult  the number of matches found
     * 
     */
    public int findResourceBySurname(String authorSurname)
    {
        matchingResult = 0;
        for (Resources resource : libraryCatalogue)
        {
        if (! authorSurname.equalsIgnoreCase(resource.author.getLastName()))
        {
            continue;
        }
        else
        {
            resource.printDetails();
            matchingResult += 1; //updates number of matches found
        }
        }
        System.out.println("The amount of results that match your searching title are: "+matchingResult+"\n");
        return matchingResult;
    }
    
    /**
     * A method that allows you to remove a resource and checks its availability. 
     * 
     * @param removeResource  the resource you want to remove
     * 
     * 1) it checks whether the resource is in the list
     * 2) if in the list it checks the 3 different resource types:
     * a) it can be a resource of type resource, in this case it removes it from the list and prints a message
     * b) it can be a resource of type physical book, in this case the resource entered is cast on to a physical book. 
     * This is required to be able to check the availability of the book by accessing the method in physical books.
     * c) it can be a resource of type e-resource, in this case "removeResource" needs to be cast on to an E-Resource.
     * This is required to be able to access the download availability in the subclass EResources.
     * 3) Else (resource not in the list), an error message is printed
     * 
     * Casting shall be avoided in generall, 
     * but I felt it was required here to be able to check availabiity, which is defined in subclasses.
     */
    public void removeResourceByResource(Resources removeResource)
    {
        if (libraryCatalogue.contains(removeResource))
        {
            if (removeResource instanceof Resources)
            {
                System.out.println("Resource has been successfully removed \n");
                libraryCatalogue.remove(removeResource);
            }
            if (removeResource instanceof PhysicalBooks && ((PhysicalBooks)removeResource).bookAvailability())
            {
                System.out.println("Book has been successfully removed \n");
                libraryCatalogue.remove(removeResource); 
            }
            else if (removeResource instanceof EResources && ((EResources)removeResource).getDownloadAvailability())
            {
                System.out.println("E-Resource has been successfully removed \n");
                libraryCatalogue.remove(removeResource);
            }
        }
        else
        {
            System.out.println("Sorry the resource is not available or is not in the list.\n");
        }
    }
    
    /**
     * A method that allows you to remove a resource in a specific position within the catalogue and checks its availability.
     * 
     * @param position  enter the position you want to remove
     * 
     * 1) It checks whether the position entered is positive and within the range of the size of the list
     * 2) If a valid number is entered, the object in the array list in this position is stored in a variable (removingResource)
     * This makes the code a bit easier to understand and to implement. 
     * 3) It checks whether removingResource is an instance of Resources, if so it removes the object and prints a message
     * 4) If the removingResource is an instance of a physical book, it accesses the book's availability through casting.
     * 5) If the removingResource is an instance of e-resource, it access the resource's download availability through casting.
     * 
     * Casting shall be avoided in generall, 
     * but I felt it was required here to be able to check availabiity, which is defined in subclasses.
     */
    public void removeResourceByIndex(int position)
    {
        if (libraryCatalogue.size() < position && position < 0)
        {
            System.out.println("Please enter a positive number in the range of "+libraryCatalogue.size()+"/n");
        }
        else
        {   removingResource = libraryCatalogue.get(position); // storage purposes & structure
            if (removingResource instanceof Resources)
             {
                System.out.println("Resource has been successfully removed \n");
                libraryCatalogue.remove(removingResource);
            }
            if (removingResource instanceof PhysicalBooks && ((PhysicalBooks)removingResource).bookAvailability())
            {
                System.out.println("Book has been successfully removed \n");
                libraryCatalogue.remove(removingResource); 
            }
            else if (removingResource instanceof EResources && ((EResources)removingResource).getDownloadAvailability())
            {
                System.out.println("E-Resource has been successfully removed \n");
                libraryCatalogue.remove(removingResource);
            }
        }
    }
    
    /**
     * A method that prints the details of all available books that are in the library catalogue.
     * 
     * 1) Iterates through the catalogue and checks what instance the resouce is, i.e resource, e-resource, physical book.
     * 2) Casting is used to access availability.
     * 
     * Since availability is only declared in the subclasses, it felt approrpiate to cast the superclass object
     * on subclass objects to access their availability.
     * Casting should be generally avoided, but felt necessary in this situation.
     */
    public void printResourceDetails()
    {
        for(Resources resource : libraryCatalogue)
        {
            if (resource instanceof Resources)
            {
                resource.printDetails();
            }
            else if (resource instanceof PhysicalBooks && ((PhysicalBooks)resource).bookAvailability())
            {
                resource.printDetails();
            }
            else if (resource instanceof EResources && ((EResources)resource).getDownloadAvailability())
            {
                resource.printDetails();
            }
        }
    }
    
    /**
     * A method that prints the number of resources in the library catalogue.
     */
    public int getNumberOfResources()
    {
        return libraryCatalogue.size();
    }
    
    /**
     * Method that allows resources to be added the library catalogue.
     * If resource is already in the list, an error message is printed.
     * 
     * @param resource  the resource that shall be added 
     * 
     */
    public void setLibraryCatalogue(Resources resource)
    {
        if (libraryCatalogue.contains(resource))
        {
            System.out.println("Cannot be added, since resource is already in the list.\n");
        }
        else
        {
            System.out.println("Resource has been successfully added to the catalogue \n");
            libraryCatalogue.add(resource);
        }
    }
    
    /**
     * Method simulating a book has been lended. 
     * If the book is not in the catalogue or not available, an error message is printed.
     * If the book is available, the member is set in the book object to illustrate the book is lended 
     * by this member. 
     * In the member object the book is added to the borrowed books.
     * 
     * @param book, member  book that is lended and the member who lends the book.
     * 
     * @return  false, if the book cannot be lended
     *          true: if the book was successfully borrowed 
     */
    public boolean lendingBook(PhysicalBooks book,Member member)
    {
        if(! libraryCatalogue.contains(book) || book.bookAvailability()==false)
        {
            System.out.println("This book cannot be lended at the moment \n");
            return false;
        }
        else
        {
            System.out.println("Book successfully lended \n");
            book.setMember(member); // means the book is not available anymore
            member.setBorrowedBooks(book); //add book to list of borrowed books 
            return true;
        }
    }
    
    /**
     * Method simulating returning a book.
     * 
     * @param book, demage, demageDescription   the book that is beeing returned, a boolean to indicate whether the book is demaged
     * and a description of the demage.
     * 
     * The demaged book is added to the demagedBooks list in the PhysicalBooks class.
     */
    public Member returningBook(PhysicalBooks book, boolean demage, String demageDescription)
    {
        if (! libraryCatalogue.contains(book))
        {
            System.out.println("Sorry the book is not in the catalogue \n");
        }
        else if (demage == true)
        {
            System.out.println("Book has been added to the list of demaged books \n");
            book.setDemagedBooks(book); // add book to demaged books 
        }
        book.setMember(null); // indicates that the book is again available for lending 
        return book.getMember(); // for testing purposes the member should be null
    }
    
    /**
     * Method to print details of physical book.
     * 
     * Checks if a resource in the library catalogue is a physical book.
     * If it is, then the print details method of the object is called.
     * To access this method, the resource was cast to a physical book object. 
     * Casting shall be avoided in general, but felt necessary here, for enabling access to 
     * the books print details method.
     */
    public void printDetailsOfBooks()
    {
        for (Resources resource : libraryCatalogue)
        {
            if (resource instanceof PhysicalBooks)
            {
                ((PhysicalBooks)resource).printDetails();
            }
        }
    }
    
    /**
     * Method to print details of an e-resource in the catalogue.
     * 
     * Checks if a resource in the library catalogue is an instance of EResources.
     * If it is, then the print details method of the object is called.
     * In order to access this method, the resource was cast to an an e-resource object. 
     * Casting shall be avoided in general, but felt necessary here, for enabling access to 
     * the e-resources print details method.
     */
    public void printDetailsOfEResource()
    {
        for (Resources resource : libraryCatalogue)
        {
            if (resource instanceof EResources)
            {
                ((EResources)resource).printDetails();
            }
        }
    }
}


