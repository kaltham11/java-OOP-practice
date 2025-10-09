import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HistoryBookService {

    public static List<HistoryBook> historybookList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void addBook() {
        Boolean continueInput = true;
        while (continueInput) {
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
            historybookList.add(historyBook);
            System.out.println("The book data is successfully added");
            System.out.println("**************************************************");
            System.out.println("Press (q)+followed by Enter to quite, otherwise press Enter to continue");
            String exitFlag = scanner.nextLine();
            if (exitFlag.equalsIgnoreCase("q")) {
                continueInput = false;
            }
        }
    }

    public static void editBook() {
        System.out.println("Enter the ISBN of the book to edit");
        String iSBN = scanner.nextLine();
        while (HelperUtils.isNull(iSBN) || HelperUtils.checkIfStrIsBlankOrEmpty(iSBN) || !checkIfBookISBNIsExit(iSBN)) {
            System.out.println("Invalid Input, please write again");
            iSBN = scanner.nextLine();
        }
        for (HistoryBook historyBook : historybookList) {
            if (historyBook.getiSBN().equals(iSBN)) {
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
                        historyBook.setiSBN(historicalPeriod);
                        System.out.println("historical Period updated successfully.");
                    }
                    case 2 -> {
                        System.out.println("Enter new civilization of the book");
                        String civilization = scanner.nextLine();
                        historyBook.setCivilization(civilization);
                        System.out.println("civilization updated successfully of the book");
                    }
                    case 3 -> {
                        System.out.println("Enter the update for includesMaps(True/False)");
                        String includesMaps = scanner.nextLine();
                        if (includesMaps.equalsIgnoreCase("true") && includesMaps.equalsIgnoreCase("false")) {
                            Boolean containsMaps = Boolean.parseBoolean(includesMaps);
                            historyBook.setIncludesMaps(containsMaps);
                            System.out.println("is includes Maps updated successfully");
                        }
                        System.out.println("The input is invalid, please enter (true/false)");
                        includesMaps = scanner.nextLine();

                    }

                    case 4 -> {
                        return;
                    }
                    default -> System.out.println("Invalid option, Please Enter a number from Menu");
                }

            }
        }
    }

    public static void removeBook() {
        System.out.println("Please, Enter The International Standard Book Number(ISBN) of book to remove it");
        String removeISBN = scanner.nextLine();
        while (HelperUtils.isNull(removeISBN) || HelperUtils.checkIfStrIsBlankOrEmpty(removeISBN)) {
            System.out.println("Invalid ISBN ,Please Enter another ISBN");
            removeISBN = scanner.nextLine();
        }
        final String iSBNToRemove = removeISBN;
        Boolean removed = historybookList.removeIf(book -> book.getiSBN().equals(iSBNToRemove));
        if (removed) {
            System.out.println("The the book is successfully removed");

        } else {
            System.out.println("There are no Book with this ISBN,Please Enter another ISBN");
            removeISBN = scanner.nextLine();
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




