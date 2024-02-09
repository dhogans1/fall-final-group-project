import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The `Library` class represents a collection of library items 
 * and provides methods for managing and interacting with them.
 */
public class Library implements Serializable {
    private List<LibraryItem> items;

    /**
     * Initializes a new instance of the `Library` class with an empty list of items.
     */

    public Library() {
        this.items = new ArrayList<>();
    }

    /**
     * Adds a new library item and throws an IllegalArgumentException is the item is null.
     *
     * @param item The library item to be added.
     * @throws IllegalArgumentException if the item is null.
     */

    public void addItem(LibraryItem item) {
        if (item == null){
            throw new IllegalArgumentException();
        }
        items.add(item);
    }

    /**
     * Searches for items in the library based on a search term that can match 
     * title or specific properties of items.
     *
     * @param searchTerm The search term to match against item titles or specific attributes.
     * @return A list of items that match the search term.
     */

    public List<LibraryItem> searchItems(String searchTerm) {
        List<LibraryItem> matchingItems = new ArrayList<>();
        String lowerCaseSearchTerm = searchTerm.toLowerCase();
    
        for (LibraryItem item : items) {
            for (String attribute : item.getSearchableAttributes()) {
                if (attribute.contains(lowerCaseSearchTerm)) {
                    matchingItems.add(item);
                    break; // Break to avoid adding the same item multiple times
                }
            }
        }
        return matchingItems;
    }

    /**
     * Retrieves an item from the library based on its unique identifier.
     *
     * @param identifier The unique identifier of the item to be retrieved.
     * @return The item with the specified identifier or null if not found.
     */

    public LibraryItem getItemByIdentifier(String identifier) {
        for (LibraryItem item : items) {
            if (item.getUniqueIdentifier().equals(identifier)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Borrows a library item based on its unique identifier.
     * Throws an IllegalArgumentException if identifier, borrowerName, or borrowerContact 
     * is null or empty.
     *
     * @param identifier The unique identifier of the item to be borrowed.
     * @param borrowerName The name of the person borrowing the item.
     * @param borrowerContact The contact information of the borrower.
     * @return true if the item was successfully borrowed, false otherwise.
     * @throws IllegalArgumentException if identifier, borrowerName, or borrowerContact is null or empty.
     */

    public boolean borrowItem(String identifier, String borrowerName, String borrowerContact) {
        if (identifier == null || identifier.isEmpty()){
            throw new IllegalArgumentException("Identifier cannot be null or empty");
        }
        if (borrowerName == null || borrowerName.isEmpty()){
            throw new IllegalArgumentException("Identifier cannot be null or empty");
        }
        if (borrowerContact == null || borrowerContact.isEmpty()){
            throw new IllegalArgumentException("Identifier cannot be null or empty");
        }

        LibraryItem item = getItemByIdentifier(identifier);
        if (item != null && "available".equals(item.getStatus())) {
            item.borrowItem(borrowerName, borrowerContact); // Assuming LibraryItem and its subclasses have a method borrowItem
            return true;
        }
        return false;
    }

    /**
     * Returns a library item based on its unique identifier.
     *
     * @param identifier The unique identifier of the item to be returned.
     * @return true if the item was successfully returned, false otherwise.
     * @throws IllegalArgumentException if identifier is null or empty.

     */

    public boolean returnItem(String identifier) {
        if (identifier == null || identifier.isEmpty()) {
            throw new IllegalArgumentException("Identifier cannot be null or empty");
        }

        LibraryItem item = getItemByIdentifier(identifier);
        if (item != null && "borrowed".equals(item.getStatus())) {
            item.returnItem(identifier); // Assuming LibraryItem and its subclasses have a method returnItem
            return true;
        }
        return false;
    }


    /**
     * Saves the list of library items to a file specified by the provided filename.
     * Throws IllegalArgumentException if the filename is null or empty.
     * IOException may be thrown during the file writing process.
     *
     * @param filename The name of the file to save the items to.
     * @throws IllegalArgumentException if the filename is null or empty.
     * @throws IOException if there is an error writing to the file.
     */

    public void saveToFile(String filename) throws IOException {
        if (filename == null || filename.isEmpty()) {
            throw new IllegalArgumentException("Filename cannot be null or empty");
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(items);
            System.out.println("Library items saved to file.");
        } catch (IOException e) {
            System.err.println("An error occurred while saving the library items to file: " + e.getMessage());
            throw e; // Rethrowing the exception to handle it at a higher level 
        }
    }

    /**
     * Loads the list of library items from a file specified by the provided filename.
     * Throws IllegalArgumentException if the filename is null or empty. 
     * IOException or ClassNotFoundException may be thrown during the file reading process.
     * 
     * @param filename The name of the file to load the items from.
     * @throws IllegalArgumentException if the filename is null or empty.
     * @throws FileNotFoundException if the file does not exist.
     * @throws IOException if there is an error reading from the file.
     * @throws ClassNotFoundException if the class of a serialized object cannot be found.
     */

    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        if (filename == null || filename.isEmpty()) {
            throw new IllegalArgumentException("Filename cannot be null or empty");
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            items = (List<LibraryItem>) in.readObject();
            System.out.println("Library items loaded from file.");
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            throw e;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("An error occurred while loading the library items from file: " + e.getMessage());
            throw e;
        }
    }
}
