import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InteractiveBookService {
    public static List<InteractiveBook> interactiveBookList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void addBook() {
        Boolean continueInput = true;
        while (continueInput) {
            InteractiveBook interactiveBook = new InteractiveBook();
            System.out.println("Please, Enter The ISBN of book");
            String bookISBN = scanner.nextLine();
            while (HelperUtils.isNull(bookISBN) || HelperUtils.checkIfStrIsBlankOrEmpty(bookISBN)) {
                System.out.println("Invalid Input,Please try Again");
                bookISBN = scanner.nextLine();
            }
            interactiveBook.setiSBN(bookISBN);

            System.out.println("Please, Enter iinteractive Element of book");
            String interactiveElement= scanner.nextLine();
            while (HelperUtils.isNull(interactiveElement) || HelperUtils.checkIfStrIsBlankOrEmpty(interactiveElement)) {
                System.out.println("Invalied Input, Please write again");
                interactiveElement = scanner.nextLine();
            }
            interactiveBook.setInteractiveElement(interactiveElement);

            System.out.println("Please, Enter sensory Engagement of book");
            String sensoryEngagement = scanner.nextLine();
            while (HelperUtils.isNull(sensoryEngagement) || HelperUtils.checkIfStrIsBlankOrEmpty(sensoryEngagement)) {
                System.out.println("Invalied Input, Please write again");
                sensoryEngagement = scanner.nextLine();
            }
            interactiveBook.setSensoryEngagement(sensoryEngagement);

            System.out.println("Please, Enter The durability Rating of book");
            String durabilityRating = scanner.nextLine();
            while (HelperUtils.isNull(durabilityRating) || HelperUtils.checkIfStrIsBlankOrEmpty(durabilityRating)) {
                System.out.println("Invalied Input, Please write again");
                durabilityRating = scanner.nextLine();
            }
            interactiveBook.setDurabilityRating(durabilityRating);
            scanner.nextLine();

            interactiveBookList.add(interactiveBook);

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
        for (InteractiveBook book : interactiveBookList) {
            if (book.getiSBN().equals(iSBN)) {
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
                        book.setInteractiveElement(newInteractiveElement);
                        System.out.println("interactive Element updated successfully.");
                    }
                    case 2 -> {
                        System.out.println("Enter new sensory Engagement");
                        String newSensoryEngagement = scanner.nextLine();
                        book.setSensoryEngagement(newSensoryEngagement);
                        System.out.println("Sensory Engagement updated successfully.");
                    }
                    case 3 -> {
                        System.out.println("Enter new durability Rating");
                        String newDurabilityRating = scanner.nextLine();
                        scanner.nextLine();
                        book.setDurabilityRating(newDurabilityRating);
                        System.out.println("Durability Rating updated successfully.");
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
        Boolean removed = interactiveBookList.removeIf(book -> book.getiSBN().equals(iSBNToRemove));
        if (removed) {
            System.out.println("The the book is successfully removed");

        } else {
            System.out.println("There are no Book with this ISBN,Please Enter another ISBN");
            removeISBN = scanner.nextLine();
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
