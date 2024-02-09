import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

/**
 * The BookTest class contains unit tests for the Book class.
 * It tests the Book class's functionality, its constructor, getters, 
 * search attributes, unique identifier, and string representation.
 */

public class BookTest {
    private Book book;

    /**
     * Sets up a new book object before each test.
     * This method is executed before each test method, and sets up a book with sampled values.
     */

    @Before
    public void setUp() {
        book = new Book("1984", "George Orwell", "0451524934");
    }

    /**
     * Tests if the Book constructor throws an IllegalArgumentException when the author is null.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testBookConstructorWithNullAuthor() {
    new Book("1984", null, "0451524934");
    }

    /**
     * Tests if the Book constructor throws an IllegalArgumentException when the author is an empty string.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testBookConstructorWithEmptyAuthor() {
        new Book("1984", "", "0451524934");
    }

    /**
     * Tests if the Book constructor throws an IllegalArgumentException when the ISBN is null.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testBookConstructorWithNullISBN() {
        new Book("1984", "George Orwell", null);
    }

    /**
     * Tests if the Book constructor throws an IllegalArgumentException when the ISBN is an empty string.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testBookConstructorWithEmptyISBN() {
        new Book("1984", "George Orwell", "");
    }

    /**
     * Tests the constructor and getters of the Book class.
     * Verifies that the title, author, and ISBN of the book are correctly set and retrieved.
     */

    @Test
    public void testBookConstructorAndGetters() {
        Assert.assertEquals("Title should match", "1984", book.getTitle());
        Assert.assertEquals("Author should match", "George Orwell", book.getAuthor());
        Assert.assertEquals("ISBN should match", "0451524934", book.getISBN());
    }

    /**
     * Tests the getSearchableAttributes method of the Book class.
     * Verifies that the method returns a list containing the correct attributes for the search function.
     */

    @Test
    public void testGetSearchableAttributes() {
        List<String> expectedAttributes = Arrays.asList("1984", "george orwell", "0451524934");
        Assert.assertEquals("Searchable attributes should match", expectedAttributes, book.getSearchableAttributes());
    }

    /**
     * Tests the getUniqueIdentifier method of the Book class.
     * Verifies that the ISBN is used as the unique identifier for the book.
     */

    @Test
    public void testGetUniqueIdentifier() {
        Assert.assertEquals("Unique identifier should be ISBN", "0451524934", book.getUniqueIdentifier());
    }

    /**
     * Tests the toString method of the Book class.
     * Verifies that the method returns a string containing the book's title, status, author, and ISBN.
     */
    
    @Test
    public void testToString() {
        String expectedString = "Title: 1984, Status: available, Author: George Orwell, ISBN: 0451524934";
        Assert.assertEquals("String representation should match", expectedString, book.toString());
    }

}
