import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScienceFictionNovelService {

    public static List<ScienceFictionNovel> scienceFictionBookList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void addBook() {
        Boolean continueInput = true;
        while (continueInput) {
            ScienceFictionNovel book = new ScienceFictionNovel();
            System.out.println("Please, Enter The International Standard Book Number(ISBN) of book");
            String iSBN = scanner.nextLine();
            while (HelperUtils.isNull(iSBN) || HelperUtils.checkIfStrIsBlankOrEmpty(iSBN) || checkIfBookISBNIsExit(iSBN)) {
                System.out.println("This Book ISBN is already exits in out Records," +
                        "Please Enter another ISBN");
                iSBN = scanner.nextLine();
            }
            book.setiSBN(iSBN);

            System.out.println("Please, Enter The speculative Technology of book");
            String speculativeTechnology = scanner.nextLine();
            while (HelperUtils.isNull(speculativeTechnology) || HelperUtils.checkIfStrIsBlankOrEmpty(speculativeTechnology)) {
                System.out.println("Invalid Input, please enter again");
                speculativeTechnology = scanner.nextLine();
            }
            book.setSpeculativeTechnology(speculativeTechnology);

            System.out.println("Please, Enter The subgenre book");
            String subgenre = scanner.nextLine();
            while (HelperUtils.isNull(subgenre) || HelperUtils.checkIfStrIsBlankOrEmpty(subgenre)) {
                System.out.println("Invalid Input, please enter again");
                subgenre = scanner.nextLine();
            }
            book.setSubgenre(subgenre);

            System.out.println("Please, Enter (true/false) of the scientific Plausibility");
            String scientificPlausibility = scanner.nextLine();
            while (!scientificPlausibility.equalsIgnoreCase("true") && !scientificPlausibility.equalsIgnoreCase("false")) {
                System.out.println("Invalid Input, Please write again");
                scientificPlausibility = scanner.nextLine();
            }
            Boolean hasScientificPlausibility = Boolean.parseBoolean(scientificPlausibility);
            book.setScientificPlausibility(hasScientificPlausibility);
            scienceFictionBookList.add(book);
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
        for (ScienceFictionNovel book : scienceFictionBookList) {
            if (book.getiSBN().equals(iSBN)) {
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
                        book.setSpeculativeTechnology(speculativeTechnology);
                        System.out.println("Speculative Technology updated successfully.");
                    }
                    case 2 -> {
                        System.out.println("Enter new subgenre of the book");
                        String subgenre = scanner.nextLine();
                        book.setSubgenre(subgenre);
                        System.out.println("subgenre updated successfully of the book");
                    }
                    case 3 -> {
                        System.out.println("Enter the update for scientific Plausibility(True/False)");
                        String scientificPlausibility = scanner.nextLine();
                        if (scientificPlausibility.equalsIgnoreCase("true") || scientificPlausibility.equalsIgnoreCase("false")) {
                            Boolean isScientificPlausibility = Boolean.parseBoolean(scientificPlausibility);
                            book.setScientificPlausibility(isScientificPlausibility);
                            System.out.println("Scientific Plausibility updated successfully");
                        }
                        System.out.println("The input is invalid, please enter (true/false)");
                        scientificPlausibility = scanner.nextLine();

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
        Boolean removed = scienceFictionBookList.removeIf(book -> book.getiSBN().equals(iSBNToRemove));
        if (removed) {
            System.out.println("The the book is successfully removed");

        } else {
            System.out.println("There are no Book with this ISBN,Please Enter another ISBN");
            removeISBN = scanner.nextLine();
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
