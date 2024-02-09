import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

/**
 * The DVDTest class contains unit tests for the DVD class.
 * It tests the DVD class's functionality, constructor, getters, 
 * search attributes, unique identifier, and string representation.
 */

public class DVDTest {
    private DVD dvd;

    /**
     * Sets up a new DVD object before each test.
     * This method is executed before each test method and sets up a DVD with sample values.
     */

    @Before
    public void setUp() {
        dvd = new DVD("Inception", "Sci-Fi", "Christopher Nolan");
    }

    /**
     * Tests if the DVD constructor throws an IllegalArgumentException when the genre is null.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testDVDConstructorWithNullGenre() {
        new DVD("Inception", null, "Christopher Nolan");
    }

    /**
     * Tests if the DVD constructor throws an IllegalArgumentException when the genre is an empty string.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testDVDConstructorWithEmptyGenre() {
        new DVD("Inception", "", "Christopher Nolan");
    }
    
    /**
     * Tests if the DVD constructor throws an IllegalArgumentException when the director is null.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testDVDConstructorWithNullDirector() {
        new DVD("Inception", "Sci-Fi", null);
    }
    
    /**
     * Tests if the DVD constructor throws an IllegalArgumentException when the director is an empty string.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testDVDConstructorWithEmptyDirector() {
        new DVD("Inception", "Sci-Fi", "");
    }

    /**
     * Tests the constructor and getters of the DVD class.
     * Verifies that the title, genre, and director of the DVD are correctly set and retrieved.
     */

    @Test
    public void testDVDConstructorAndGetters() {
        Assert.assertEquals("Title should match", "Inception", dvd.getTitle());
        Assert.assertEquals("Genre should match", "Sci-Fi", dvd.getGenre());
        Assert.assertEquals("Director should match", "Christopher Nolan", dvd.getDirector());
    }

    /**
     * Tests the getSearchableAttributes method of the DVD class.
     * Verifies that the method returns a list containing the correct attributes for the search funciton.
     */

    @Test
    public void testGetSearchableAttributes() {
        List<String> expectedAttributes = Arrays.asList("inception", "sci-fi", "christopher nolan");
        Assert.assertEquals("Searchable attributes should match", expectedAttributes, dvd.getSearchableAttributes());
    }

    /**
     * Tests the getUniqueIdentifier method of the DVD class.
     * Verifies that the DVD's title and director is used as the unique identifier.
     */

    @Test
    public void testGetUniqueIdentifier() {
        Assert.assertEquals("Unique identifier should combine title and director", 
                            "Inception_Christopher Nolan", dvd.getUniqueIdentifier());
    }

    /**
     * Tests the toString method of the DVD class.
     * Verifies that the method returns a string containing the DVD's title, status, genre, and director.
     */

    @Test
    public void testToString() {
        String expectedString = "Title: Inception, Status: available, Genre: Sci-Fi, Director: Christopher Nolan";
        Assert.assertEquals("String representation should match", expectedString, dvd.toString());
    }

}
