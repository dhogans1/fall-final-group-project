import java.util.Arrays;
import java.util.List;

/**
 * The `Book` class represents a book in the library and extends the `LibraryItem` class.
 * It includes properties specific to this class such as author and ISBN.
 */

public class Book extends LibraryItem {
    private String author;
    private String ISBN;

    /**
     * Initializes a new instance of the `Book` class with the title, author, and ISBN.
     * The author and ISBN cannot be null or empty, otherwise an IllegalArgumentException 
     * is thrown.
     *
     * @param title  The title of the book.
     * @param author The author of the book.
     * @param ISBN   The ISBN (International Standard Book Number) of the book.
     * @throws IllegalArgumentException if the author or ISBN is null or empty.
     */

    public Book(String title, String author, String ISBN) {

        super(title); // Call the constructor of the LibraryItem class

        if (author == null || author.isEmpty()){
            throw new IllegalArgumentException("Author cannot be null or empty");
        }
        this.author = author;

        if (ISBN == null || ISBN.isEmpty()){
            throw new IllegalArgumentException("ISBN cannot be null or empty");
        }
        this.ISBN = ISBN;
    }

    /**
     * Retrieves the author of the book.
     *
     * @return The author of the book.
     */

    public String getAuthor() {
        return author;
    }

    /**
     * Retrieves the ISBN of the book.
     *
     * @return The ISBN of the book.
     */

    public String getISBN() {
        return ISBN;
    }

    /**
     * Gets a list of attributes of the book that should be used in the search function.
     * Includes the title, author, and ISBN. This allows the class to be searched
     * using these attributes.
     * 
     * @return A list of searchable attribute strings.
     */

    @Override
    public List<String> getSearchableAttributes() {
        return Arrays.asList(getTitle().toLowerCase(), getAuthor().toLowerCase(), getISBN());
    }

    /**
     * Retrieves the unique identifier for the book.
     * The unique identifier is the book's ISBN.
     * 
     * @return The ISBN of the book i.e. the unique identifier.
     */

    @Override
    public String getUniqueIdentifier() {
        return ISBN;
    }

    /**
     * Generates a string representation of the book.
     *
     * @return A string representation of the book.
     */

    @Override
    public String toString() {
        return super.toString() + ", Author: " + author + ", ISBN: " + ISBN;
    }
}
