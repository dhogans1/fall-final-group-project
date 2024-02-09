import java.util.Arrays;
import java.util.List;

/**
 * The `DVD` class represents a DVD in the library and extends the `LibraryItem` class.
 * It includes properties specific to this class such as genre and director.
 */
public class DVD extends LibraryItem {
    private String genre;
    private String director;

    /**
     * Initializes a new instance of the `DVD` class with the title, genre, and director.
     * The genre and director cannot be null or empty otherwise an IllegalArgumentException
     * is thrown.
     *
     * @param title    The title of the DVD.
     * @param genre    The genre of the DVD.
     * @param director The director of the DVD.
     * @throws IllegalArgumentException if genre or director is null or empty.
     */
    public DVD(String title, String genre, String director) {
        super(title); // Call the constructor of the LibraryItem class

        if (genre == null || genre.isEmpty()){
            throw new IllegalArgumentException("Genre cannot be null or empty");
        }
        this.genre = genre;

        if (director == null || director.isEmpty()){
            throw new IllegalArgumentException("Director cannot be null or empty");
        }
        this.director = director;
    }

    /**
     * Retrieves the genre of the DVD.
     *
     * @return The genre of the DVD.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Retrieves the director of the DVD.
     *
     * @return The director of the DVD.
     */
    public String getDirector() {
        return director;
    }

    /**
     * Gets a list of attributes of the DVD that should be used in the search function.
     * Includes the title, genre, and director.
     * 
     * @return A list of searchable attribute strings.
     */
    @Override
    public List<String> getSearchableAttributes() {
        return Arrays.asList(getTitle().toLowerCase(), getGenre().toLowerCase(), getDirector().toLowerCase());
    }

    /**
     * Retrieves the unique identifier for the DVD.
     * The unique identifier is the DVD's title and director.
     * 
     * @return A string combining the title and director of the DVD with an underscore.
     */
    @Override
    public String getUniqueIdentifier() {
        return getTitle() + "_" + getDirector(); // Combining title and director
    }

    /**
     * Generates a string representation of the DVD.
     *
     * @return A string representation of the DVD.
     */
    @Override
    public String toString() {
        return super.toString() + ", Genre: " + genre + ", Director: " + director;
    }
}
