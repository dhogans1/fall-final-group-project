import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * The LibraryTest class contains unit tests for the Library class.
 * It tests the Library class's methods for adding items, searching, borrowing,
 * returning, and file operations.
 */


public class LibraryTest {
    private Library library;

    /**
     * Sets up a library with some sample items before each test.
     * This method is executed before each test method and initializes the library
     * with a set of items.
     */ 
    
    @Before
    public void setUp() {
        library = new Library();
        // Add some sample items
        library.addItem(new Book("The Catcher in the Rye", "J.D. Salinger", "0316769177"));
        library.addItem(new DVD("Inception", "Sci-Fi", "Christopher Nolan"));
        library.addItem(new CD("Thriller", "Michael Jackson", "Pop"));
    }

    /**
     * Tests if adding a null item to the library throws an IllegalArgumentException.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullItem() {
        library.addItem(null);
    }

    /**
     * Tests if borrowing an item with a null identifier throws an IllegalArgumentException.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testBorrowItemWithNullIdentifier() {
        library.borrowItem(null, "John Doe", "johndoe@students.csu.edu");
    }

    /**
     * Tests if borrowing an item with an empty identifier throws an IllegalArgumentException.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testBorrowItemWithEmptyIdentifier() {
        library.borrowItem("", "John Doe", "johndoe@students.csu.edu");
    }

    /**
     * Tests if borrowing an item with a null borrower name throws an IllegalArgumentException.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testBorrowItemWithNullBorrowerName() {
        library.borrowItem("0316769177", null, "johndoe@students.csu.edu");
    }

    /**
     * Tests if borrowing an item with an empty borrower name throws an IllegalArgumentException.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testBorrowItemWithEmptyBorrowerName() {
        library.borrowItem("0316769177", "", "johndoe@students.csu.edu");
    }

    /**
     * Tests if returning an item with a null identifier throws an IllegalArgumentException.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testReturnItemWithNullIdentifier() {
        library.returnItem(null);
    }

    /**
     * Tests if returning an item with an empty identifier throws an IllegalArgumentException.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testReturnItemWithEmptyIdentifier() {
        library.returnItem("");
    }

    /**
     * Tests if saving a file with a null filename throws an IllegalArgumentException.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testSaveToFileWithNullFilename() throws IOException {
        library.saveToFile(null);
    }

    /**
     * Tests if saving a file with an empty filename throws an IllegalArgumentException.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testSaveToFileWithEmptyFilename() throws IOException {
        library.saveToFile("");
    }

    /**
     * Tests if loading a file with a null filenam throws an IllegalArgumentException.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testLoadFromFileWithNullFilename() throws IOException, ClassNotFoundException {
        library.loadFromFile(null);
    }

    /**
     * Tests if loading a file with an empty filename throws an IllegalArgumentException.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testLoadFromFileWithEmptyFilename() throws IOException, ClassNotFoundException {
        library.loadFromFile("");
    }                        

    /**
     * Tests adding a new item to the library and if it can be searched.
     * Verifies that after adding a new item it appears in the search results.
     */   
    
    @Test
    public void testAddItem() {
        // Test adding a new item
        Book newBook = new Book("1984", "George Orwell", "0451524934");
        library.addItem(newBook);
        List<LibraryItem> items = library.searchItems("1984");
        Assert.assertFalse("Item should be found", items.isEmpty());
        Assert.assertEquals("Title should match", "1984", items.get(0).getTitle());
    }

    /**
     * Tests the search function of the library.
     * Verifies that searching for an existing item by the title returns the correct item.
     */

    @Test
    public void testSearchItems() {
        // Test searching for an item
        List<LibraryItem> results = library.searchItems("Thriller");
        Assert.assertFalse("Results should not be empty", results.isEmpty());
        Assert.assertEquals("Search should return correct item", "Thriller", results.get(0).getTitle());
    }

    /**
     * Tests the borrow and return functions of the library.
     * Verifies that an item can be borrowed and returned successfully and that 
     * its status updates correctly.
     */

    @Test
    public void testBorrowAndReturnItem() {
        // Test borrowing an item
        String identifier = "0316769177"; // ISBN of "The Catcher in the Rye"
        boolean borrowSuccess = library.borrowItem(identifier, "John Doe", "johndoe@students.csu.edu");
        Assert.assertTrue("Borrow should succeed", borrowSuccess);
        Assert.assertEquals("Item status should be borrowed", "borrowed", library.getItemByIdentifier(identifier).getStatus());

        // Test returning the item
        boolean returnSuccess = library.returnItem(identifier);
        Assert.assertTrue("Return should succeed", returnSuccess);
        Assert.assertEquals("Item status should be available", "available", library.getItemByIdentifier(identifier).getStatus());
    }

    /**
     * Tests saving the library's state to a file and then loading it back.
     * Verifies that after saving and loading, the library contains the same number of items.
     */

     @Test
     public void testSaveToFileAndLoadFromFile() throws IOException, ClassNotFoundException {
        // Save the current state of the library
        String testFilename = "test_library.libtest";
        library.saveToFile(testFilename);

        // Create a new library instance and load the data from the file
        Library loadedLibrary = new Library();
        loadedLibrary.loadFromFile(testFilename);

        // Assert that the loaded library has the same items as the original
        Assert.assertEquals("Loaded library should have the same number of items", 
                            library.searchItems("").size(), 
                            loadedLibrary.searchItems("").size());

        // Clean up the test file
        new File(testFilename).delete();
    }
}
