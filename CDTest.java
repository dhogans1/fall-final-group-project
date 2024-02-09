import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

/**
 * The CDTest class contains unit tests for the CD class.
 * It tests the CD class's functionality, constructor, getters, 
 * search attributes, unique identifier, and string representation.
 */

public class CDTest {
    private CD cd;

    /**
     * Sets up a new CD object before each test.
     * This method is executed before each test method and sets up a CD with sample values.
     */

    @Before
    public void setUp() {
        cd = new CD("Thriller", "Michael Jackson", "Pop");
    }

    /**
     * Tests if the CD constructor throws an IllegalArgumentException when the artist is null.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testCDConstructorWithNullArtist() {
        new CD("Thriller", null, "Pop");
    }

    /**
     * Tests if the CD constructor throws an IllegalArgumentException when the artist is an empty string.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testCDConstructorWithEmptyArtist() {
        new CD("Thriller", "", "Pop");
    }

   /**
    * Tests if the CD constructor throws an IllegalArgumentException when the genre is null.
    */

    @Test(expected = IllegalArgumentException.class)
    public void testCDConstructorWithNullGenre() {
        new CD("Thriller", "Michael Jackson", null);
    }

    /**
     * Tests if the CD constructor throws an IllegalArgumentException when the genre is an empty string.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testCDConstructorWithEmptyGenre() {
        new CD("Thriller", "Michael Jackson", "");
    }

   /**
    * Tests the constructor and getters of the CD class.
    * Verifies that the title, artist, and genre of the CD are correctly set and retrieved.
    */

    @Test
    public void testCDConstructorAndGetters() {
        Assert.assertEquals("Title should match", "Thriller", cd.getTitle());
        Assert.assertEquals("Artist should match", "Michael Jackson", cd.getArtist());
        Assert.assertEquals("Genre should match", "Pop", cd.getGenre());
    }

    /**
     * Tests the getSearchableAttributes method of the CD class.
     * Verifies that the method returns a list containing the correct 
     * attributes for the search function.
     */

    @Test
    public void testGetSearchableAttributes() {
        List<String> expectedAttributes = Arrays.asList("thriller", "michael jackson", "pop");
        Assert.assertEquals("Searchable attributes should match", expectedAttributes, cd.getSearchableAttributes());
    }

    /**
     * Tests the getUniqueIdentifier method of the CD class.
     * Verifies that the CD's title and artist is used as the unique identifier.
     */

    @Test
    public void testGetUniqueIdentifier() {
        Assert.assertEquals("Unique identifier should combine title and artist", 
                            "Thriller_Michael Jackson", cd.getUniqueIdentifier());
    }

    /**
     * Tests the toString method of the CD class.
     * Verifies that the method returns a string containing the CD's title, status, artist, and genre.
     */

    @Test
    public void testToString() {
        String expectedString = "Title: Thriller, Status: available, Artist: Michael Jackson, Genre: Pop";
        Assert.assertEquals("String representation should match", expectedString, cd.toString());
    }

}
