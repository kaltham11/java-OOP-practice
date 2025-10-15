import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FableCollectionService {

    public static List<FableCollection> fableCollectionBookList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static FableCollection addBookInput() {
        FableCollection fableCollectionBook = new FableCollection();
        System.out.println("Please, Enter The International Standard Book Number(ISBN) of book");
        String iSBN = scanner.nextLine();
        while (HelperUtils.isNull(iSBN) || HelperUtils.checkIfStrIsBlankOrEmpty(iSBN) || checkIfBookISBNIsExit(iSBN)) {
            System.out.println("Invalid Input,Please try Again");
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

        return fableCollectionBook;
    }

    public static void save(FableCollection book) {
        fableCollectionBookList.add(book);
        System.out.println("The book data is successfully added");
    }

    public static FableCollection editBookInput() {
        if (fableCollectionBookList.isEmpty()) {
            System.out.println("No Book available to edit");
            return null;
        }

        System.out.println("Enter the ISBN of the book to edit");
        String iSBN = scanner.nextLine();
        while (HelperUtils.isNull(iSBN) || HelperUtils.checkIfStrIsBlankOrEmpty(iSBN) || !checkIfBookISBNIsExit(iSBN)) {
            System.out.println("Invalid Input, please write again");
            iSBN = scanner.nextLine();
        }
        FableCollection selectedBook = null;

        for (FableCollection book : fableCollectionBookList) {
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
                selectedBook.setMoralLesson(moralLesson);
                System.out.println("moral Lesson updated successfully.");
            }
            case 2 -> {
                System.out.println("Enter new cultural Origin of the book");
                String culturalOrigin = scanner.nextLine();
                selectedBook.setCulturalOrigin(culturalOrigin);
                System.out.println("cultural Origin updated successfully of the book");
            }
            case 3 -> {
                System.out.println("Enter the update for has anthropomorphic Characters(True/False)");
                String anthropomorphicCharacters = scanner.nextLine();
                while (!anthropomorphicCharacters.equalsIgnoreCase("true") && !anthropomorphicCharacters.equalsIgnoreCase("false")) {
                    System.out.println("The input is invalid, please enter (true/false)");
                    anthropomorphicCharacters = scanner.nextLine();
                }
                Boolean hasAnthropomorphicCharacters = Boolean.parseBoolean(anthropomorphicCharacters);
                selectedBook.setAnthropomorphicCharacters(hasAnthropomorphicCharacters);
                System.out.println("Anthropomorphic Characters updated successfully");
            }

            case 4 -> {
                System.out.println("Exiting edit menu...");
                return selectedBook;
            }
            default -> System.out.println("Invalid option, Please Enter a number from Menu");
        }
        return selectedBook;
    }

    public static void update(FableCollection updatedBook) {
        if (updatedBook == null) {
            System.out.println("No updates to save");
            return;
        }

        for (int i = 0; i < fableCollectionBookList.size(); i++) {
            if (fableCollectionBookList.get(i).getiSBN().equals(updatedBook.getiSBN())) {
                fableCollectionBookList.set(i, updatedBook);
                System.out.println("Book updated successfully.");
                return;
            }
        }
        System.out.println("Updated Book not found in list");
    }


    public static String getBookToRemove() {
        if (fableCollectionBookList.isEmpty()) {
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
            fableCollectionBookList.removeIf(book -> book.getiSBN().equals(removeBookByISBN));
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found");
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
