import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HistoryBookService {

    public static List<HistoryBook> historybookList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static HistoryBook addBookInput() {
            HistoryBook historyBook = new HistoryBook();
            System.out.println("Please, Enter The International Standard Book Number(ISBN) of book");
            String iSBN = scanner.nextLine();
            while (HelperUtils.isNull(iSBN) || HelperUtils.checkIfStrIsBlankOrEmpty(iSBN) || checkIfBookISBNIsExit(iSBN)) {
                System.out.println("This Book ISBN is already exits in out Records," +
                        "Please Enter another ISBN");
                iSBN = scanner.nextLine();
            }
            historyBook.setiSBN(iSBN);
            System.out.println("Please, Enter The historicalPeriod of book");
            String period = scanner.nextLine();
            while (HelperUtils.isNull(period) || HelperUtils.checkIfStrIsBlankOrEmpty(period)) {
                System.out.println("Invalid Input, please enter again");
                period = scanner.nextLine();
            }
            historyBook.setHistoricalPeriod(period);
            System.out.println("Please, Enter The civilization of History book");
            String bookCivi = scanner.nextLine();
            while (HelperUtils.isNull(bookCivi) || HelperUtils.checkIfStrIsBlankOrEmpty(bookCivi)) {
                System.out.println("Invalid Input, please enter again");
                bookCivi = scanner.nextLine();
            }
            historyBook.setCivilization(bookCivi);
            System.out.println("Please, Enter (true/false) is the History book has Maps");
            String includesMaps = scanner.nextLine();
            while (!includesMaps.equalsIgnoreCase("true") && !includesMaps.equalsIgnoreCase("false")) {
                System.out.println("Invalid Input, Please write again");
                includesMaps = scanner.nextLine();
            }
            Boolean hasMaps = Boolean.parseBoolean(includesMaps);
            historyBook.setIncludesMaps(hasMaps);

            return historyBook;
    }

    public static void save(HistoryBook historyBook){
        historybookList.add(historyBook);
        System.out.println("The book data is successfully added");
    }

    public static HistoryBook editBookInput() {
        if(historybookList.isEmpty()){
            System.out.println("No Book available to edit");
            return null;
        }

        System.out.println("Enter the ISBN of the book to edit");
        String iSBN = scanner.nextLine();
        while (HelperUtils.isNull(iSBN) || HelperUtils.checkIfStrIsBlankOrEmpty(iSBN) || !checkIfBookISBNIsExit(iSBN)) {
            System.out.println("Invalid Input, please write again");
            iSBN = scanner.nextLine();
        }
        HistoryBook selectedBook=null;

        for (HistoryBook book : historybookList) {
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
                        1 - historicalPeriod
                        2 - civilization
                        3 - includesMaps
                        4- Exit
                        """);
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> {
                        System.out.println("Enter new historical Period of the book");
                        String historicalPeriod = scanner.nextLine();
                        selectedBook.setHistoricalPeriod(historicalPeriod);
                        System.out.println("historical Period updated successfully.");
                    }
                    case 2 -> {
                        System.out.println("Enter new civilization of the book");
                        String civilization = scanner.nextLine();
                        selectedBook.setCivilization(civilization);
                        System.out.println("civilization updated successfully of the book");
                    }
                    case 3 -> {
                        System.out.println("Enter the update for includesMaps(True/False)");
                        String includesMaps = scanner.nextLine();
                        while (!includesMaps.equalsIgnoreCase("true") && !includesMaps.equalsIgnoreCase("false")) {
                            System.out.println("The input is invalid, please enter (true/false)");
                            includesMaps = scanner.nextLine();
                        }
                        Boolean containsMaps = Boolean.parseBoolean(includesMaps);
                        selectedBook.setIncludesMaps(containsMaps);
                        System.out.println("is includes Maps updated successfully");


                    }

                    case 4 -> {
                        System.out.println("Exiting edit menu...");
                        return selectedBook;
                    }
                    default -> System.out.println("Invalid option, Please Enter a number from Menu");
                }
        return selectedBook;
    }

    public static void update(HistoryBook updatedBook) {
        if (updatedBook == null) {
            System.out.println("No updates to save");
            return;
        }

        for (int i = 0; i < historybookList.size(); i++) {
            if (historybookList.get(i).getiSBN().equals(updatedBook.getiSBN())) {
                historybookList.set(i, updatedBook);
                System.out.println("Book updated successfully.");
                return;
            }
        }
        System.out.println("Updated Book not found in list");
    }


    public static String getBookToRemove() {
        if (historybookList.isEmpty()) {
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
            historybookList.removeIf(book -> book.getiSBN().equals(removeBookByISBN));
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found");
        }
    }


    public static void displayAllBook() {
        if (historybookList.isEmpty()) {
            System.out.println("There are no book Available");
            System.out.println("********************************************");
        }
        System.out.println("The List of The Book");
        System.out.println("********************************************");
        for (HistoryBook historyBook : historybookList) {
            System.out.println(historyBook);
        }
    }

    public static Boolean checkIfBookISBNIsExit(String iSBNToCheck) {
        for (HistoryBook historyBook : historybookList) {
            if (historyBook.getiSBN().equals(iSBNToCheck)) {
                return true;
            }
        }
        return false;
    }
}




