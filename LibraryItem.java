import java.io.Serializable;
import java.util.List;

/**
 * The `LibraryItem` class serves as a parent class for items in the library such as books, DVDs, and CDs.
 */

public abstract class LibraryItem implements Serializable {
    private String title;
    private String status;
    private String borrowerName;
    private String borrowerContact;

    /**
     * Initializes a new instance of the `LibraryItem` class with the provided title.
     * The title cannot be null or empty, otherwise an IllegalArgumentException is thrown.
     *
     * @param title The title of the item. 
     * @throws IllegalArgumentException if the title is null or empty.

     */ 

    public LibraryItem(String title) {
        if (title == null || title.isEmpty()){
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = title;
        this.status = "available";
    }

    /**
     * Gets a list of attributes of the library item that should be used in the search function.
     * 
     * @return A list of searchable attribute strings.
     */
    public abstract List<String> getSearchableAttributes();


    /**
     * Retrieves the title of the item.
     *
     * @return The title of the item.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the unique identifier of the library item.
     * 
     * @return The unique identifier of the item.
     */
    public abstract String getUniqueIdentifier();
    

    /**
     * Retrieves the current status of the item (available or borrowed).
     *
     * @return The status of the item.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Borrows the item and sets borrower information.
     *
     * @param borrowerName    The name of the borrower.
     * @param borrowerContact The contact information of the borrower.
     */
    public void borrowItem(String borrowerName, String borrowerContact) {
        this.borrowerName = borrowerName;
        this.borrowerContact = borrowerContact;
        this.status = "borrowed";
    }

    /**
     * Returns the item, marking it as available. Clears the borrower's name and contact 
     * after item has been returned.
     *
     * @param borrowerName    The name of the borrower returning the item.
     * @param borrowerContact The contact information of the borrower returning the item.
     */
    public void returnItem(String identifier) {
        this.status = "available";
        this.borrowerName = "";
        this.borrowerContact = "";
    }

    /**
     * Retrieves the name of the borrower who has borrowed the item.
     *
     * @return The name of the borrower.
     */
    public String getBorrowerName() {
        return this.borrowerName;
    }

    /**
     * Retrieves the contact information of the borrower who has borrowed the item.
     *
     * @return The contact information of the borrower.
     */
    public String getBorrowerContact() {
        return this.borrowerContact;
    }
    
    /**
     * Creates a string representation of the item.
     * 
     * @return A string representation of the item.
     */
    @Override
    public String toString() {
        return "Title: " + title + ", Status: " + status;
    }
}
