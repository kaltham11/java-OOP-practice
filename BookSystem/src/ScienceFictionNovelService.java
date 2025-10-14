import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScienceFictionNovelService {

    public static List<ScienceFictionNovel> scienceFictionBookList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static ScienceFictionNovel addBookInput() {
        ScienceFictionNovel scienceFictionNovelBook = new ScienceFictionNovel();
        System.out.println("Please, Enter The International Standard Book Number(ISBN) of book");
        String iSBN = scanner.nextLine();
        while (HelperUtils.isNull(iSBN) || HelperUtils.checkIfStrIsBlankOrEmpty(iSBN) || checkIfBookISBNIsExit(iSBN)) {
            System.out.println("This Book ISBN is already exits in out Records," +
                    "Please Enter another ISBN");
            iSBN = scanner.nextLine();
        }
        scienceFictionNovelBook.setiSBN(iSBN);

        System.out.println("Please, Enter The speculative Technology of book");
        String speculativeTechnology = scanner.nextLine();
        while (HelperUtils.isNull(speculativeTechnology) || HelperUtils.checkIfStrIsBlankOrEmpty(speculativeTechnology)) {
            System.out.println("Invalid Input, please enter again");
            speculativeTechnology = scanner.nextLine();
        }
        scienceFictionNovelBook.setSpeculativeTechnology(speculativeTechnology);

        System.out.println("Please, Enter The subgenre book");
        String subgenre = scanner.nextLine();
        while (HelperUtils.isNull(subgenre) || HelperUtils.checkIfStrIsBlankOrEmpty(subgenre)) {
            System.out.println("Invalid Input, please enter again");
            subgenre = scanner.nextLine();
        }
        scienceFictionNovelBook.setSubgenre(subgenre);

        System.out.println("Please, Enter (true/false) of the scientific Plausibility");
        String scientificPlausibility = scanner.nextLine();
        while (!scientificPlausibility.equalsIgnoreCase("true") && !scientificPlausibility.equalsIgnoreCase("false")) {
            System.out.println("Invalid Input, Please write again");
            scientificPlausibility = scanner.nextLine();
        }
        Boolean hasScientificPlausibility = Boolean.parseBoolean(scientificPlausibility);
        scienceFictionNovelBook.setScientificPlausibility(hasScientificPlausibility);
        return scienceFictionNovelBook;
    }

    public static void save(ScienceFictionNovel book) {
        scienceFictionBookList.add(book);
        System.out.println("The book data is successfully added");
    }

    public static ScienceFictionNovel editBookInput() {
        if (scienceFictionBookList.isEmpty()) {
            System.out.println("No Book available to edit");
            return null;
        }

        System.out.println("Enter the ISBN of the book to edit");
        String iSBN = scanner.nextLine();
        while (HelperUtils.isNull(iSBN) || HelperUtils.checkIfStrIsBlankOrEmpty(iSBN) || !checkIfBookISBNIsExit(iSBN)) {
            System.out.println("Invalid Input, please write again");
            iSBN = scanner.nextLine();
        }
        ScienceFictionNovel selectedBook = null;

        for (ScienceFictionNovel book : scienceFictionBookList) {
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
                1 - speculative Technology
                2 - subgenre
                3 - scientific Plausibility
                4- Exit
                """);
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1 -> {
                System.out.println("Enter new speculative Technology of the book");
                String speculativeTechnology = scanner.nextLine();
                selectedBook.setSpeculativeTechnology(speculativeTechnology);
                System.out.println("Speculative Technology updated successfully.");
            }
            case 2 -> {
                System.out.println("Enter new subgenre of the book");
                String subgenre = scanner.nextLine();
                selectedBook.setSubgenre(subgenre);
                System.out.println("subgenre updated successfully of the book");
            }
            case 3 -> {
                System.out.println("Enter the update for scientific Plausibility(True/False)");
                String scientificPlausibility = scanner.nextLine();
                if (scientificPlausibility.equalsIgnoreCase("true") || scientificPlausibility.equalsIgnoreCase("false")) {
                    Boolean isScientificPlausibility = Boolean.parseBoolean(scientificPlausibility);
                    selectedBook.setScientificPlausibility(isScientificPlausibility);
                    System.out.println("Scientific Plausibility updated successfully");
                }
                System.out.println("The input is invalid, please enter (true/false)");
                scientificPlausibility = scanner.nextLine();

            }

            case 4 -> {
                System.out.println("Exiting edit menu...");
                return selectedBook;
            }
            default -> System.out.println("Invalid option, Please Enter a number from Menu");
        }
        return selectedBook;
    }

    public static void update(ScienceFictionNovel updatedBook) {
        if (updatedBook == null) {
            System.out.println("No updates to save");
            return;
        }

        for (int i = 0; i < scienceFictionBookList.size(); i++) {
            if (scienceFictionBookList.get(i).equals(updatedBook)) {
                scienceFictionBookList.set(i, updatedBook);
                System.out.println("Book updated successfully.");
                return;
            }
        }
        System.out.println("Updated Book not found in list");
    }


    public static String getBookToRemove() {
        if (scienceFictionBookList.isEmpty()) {
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
            scienceFictionBookList.removeIf(book -> book.getiSBN().equals(removeBookByISBN));
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found");
        }
    }

    public static void displayAllBook() {
        if (scienceFictionBookList.isEmpty()) {
            System.out.println("There are no book Available");
            System.out.println("********************************************");
        }
        System.out.println("The List of The Book");
        System.out.println("********************************************");
        for (ScienceFictionNovel book : scienceFictionBookList) {
            System.out.println(book);
        }
    }

    public static Boolean checkIfBookISBNIsExit(String iSBNToCheck) {
        for (ScienceFictionNovel book : scienceFictionBookList) {
            if (book.getiSBN().equals(iSBNToCheck)) {
                return true;
            }
        }
        return false;
    }
}
