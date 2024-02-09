import java.util.Scanner;
/**
 * The `Main` class serves as the entry point for the personal library management system.
 */

public class Main {
    /**
     * The main method of the application, which creates a library and starts the library user interface.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Create a new library instance
        Library library = new Library();
        // Initialize a scanner to capture user input
        try (Scanner scanner = new Scanner(System.in)) {
            // Create a LibraryUI instance to manage user interactions with the library
            LibraryUI libraryUI = new LibraryUI(library, scanner);
            // Start the library user interface
            libraryUI.start();
        }
    }
}
