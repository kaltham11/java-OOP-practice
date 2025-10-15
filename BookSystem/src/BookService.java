import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookService {
    public static List<Book> bookList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static Book addBookInput() {
        Book book = new Book();
        System.out.println("Please, Enter The ID of book");
        Integer bookId = scanner.nextInt();
        while (HelperUtils.isNull(bookId) || bookId < 0 || checkIfBookIdIsExit(bookId)) {
            System.out.println("This Book ID is already exits in out Records," +
                    "Please Enter another ID");
            bookId = scanner.nextInt();
        }
        book.setId(bookId);
        scanner.nextLine();
        System.out.println("Please, Enter The Title of book");
        String bookTitle = scanner.nextLine();
        while (HelperUtils.isNull(bookTitle) || HelperUtils.checkIfStrIsBlankOrEmpty(bookTitle) ||
                checkIfBookTitleIsExit(bookTitle)) {
            System.out.println("This Book Title is already exits in out Records," +
                    "Please Enter another Title");
            bookTitle = scanner.nextLine();
        }
        book.setTitle(bookTitle);
        System.out.println("Please, Enter The International Standard Book Number(ISBN) of book");
        String iSBN = scanner.nextLine();
        while (HelperUtils.isNull(iSBN) || HelperUtils.checkIfStrIsBlankOrEmpty(iSBN) || checkIfBookISBNIsExit(iSBN)) {
            System.out.println("This Book ISBN is already exits in out Records," +
                    "Please Enter another ISBN");
            iSBN = scanner.nextLine();
        }
        book.setiSBN(iSBN);
        System.out.println("Please, Enter The Author of the book");
        String bookAuthor = scanner.nextLine();
        while (HelperUtils.isNull(bookAuthor) || HelperUtils.checkIfStrIsBlankOrEmpty(bookAuthor)) {
            System.out.println("Invalid Auother, Please write again");
            bookAuthor = scanner.nextLine();
        }
        book.setAuthor(bookAuthor);
        System.out.println("Please, Enter The publication Year of the book");
        String publicationYear = scanner.nextLine();
        while (HelperUtils.isNull(publicationYear) || HelperUtils.checkIfStrIsBlankOrEmpty(publicationYear)) {
            System.out.println("Invalid publication Year, Please write again");
            publicationYear = scanner.nextLine();
        }
        book.setPublicationYear(publicationYear);
        System.out.println("Please, Enter The Type of the book");
        String bookType = scanner.nextLine();
        while (HelperUtils.isNull(bookType) || HelperUtils.checkIfStrIsBlankOrEmpty(bookType)) {
            System.out.println("Invalid Input, Please write again");
            bookType = scanner.nextLine();
        }
        book.setType(bookType);
        System.out.println("Please, Enter The Price of the book");
        Double bookPrice = scanner.nextDouble();
        while (bookPrice < 0) {
            System.out.println("Invalid Input, Please write again");
            bookPrice = scanner.nextDouble();
        }
        book.setPrice(bookPrice);
        scanner.nextLine();
        System.out.println("Please, Enter The True if Available OR False if not Available of the book");
        String bookAvailable = scanner.nextLine();
        while (!bookAvailable.equalsIgnoreCase("true") && !bookAvailable.equalsIgnoreCase("false")) {
            System.out.println("Invalid Input, Please write again");
            bookAvailable = scanner.nextLine();
        }
        Boolean isBookAvailable = Boolean.parseBoolean(bookAvailable);
        book.setAvailable(isBookAvailable);

        return book;

    }

    public static void save(Book book) {
        bookList.add(book);
        System.out.println("The book data is successfully added");
    }


    public static Book editBookInput() {
        if (bookList.isEmpty()) {
            System.out.println("No Book available to edit");
            return null;
        }

        System.out.println("Enter the ISBN of the book to edit");
        String iSBN = scanner.nextLine();
        while (HelperUtils.isNull(iSBN) || HelperUtils.checkIfStrIsBlankOrEmpty(iSBN) || !checkIfBookISBNIsExit(iSBN)) {
            System.out.println("Invalid Input, please write again");
            iSBN = scanner.nextLine();
        }
        Book selectedBook = null;

        for (Book book : bookList) {
            if (book.getiSBN().equals(iSBN)) {
                selectedBook = book;
                break;
            }
        }
        if (selectedBook == null) {
            System.out.println("book not found");
            return null;
        }

        System.out.println("Which attribute would you like to edit?");
        System.out.println("""
                1 - ISBN
                2 - Price
                3 - is Available
                4- Exit
                """);
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1 -> {
                System.out.println("Enter new ISBN of the book");
                String newISBN = scanner.nextLine();
                selectedBook.setiSBN(newISBN);
                System.out.println("ISBN updated successfully.");
            }
            case 2 -> {
                System.out.println("Enter new Price");
                Double price = scanner.nextDouble();
                selectedBook.setPrice(price);
                scanner.nextLine();
                System.out.println("Price updated successfully.");
            }
            case 3 -> {
                System.out.println("Enter the update for is Available(True/False)");
                String available = scanner.nextLine();
                if (available.equalsIgnoreCase("true") || available.equalsIgnoreCase("false")) {
                    Boolean isavailable = Boolean.parseBoolean(available);
                    selectedBook.setAvailable(isavailable);
                    System.out.println("is Available updated successfully");
                }
                System.out.println("The input is invalid, please enter (true/false)");
                available = scanner.nextLine();

            }

            case 4 -> {
                System.out.println("Exiting edit menu...");
                return selectedBook;
            }
            default -> System.out.println("Invalid option, Please Enter a number from Menu");
        }

        return selectedBook;
    }

    public static void update(Book updatedBook) {
        if (updatedBook == null) {
            System.out.println("No updates to save");
            return;
        }

        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getiSBN().equals(updatedBook.getiSBN())) {
                bookList.set(i, updatedBook);
                System.out.println("Book updated successfully.");
                return;
            }
        }
        System.out.println("Updated Book not found in list");
    }


    public static String getBookToRemove() {
        if (bookList.isEmpty()) {
            System.out.println("No book available to remove.");
            return null;
        }
        System.out.println("Please, Enter The International Standard Book Number(ISBN) of book to remove it");
        String removeISBN = scanner.nextLine();
        while (HelperUtils.isNull(removeISBN) || HelperUtils.checkIfStrIsBlankOrEmpty(removeISBN)) {
            System.out.println("Invalid ISBN ,Please Enter another ISBN");
            removeISBN = scanner.nextLine();

        }
        return removeISBN;
    }

    public static void remove(String removeBookByISBN) {
        if (removeBookByISBN == null || removeBookByISBN.trim().isEmpty()) {
            System.out.println("Invalid input. No Book removed");
            return;
        }

        if (checkIfBookISBNIsExit(removeBookByISBN)) {
            bookList.removeIf(book -> book.getiSBN().equals(removeBookByISBN));
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found");
        }
    }


    public static void displayAllBook() {
        if (bookList.isEmpty()) {
            System.out.println("There are no book Available");
            System.out.println("********************************************");
        }
        System.out.println("The List of The Book");
        System.out.println("********************************************");
        for (Book book : bookList) {
            System.out.println(book);
        }
    }


    public static Boolean checkIfBookTitleIsExit(String titleToCheck) {
        for (Book book : bookList) {
            if (book.getTitle().equals(titleToCheck)) {
                return true;
            }
        }
        return false;
    }

    public static Boolean checkIfBookIdIsExit(Integer idToCheck) {
        for (Book book : bookList) {
            if (book.getId().equals(idToCheck)) {
                return true;
            }
        }
        return false;
    }

    public static Boolean checkIfBookISBNIsExit(String iSBNToCheck) {
        for (Book book : bookList) {
            if (book.getiSBN().equals(iSBNToCheck)) {
                return true;
            }
        }
        return false;
    }
}
