import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FableCollectionService {

    public static List<FableCollection> fableCollectionBookList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void addBook() {
        Boolean continueInput = true;
        while (continueInput) {
            FableCollection fableCollectionBook = new FableCollection();
            System.out.println("Please, Enter The International Standard Book Number(ISBN) of book");
            String iSBN = scanner.nextLine();
            while (HelperUtils.isNull(iSBN) || HelperUtils.checkIfStrIsBlankOrEmpty(iSBN) || checkIfBookISBNIsExit(iSBN)) {
                System.out.println("This Book ISBN is already exits in out Records," +
                        "Please Enter another ISBN");
                iSBN = scanner.nextLine();
            }
            fableCollectionBook.setiSBN(iSBN);

            System.out.println("Please, Enter The moral Lesson of book");
            String moralLesson = scanner.nextLine();
            while (HelperUtils.isNull(moralLesson) || HelperUtils.checkIfStrIsBlankOrEmpty(moralLesson)) {
                System.out.println("Invalid Input, please enter again");
                moralLesson = scanner.nextLine();
            }
            fableCollectionBook.setMoralLesson(moralLesson);
            System.out.println("Please, Enter The cultural Origin book");
            String culturalOrigin = scanner.nextLine();
            while (HelperUtils.isNull(culturalOrigin) || HelperUtils.checkIfStrIsBlankOrEmpty(culturalOrigin)) {
                System.out.println("Invalid Input, please enter again");
                culturalOrigin = scanner.nextLine();
            }
            fableCollectionBook.setCulturalOrigin(culturalOrigin);

            System.out.println("Please, Enter (true/false) is the anthropomorphic Characters in the book");
            String anthropomorphicCharacters = scanner.nextLine();
            while (!anthropomorphicCharacters.equalsIgnoreCase("true") && !anthropomorphicCharacters.equalsIgnoreCase("false")) {
                System.out.println("Invalid Input, Please write again");
                anthropomorphicCharacters = scanner.nextLine();
            }
            Boolean hasAnthropomorphicCharacters = Boolean.parseBoolean(anthropomorphicCharacters);
            fableCollectionBook.setAnthropomorphicCharacters(hasAnthropomorphicCharacters);
            fableCollectionBookList.add(fableCollectionBook);
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
        for (FableCollection book : fableCollectionBookList) {
            if (book.getiSBN().equals(iSBN)) {
                System.out.println("Which attribute would you like to edit?");
                System.out.println("""
                        1 - moral Lesson
                        2 - cultural Origin
                        3 - Anthropomorphic Characters
                        4- Exit
                        """);
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> {
                        System.out.println("Enter new moral Lesson of the book");
                        String moralLesson = scanner.nextLine();
                        book.setMoralLesson(moralLesson);
                        System.out.println("moral Lesson updated successfully.");
                    }
                    case 2 -> {
                        System.out.println("Enter new cultural Origin of the book");
                        String culturalOrigin = scanner.nextLine();
                        book.setCulturalOrigin(culturalOrigin);
                        System.out.println("cultural Origin updated successfully of the book");
                    }
                    case 3 -> {
                        System.out.println("Enter the update for has anthropomorphic Characters(True/False)");
                        String anthropomorphicCharacters = scanner.nextLine();
                        if (anthropomorphicCharacters.equalsIgnoreCase("true") || anthropomorphicCharacters.equalsIgnoreCase("false")) {
                            Boolean hasAnthropomorphicCharacters = Boolean.parseBoolean(anthropomorphicCharacters);
                            book.setAnthropomorphicCharacters(hasAnthropomorphicCharacters);
                            System.out.println("Anthropomorphic Characters updated successfully");
                        }
                        System.out.println("The input is invalid, please enter (true/false)");
                        anthropomorphicCharacters = scanner.nextLine();

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
        Boolean removed = fableCollectionBookList.removeIf(book -> book.getiSBN().equals(iSBNToRemove));
        if (removed) {
            System.out.println("The the book is successfully removed");

        } else {
            System.out.println("There are no Book with this ISBN,Please Enter another ISBN");
            removeISBN = scanner.nextLine();
        }
    }

    public static void displayAllBook() {
        if (fableCollectionBookList.isEmpty()) {
            System.out.println("There are no book Available");
            System.out.println("********************************************");
        }
        System.out.println("The List of The Book");
        System.out.println("********************************************");
        for (FableCollection book : fableCollectionBookList) {
            System.out.println(book);
        }
    }

    public static Boolean checkIfBookISBNIsExit(String iSBNToCheck) {
        for (FableCollection book : fableCollectionBookList) {
            if (book.getiSBN().equals(iSBNToCheck)) {
                return true;
            }
        }
        return false;
    }
}
