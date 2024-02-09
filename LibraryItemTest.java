import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * The LibraryItemTest class contains unit tests for the LibraryItem class.
 * It tests the functionality of borrowing, returning items, and retrieving item details.
 */

public class LibraryItemTest {
    private LibraryItem item;

    /**
     * Sets up a testing environment before each test.
     * It initializes the LibraryItem with a test title and overrides
     * the abstract methods getSearchableAttributes and getUniqueIdentifier.
     */

    @Before
    public void setUp() {
        // Creating a concrete subclass of LibraryItem for testing
        item = new LibraryItem("Test Title") {
            @Override
            public List<String> getSearchableAttributes() {
                List<String> attributes = new ArrayList<>();
                attributes.add(getTitle());
                return attributes;
            }

            @Override
            public String getUniqueIdentifier() {
                return "UniqueID";
            }
        };
    }

    /**
     * Tests the borrowItem method of LibraryItem.
     * Ensures that the item's status, borrower name, and contact are updated correctly.
     */

    @Test
    public void testBorrowItem() {
        item.borrowItem("John Doe", "johndoe@students.csu.edu");
        Assert.assertEquals("borrowed", item.getStatus());
        Assert.assertEquals("John Doe", item.getBorrowerName());
        Assert.assertEquals("johndoe@students.csu.edu", item.getBorrowerContact());
    }

    /**
     * Tests the returnItem method of LibraryItem.
     * Verifies that the item's status is updated to 'available' and borrower's information is cleared.
     */

    @Test
    public void testReturnItem() {
        item.borrowItem("John Doe", "johndoe@students.csu.edu");
        item.returnItem("UniqueID");
        Assert.assertEquals("available", item.getStatus());
        // Verify borrower's information is cleared after returning
        Assert.assertTrue("Borrower name should be cleared", item.getBorrowerName().isEmpty());
        Assert.assertTrue("Borrower contact should be cleared", item.getBorrowerContact().isEmpty());
    }

    /**
     * Tests the getTitle method of LibraryItem.
     * Checks if the correct title is returned.
     */

    @Test
    public void testGetTitle() {
        Assert.assertEquals("Test Title", item.getTitle());
    }

    /**
     * Tests the toString method of LibraryItem.
     * Ensures that the string representation of the item contains correct details.
     */

    @Test
    public void testToString() {
        String expectedString = "Title: Test Title, Status: available";
        Assert.assertEquals(expectedString, item.toString());
    }

}
