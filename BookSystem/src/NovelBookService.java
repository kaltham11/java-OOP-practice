import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NovelBookService {

    public static List<NovelBook> novelBookList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static NovelBook addBookInput() {
        NovelBook novelBook = new NovelBook();
        System.out.println("Please, Enter The International Standard Book Number(ISBN) of book");
        String iSBN = scanner.nextLine();
        while (HelperUtils.isNull(iSBN) || checkIfBookISBNIsExit(iSBN) || checkIfBookISBNIsExit(iSBN)) {
            System.out.println("Invalid Input, Please write again");
            iSBN = scanner.nextLine();
        }
        novelBook.setiSBN(iSBN);
        System.out.println("Please, Enter The genre of book");
        String bookGenre = scanner.nextLine();
        while (HelperUtils.isNull(bookGenre) || HelperUtils.checkIfStrIsBlankOrEmpty(bookGenre)) {
            System.out.println("Invalid Input, Please write again");
            bookGenre = scanner.nextLine();
        }
        novelBook.setGenre(bookGenre);


        System.out.println("Please, Enter The setting of the story book");
        String bookSetting = scanner.nextLine();
        while (HelperUtils.isNull(bookSetting) || HelperUtils.checkIfStrIsBlankOrEmpty(bookSetting)) {
            System.out.println("Invalid Input, Please write again");
            bookSetting = scanner.nextLine();
        }
        novelBook.setSetting(bookSetting);

        System.out.println("Please, Enter The True if book has Series OR False if hasn't");
        String isSeries = scanner.nextLine();
        while (!isSeries.equalsIgnoreCase("true") && !isSeries.equalsIgnoreCase("false")) {
            System.out.println("Invalid Input, Please write again");
            isSeries = scanner.nextLine();
        }
        Boolean isBookSeries = Boolean.parseBoolean(isSeries);
        novelBook.setSeries(isBookSeries);

        System.out.println("Please, Enter The True if book is Real OR False if isn't");
        String isReal = scanner.nextLine();
        while (!isReal.equalsIgnoreCase("true") && !isReal.equalsIgnoreCase("false")) {
            System.out.println("Invalid Input, Please write again");
            isReal = scanner.nextLine();
        }
        Boolean isBookReal = Boolean.parseBoolean(isReal);
        novelBook.setSeries(isBookReal);

        return novelBook;
    }

    public static void save(NovelBook book) {
        novelBookList.add(book);
        System.out.println("The book data is successfully added");
    }

    public static NovelBook editBookInput() {
        if (novelBookList.isEmpty()) {
            System.out.println("No Book available to edit");
            return null;
        }

        System.out.println("Enter the ISBN of the book to edit");
        String iSBN = scanner.nextLine();
        while (HelperUtils.isNull(iSBN) || HelperUtils.checkIfStrIsBlankOrEmpty(iSBN) || !checkIfBookISBNIsExit(iSBN)) {
            System.out.println("Invalid Input, please write again");
            iSBN = scanner.nextLine();
        }
        NovelBook selectedBook = null;

        for (NovelBook book : novelBookList) {
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
                1 - genre
                2 - setting
                3 - is Series
                4-  isReal
                5- Exit
                """);
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1 -> {
                System.out.println("Enter new genre of the book");
                String newGenre = scanner.nextLine();
                selectedBook.setGenre(newGenre);
                System.out.println("Genre for the story is updated successfully.");
            }
            case 2 -> {
                System.out.println("Enter new Setting of the story");
                String setting = scanner.nextLine();
                selectedBook.setSetting(setting);
                System.out.println("Setting of the story is updated successfully.");
            }
            case 3 -> {
                System.out.println("Enter the update for is Series(True/False)");
                String isSeries = scanner.nextLine();
                if (!isSeries.equalsIgnoreCase("true") && !isSeries.equalsIgnoreCase("false")) {
                    System.out.println("The input is invalid, please enter (true/false)");
                    isSeries = scanner.nextLine();
                }

                Boolean isBookSeries = Boolean.parseBoolean(isSeries);
                selectedBook.setSeries(isBookSeries);
                System.out.println("is Book Series updated successfully");

            }

            case 4 -> {
                System.out.println("Enter the update for is Real(True/False)");
                String isReal = scanner.nextLine();
                if (!isReal.equalsIgnoreCase("true") && !isReal.equalsIgnoreCase("false")) {
                    System.out.println("The input is invalid, please enter (true/false)");
                    isReal = scanner.nextLine();
                }

                Boolean isBookReal = Boolean.parseBoolean(isReal);
                selectedBook.setReal(isBookReal);
                System.out.println("is Book Real updated successfully");

            }

            case 5 -> {
                System.out.println("Exiting edit menu...");
                return selectedBook;
            }
            default -> System.out.println("Invalid option, Please Enter a number from Menu");
        }
        return selectedBook;
    }

    public static void update(NovelBook updatedBook) {
        if (updatedBook == null) {
            System.out.println("No updates to save");
            return;
        }

        for (int i = 0; i < novelBookList.size(); i++) {
            if (novelBookList.get(i).equals(updatedBook)) {
                novelBookList.set(i, updatedBook);
                System.out.println("Book updated successfully.");
                return;
            }
        }
        System.out.println("Updated Book not found in list");
    }


    public static String getBookToRemove() {
        if (novelBookList.isEmpty()) {
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
            novelBookList.removeIf(book -> book.getiSBN().equals(removeBookByISBN));
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found");
        }
    }


    public static void displayAllBook() {
        if (novelBookList.isEmpty()) {
            System.out.println("There are no book Available");
            System.out.println("********************************************");
        }
        System.out.println("The List of The Book");
        System.out.println("********************************************");
        for (NovelBook novelBook : novelBookList) {
            System.out.println(novelBook);
        }
    }


    public static Boolean checkIfBookISBNIsExit(String iSBNToCheck) {
        for (NovelBook novelBook : novelBookList) {
            if (novelBook.getiSBN().equals(iSBNToCheck)) {
                return true;
            }
        }
        return false;
    }
}

