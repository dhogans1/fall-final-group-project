import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * The LibraryUI class is user interface for interacting with the Library.
 * It allows users to add items, search for items, borrow and return items, and save/load the library to/from a file.
 */

public class LibraryUI {
    private Library library;
    private Scanner scanner;

    /**
     * Constructs a new LibraryUI object with the Library and Scanner instances.
     *
     * @param library The library being interacted with.
     * @param scanner The scanner to read user input.
     */

    public LibraryUI(Library library, Scanner scanner) {
        this.library = library;
        this.scanner = scanner;
    }

    /**
     * Starts the user interface loop which allows users to interact with the library system.
     * Provides options to add, search, borrow, return items, and to save/load library.
     */

    public void start() {
        boolean quit = false;
        while (!quit) {
            System.out.println("\n1) Add Item");
            System.out.println("2) Search Items");
            System.out.println("3) Borrow Item");
            System.out.println("4) Return Item");
            System.out.println("5) Export all items to file");
            System.out.println("6) Load all items from file");
            System.out.println("7) Quit");
            System.out.print("Please choose from the above options: ");
            String choice = scanner.nextLine();
            try {
                int option = Integer.parseInt(choice);
                switch (option) {
                case 1:
                    addItem();
                    break;
                case 2:
                    searchItems();
                    break;
                case 3:
                    borrowItem();
                    break;
                case 4:
                    returnItem();
                    break;
                case 5:
                    saveToFile();
                    break;
                case 6:
                    loadFromFile();
                    break;
                case 7:
                    quit = true;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please enter a number between 1 and 7.");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (Exception e) {
                System.err.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    /**
     * Handles the addition of a new library item. Prompts the user to specify the type of 
     * item (Book, DVD, CD) and then calls the method.
     */

    private void addItem() {
        boolean validInput = false;
        while (!validInput) {
            System.out.println("What type of item would you like to add?");
            System.out.println("1. Book");
            System.out.println("2. DVD");
            System.out.println("3. CD");
            System.out.print("Enter your choice (1-3): ");
            String itemType = scanner.nextLine();
        
            switch (itemType) {
                case "1":
                    addBook();
                    validInput = true;
                    break;
                case "2":
                    addDVD();
                    validInput = true;
                    break;
                case "3":
                    addCD();
                    validInput = true;
                    break;
                default:
                    System.out.println("Invalid option. Please enter a number between 1 and 3.");
                    break;
            }
        }
    }

    /**
     * Prompts the user for details about a new book and adds it to the library.
     * Requires title, author's name, and ISBN for the book.
     */

    private void addBook() {
        System.out.println("Enter the title of the book:");
        String title = scanner.nextLine();
        while (title.isEmpty()) {
            System.out.println("Title cannot be empty. Please enter the title:");
            title = scanner.nextLine();
        }
        System.out.println("Enter the author's name:");
        String author = scanner.nextLine();
        while (author.isEmpty()) {
            System.out.println("Author cannot be empty. Please enter the author:");
            author = scanner.nextLine();
        }
        System.out.println("Enter the ISBN of the book:");
        String isbn = scanner.nextLine();
        while (isbn.isEmpty()) {
            System.out.println("ISBN cannot be empty. Please enter the ISBN:");
            author = scanner.nextLine();
        }
        Book book = new Book(title, author, isbn);
        library.addItem(book);
        System.out.println("Book added successfully.");
    }
    
    /**
     * Prompts the user for details about a new DVD and adds it to the library.
     * Requires title, genre, and director's name for the DVD.
     */

    private void addDVD() {
        System.out.println("Enter the title of the DVD:");
        String title = scanner.nextLine();
        while (title.isEmpty()) {
            System.out.println("Title cannot be empty. Please enter the title:");
            title = scanner.nextLine();
        }
        System.out.println("Enter the genre of the DVD:");
        String genre = scanner.nextLine();
        while (genre.isEmpty()) {
            System.out.println("Genre cannot be empty. Please enter the genre:");
            genre = scanner.nextLine();
        }
        System.out.println("Enter the director's name:");
        String director = scanner.nextLine();
        while (director.isEmpty()) {
            System.out.println("Director cannot be empty. Please enter the director:");
            director = scanner.nextLine();
        }
    
        DVD dvd = new DVD(title, genre, director);
        library.addItem(dvd);
        System.out.println("DVD added successfully.");
    }
    
    /**
     * Prompts the user for details about a new CD and adds it to the library.
     * Requires title, artist's name, and genre for the CD.
     */

    private void addCD() {
        System.out.println("Enter the title of the CD:");
        String title = scanner.nextLine();
        while (title.isEmpty()) {
            System.out.println("Title cannot be empty. Please enter the title:");
            title = scanner.nextLine();
        }
        System.out.println("Enter the artist's name:");
        String artist = scanner.nextLine();
        while (artist.isEmpty()) {
            System.out.println("Artist cannot be empty. Please enter the artist:");
            artist = scanner.nextLine();
        }
        System.out.println("Enter the genre of the CD:");
        String genre = scanner.nextLine();
        while (genre.isEmpty()) {
            System.out.println("Genre cannot be empty. Please enter the genre:");
            genre = scanner.nextLine();
        }

        CD cd = new CD(title, artist, genre);
        library.addItem(cd);
        System.out.println("CD added successfully.");
    }
    
    /**
     * Handles the search function in the library. Prompts the user for a search term
     * and displays matching items.
     */    

    private void searchItems() {
        System.out.println("Enter the search term (ISBN, director, author, artist, etc.):");
        String searchTerm = scanner.nextLine();
        List<LibraryItem> matchingItems = library.searchItems(searchTerm);
        if (matchingItems.isEmpty()) {
            System.out.println("No items found.");
        } else {
            System.out.println("Matching items:");
            for (LibraryItem item : matchingItems) {
                System.out.println(item);
            }
        }
    }

    /**
     * Handles the process of borrowing an item from the library. Prompts the user for the item's unique identifier
     * and the borrower's details, and then attempts to borrow the item.
     */

    private void borrowItem() {
        System.out.println("Enter the identifier of the item to borrow (ISBN for book, title_director's name for movie, and title_artist's name for CD):");
        String identifier = scanner.nextLine();
        while (identifier.isEmpty()) {
            System.out.println("Identifier cannot be empty. Please enter the identifier:");
            identifier = scanner.nextLine();
        }
        System.out.println("Enter your name:");
        String borrowerName = scanner.nextLine();
        while (borrowerName.isEmpty()) {
            System.out.println("Name cannot be empty. Please enter your name:");
            borrowerName = scanner.nextLine();
        }
        System.out.println("Enter your contact information:");
        String borrowerContact = scanner.nextLine();
        while (borrowerContact.isEmpty()) {
            System.out.println("Contact information cannot be empty. Please enter your contact information:");
            borrowerContact  = scanner.nextLine();
        }
    
        boolean success = library.borrowItem(identifier, borrowerName, borrowerContact);
        if (success) {
            System.out.println("Item borrowed successfully.");
        } else {
            System.out.println("Item could not be borrowed. It might be unavailable or not found.");
        }
    }
    
    /**
     * Handles the process of returning an item to the library. Prompts the user for the item's unique identifier
     * and processes the return.
     */

    private void returnItem() {
        System.out.println("Enter the identifier of the item to return (ISBN for book, title_director for movie, and title_artist for CD):");
        String identifier = scanner.nextLine();
        while (identifier.isEmpty()) {
            System.out.println("Identifier cannot be empty. Please enter the identifier:");
            identifier = scanner.nextLine();
        }
        boolean success = library.returnItem(identifier);
        if (success) {
            System.out.println("Item returned successfully.");
        } else {
            System.out.println("Item could not be returned. It might not be borrowed or not found.");
        }
    }
    
    /**
     * Saves the library to a file. Prompts the user for the filename and executes the save operation.
     *
     * @throws IOException if an I/O error occurs during saving.
     */

    private void saveToFile() throws IOException {
        System.out.println("Enter the filename to save the items:");
        String filename = scanner.nextLine();
        while (filename.isEmpty()) {
            System.out.println("Filename cannot be empty. Please enter the filename:");
            filename = scanner.nextLine();
        }
        library.saveToFile(filename);
    }

    /**
     * Loads the library from a file. Prompts the user for the filename and loads the file.
     *
     * @throws ClassNotFoundException if the class of a serialized object cannot be found.
     * @throws IOException if an I/O error occurs during loading.
     */

    private void loadFromFile() throws ClassNotFoundException, IOException {
        System.out.println("Enter the filename to load the items:");
        String filename = scanner.nextLine();
        while (filename.isEmpty()) {
            System.out.println("Filename cannot be empty. Please enter the filename:");
            filename = scanner.nextLine();
        }
        library.loadFromFile(filename);
    }
}
