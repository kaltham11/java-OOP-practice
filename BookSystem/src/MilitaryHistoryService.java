import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MilitaryHistoryService {

    public static List<MilitaryHistory> militaryHistoryBookList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static MilitaryHistory addBookInput() {
        MilitaryHistory militaryHistorybook = new MilitaryHistory();
        System.out.println("Please, Enter The ISBN of book");
        String bookISBN = scanner.nextLine();
        while (HelperUtils.isNull(bookISBN) || HelperUtils.checkIfStrIsBlankOrEmpty(bookISBN)||checkIfBookISBNIsExit(bookISBN)) {
            System.out.println("This Book ISBN is already exits in out Records," +
                    "Please Enter another ID");
            bookISBN = scanner.nextLine();
        }
        militaryHistorybook.setiSBN(bookISBN);
        System.out.println("Please, Enter The conflict Focus of book");
        String conflictFocus = scanner.nextLine();
        while (HelperUtils.isNull(conflictFocus) || HelperUtils.checkIfStrIsBlankOrEmpty(conflictFocus)) {
            System.out.println("Invalied Input, Please write again");
            conflictFocus = scanner.nextLine();
        }
        militaryHistorybook.setConflictFocus(conflictFocus);
        System.out.println("Please, Enter The technological Analysis of book");
        String technologicalAnalysis = scanner.nextLine();
        while (HelperUtils.isNull(technologicalAnalysis) || HelperUtils.checkIfStrIsBlankOrEmpty(technologicalAnalysis)) {
            System.out.println("Invalied Input, Please write again");
            technologicalAnalysis = scanner.nextLine();
        }
        militaryHistorybook.setTechnologicalAnalysis(technologicalAnalysis);

        System.out.println("Please, Enter The True if strategic Maps Included OR False if hasn't");
        String strategicMapsIncluded = scanner.nextLine();
        while (!strategicMapsIncluded.equalsIgnoreCase("true") && !strategicMapsIncluded.equalsIgnoreCase("false")) {
            System.out.println("Invalid Input, Please write again");
            strategicMapsIncluded = scanner.nextLine();
        }
        Boolean hasStrategicMapsIncluded = Boolean.parseBoolean(strategicMapsIncluded);
        militaryHistorybook.setStrategicMapsIncluded(hasStrategicMapsIncluded);

        return militaryHistorybook;
    }

    public static void save(MilitaryHistory book) {
        militaryHistoryBookList.add(book);
        System.out.println("The book data is successfully added");
    }


    public static MilitaryHistory editBookInput() {
        if (militaryHistoryBookList.isEmpty()) {
            System.out.println("No Book available to edit");
            return null;
        }

        System.out.println("Enter the ISBN of the book to edit");
        String iSBN = scanner.nextLine();
        while (HelperUtils.isNull(iSBN) || HelperUtils.checkIfStrIsBlankOrEmpty(iSBN) || !checkIfBookISBNIsExit(iSBN)) {
            System.out.println("Invalid Input, please write again");
            iSBN = scanner.nextLine();
        }
        MilitaryHistory selectedBook = null;

        for (MilitaryHistory book : militaryHistoryBookList) {
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
                1 - conflictFocus
                2 - technologicalAnalysis
                3 - strategicMapsIncluded
                4- Exit
                """);
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1 -> {
                System.out.println("Enter new conflict Focus of the book");
                String newConflictFocus = scanner.nextLine();
                selectedBook.setConflictFocus(newConflictFocus);
                System.out.println("Conflict Focus updated successfully.");
            }
            case 2 -> {
                System.out.println("Enter new technological Analysis");
                String newTechnologicalAnalysis = scanner.nextLine();
                selectedBook.setTechnologicalAnalysis(newTechnologicalAnalysis);
                System.out.println("Technological Analysis updated successfully.");
            }
            case 3 -> {
                System.out.println("Enter the update for is strategic Maps Included(True/False)");
                String mapsIncluded = scanner.nextLine();
                while (!mapsIncluded.equalsIgnoreCase("true") && !mapsIncluded.equalsIgnoreCase("false")) {
                    System.out.println("The input is invalid, please enter (true/false)");
                    mapsIncluded = scanner.nextLine();
                }
                Boolean isMapsIncluded = Boolean.parseBoolean(mapsIncluded);
                selectedBook.setStrategicMapsIncluded(isMapsIncluded);
                System.out.println("strategic Maps Included updated successfully");


            }

            case 4 -> {
                System.out.println("Exiting edit menu...");
                return selectedBook;
            }
            default -> System.out.println("Invalid option, Please Enter a number from Menu");
        }
        return selectedBook;
    }

    public static void update(MilitaryHistory updatedBook) {
        if (updatedBook == null) {
            System.out.println("No updates to save");
            return;
        }

        for (int i = 0; i < militaryHistoryBookList.size(); i++) {
            if (militaryHistoryBookList.get(i).getiSBN().equals(updatedBook.getiSBN())) {
                militaryHistoryBookList.set(i, updatedBook);
                System.out.println("Book updated successfully.");
                return;
            }
        }
        System.out.println("Updated Book not found in list");
    }


    public static String getBookToRemove() {
        if (militaryHistoryBookList.isEmpty()) {
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
            militaryHistoryBookList.removeIf(book -> book.getiSBN().equals(removeBookByISBN));
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found");
        }
    }


    public static void displayAllBook() {
        if (militaryHistoryBookList.isEmpty()) {
            System.out.println("There are no book Available");
            System.out.println("********************************************");
        }
        System.out.println("The List of The Book");
        System.out.println("********************************************");
        for (MilitaryHistory book : militaryHistoryBookList) {
            System.out.println(book);
        }
    }


    public static Boolean checkIfBookISBNIsExit(String iSBNToCheck) {
        for (MilitaryHistory book : militaryHistoryBookList) {
            if (book.getiSBN().equals(iSBNToCheck)) {
                return true;
            }
        }
        return false;
    }
}


