import java.util.Arrays;
import java.util.List;

/**
 * The `CD` class represents a CD in the library and extends the `LibraryItem` class.
 * It includes properties specific to this class such as artist and genre.
*/

public class CD extends LibraryItem {
    private String artist;
    private String genre;

    /**
     * Initializes a new instance of the `CD` class with the title, artist, and genre.
     * The artist and genre cannot be null or empty otherwise an IllegalArgumentException is thrown.
     *
     * @param title  The title of the CD.
     * @param artist The artist of the CD.
     * @param genre  The genre of the CD.
     * @throws IllegalArgumentException if artist or genre is null or empty.
     */

    public CD(String title, String artist, String genre) {
        super(title); // Call the constructor of the LibraryItem class

        if (artist == null || artist.isEmpty()){
            throw new IllegalArgumentException("Artist cannot be null or empty");
        }
        this.artist = artist;

        if (genre == null || genre.isEmpty()){
            throw new IllegalArgumentException("Genre cannot be null or empty");
        }
        this.genre = genre;
    }

    /**
     * Retrieves the artist of the CD.
     *
     * @return The artist of the CD.
     */

    public String getArtist() {
        return artist;
    }

    /**
     * Retrieves the genre of the CD.
     *
     * @return The genre of the CD.
     */

    public String getGenre() {
        return genre;
    }

    /**
     * Gets a list of attributes of the CD that should be used in search.
     * Includes the title, artist, and genre.
     * 
     * @return A list of searchable attribute strings.
     */

    @Override
    public List<String> getSearchableAttributes() {
        return Arrays.asList(getTitle().toLowerCase(), getArtist().toLowerCase(), getGenre().toLowerCase());
    }

    /**
     * Retrieves the unique identifier for the CD.
     * The unique identifier is the CD's title and artist.
     * 
     * @return A string combining the title and artist of the CD with an underscore.
     */

    @Override
    public String getUniqueIdentifier() {
        return getTitle() + "_" + getArtist(); // Combining title and artist
    }

    /**
     * Generates a string representation of the CD.
     *
     * @return A string representation of the CD.
     */

    @Override
    public String toString() {
        return super.toString() + ", Artist: " + artist + ", Genre: " + genre;
    }
}
