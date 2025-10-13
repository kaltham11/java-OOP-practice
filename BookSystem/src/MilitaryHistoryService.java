import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MilitaryHistoryService {

        public static List<MilitaryHistory> militaryHistoryBookList = new ArrayList<>();
        public static Scanner scanner = new Scanner(System.in);

        public static void addBook() {
            Boolean continueInput = true;
            while (continueInput) {
                MilitaryHistory militaryHistorybook = new MilitaryHistory();
                System.out.println("Please, Enter The ISBN of book");
                String bookISBN = scanner.nextLine();
                while (HelperUtils.isNull(bookISBN) || HelperUtils.checkIfStrIsBlankOrEmpty(bookISBN)) {
                    System.out.println("This Book ISBN is already exits in out Records," +
                            "Please Enter another ID");
                    bookISBN = scanner.nextLine();
                }
                militaryHistorybook.setiSBN(bookISBN);
                scanner.nextLine();
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
                Boolean hasstrategicMapsIncluded = Boolean.parseBoolean(strategicMapsIncluded);
                militaryHistorybook.setStrategicMapsIncluded(hasstrategicMapsIncluded);
                militaryHistoryBookList.add(militaryHistorybook);
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
            for (MilitaryHistory book : militaryHistoryBookList) {
                if (book.getiSBN().equals(iSBN)) {
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
                            book.setConflictFocus(newConflictFocus);
                            System.out.println("Conflict Focus updated successfully.");
                        }
                        case 2 -> {
                            System.out.println("Enter new technological Analysis");
                            String newTechnologicalAnalysis = scanner.nextLine();
                            book.setTechnologicalAnalysis(newTechnologicalAnalysis);
                            System.out.println("Technological Analysis updated successfully.");
                        }
                        case 3 -> {
                            System.out.println("Enter the update for is strategic Maps Included(True/False)");
                            String mapsIncluded = scanner.nextLine();
                            if (mapsIncluded.equalsIgnoreCase("true") && mapsIncluded.equalsIgnoreCase("false")) {
                                Boolean isMapsIncluded = Boolean.parseBoolean(mapsIncluded);
                                book.setStrategicMapsIncluded(isMapsIncluded);
                                System.out.println("strategic Maps Included updated successfully");
                            }
                            System.out.println("The input is invalid, please enter (true/false)");
                            mapsIncluded = scanner.nextLine();

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
            Boolean removed = militaryHistoryBookList.removeIf(book -> book.getiSBN().equals(iSBNToRemove));
            if (removed) {
                System.out.println("The the book is successfully removed");

            } else {
                System.out.println("There are no Book with this ISBN,Please Enter another ISBN");
                removeISBN = scanner.nextLine();
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


