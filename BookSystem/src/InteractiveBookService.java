import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InteractiveBookService {
    public static List<InteractiveBook> interactiveBookList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static InteractiveBook addBookInput() {
        InteractiveBook interactiveBook = new InteractiveBook();
        System.out.println("Please, Enter The ISBN of book");
        String bookISBN = scanner.nextLine();
        while (HelperUtils.isNull(bookISBN) || HelperUtils.checkIfStrIsBlankOrEmpty(bookISBN)) {
            System.out.println("Invalid Input,Please try Again");
            bookISBN = scanner.nextLine();
        }
        interactiveBook.setiSBN(bookISBN);

        System.out.println("Please, Enter iinteractive Element of book");
        String interactiveElement = scanner.nextLine();
        while (HelperUtils.isNull(interactiveElement) || HelperUtils.checkIfStrIsBlankOrEmpty(interactiveElement)) {
            System.out.println("Invalid Input, Please write again");
            interactiveElement = scanner.nextLine();
        }
        interactiveBook.setInteractiveElement(interactiveElement);

        System.out.println("Please, Enter sensory Engagement of book");
        String sensoryEngagement = scanner.nextLine();
        while (HelperUtils.isNull(sensoryEngagement) || HelperUtils.checkIfStrIsBlankOrEmpty(sensoryEngagement)) {
            System.out.println("Invalid Input, Please write again");
            sensoryEngagement = scanner.nextLine();
        }
        interactiveBook.setSensoryEngagement(sensoryEngagement);

        System.out.println("Please, Enter The durability Rating of book");
        String durabilityRating = scanner.nextLine();
        while (HelperUtils.isNull(durabilityRating) || HelperUtils.checkIfStrIsBlankOrEmpty(durabilityRating)) {
            System.out.println("Invalid Input, Please write again");
            durabilityRating = scanner.nextLine();
        }
        interactiveBook.setDurabilityRating(durabilityRating);

        return interactiveBook;
    }

    public static void save(InteractiveBook book) {
        interactiveBookList.add(book);
        System.out.println("The book data is successfully added");
    }

    public static InteractiveBook editBookInput() {
        if (interactiveBookList.isEmpty()) {
            System.out.println("No Book available to edit");
            return null;
        }

        System.out.println("Enter the ISBN of the book to edit");
        String iSBN = scanner.nextLine();
        while (HelperUtils.isNull(iSBN) || HelperUtils.checkIfStrIsBlankOrEmpty(iSBN) || !checkIfBookISBNIsExit(iSBN)) {
            System.out.println("Invalid Input, please write again");
            iSBN = scanner.nextLine();
        }
        InteractiveBook selectedBook = null;

        for (InteractiveBook book : interactiveBookList) {
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
                1 - interactive Element
                2 - sensory Engagement
                3 - durability Rating
                4- Exit
                """);
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1 -> {
                System.out.println("Enter new interactive Element of the book");
                String newInteractiveElement = scanner.nextLine();
                selectedBook.setInteractiveElement(newInteractiveElement);
                System.out.println("interactive Element updated successfully.");
            }
            case 2 -> {
                System.out.println("Enter new sensory Engagement");
                String newSensoryEngagement = scanner.nextLine();
                selectedBook.setSensoryEngagement(newSensoryEngagement);
                System.out.println("Sensory Engagement updated successfully.");
            }
            case 3 -> {
                System.out.println("Enter new durability Rating");
                String newDurabilityRating = scanner.nextLine();
                scanner.nextLine();
                selectedBook.setDurabilityRating(newDurabilityRating);
                System.out.println("Durability Rating updated successfully.");
            }
            case 4 -> {
                System.out.println("Exiting edit menu...");
                return selectedBook;
            }
            default -> System.out.println("Invalid option, Please Enter a number from Menu");
        }
        return selectedBook;
    }

    public static void update(InteractiveBook updatedBook) {
        if (updatedBook == null) {
            System.out.println("No updates to save");
            return;
        }

        for (int i = 0; i < interactiveBookList.size(); i++) {
            if (interactiveBookList.get(i).getiSBN().equals(updatedBook.getiSBN())) {
                interactiveBookList.set(i, updatedBook);
                System.out.println("Book updated successfully.");
                return;
            }
        }
        System.out.println("Updated Book not found in list");
    }


    public static String getBookToRemove() {
        if (interactiveBookList.isEmpty()) {
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
            interactiveBookList.removeIf(book -> book.getiSBN().equals(removeBookByISBN));
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found");
        }
    }


    public static void displayAllBook() {
        if (interactiveBookList.isEmpty()) {
            System.out.println("There are no book Available");
            System.out.println("********************************************");
        }
        System.out.println("The List of The Book");
        System.out.println("********************************************");
        for (InteractiveBook book : interactiveBookList) {
            System.out.println(book);
        }
    }


    public static Boolean checkIfBookISBNIsExit(String iSBNToCheck) {
        for (InteractiveBook book : interactiveBookList) {
            if (book.getiSBN().equals(iSBNToCheck)) {
                return true;
            }
        }
        return false;
    }

}
