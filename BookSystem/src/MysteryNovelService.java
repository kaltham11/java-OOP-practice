import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MysteryNovelService {
    public static List<MysteryNovel> mysteryNovelBookList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void addBook() {
        Boolean continueInput = true;
        while (continueInput) {
            MysteryNovel mysteryNovelBook = new MysteryNovel();
            System.out.println("Please, Enter The ISBN of book");
            String bookISBN = scanner.nextLine();
            while (HelperUtils.isNull(bookISBN) || HelperUtils.checkIfStrIsBlankOrEmpty(bookISBN)
                    || checkIfBookISBNIsExit(bookISBN)) {
                System.out.println("Invalid Input,Please try Again");
                bookISBN = scanner.nextLine();
            }
            mysteryNovelBook.setiSBN(bookISBN);

            System.out.println("Please, Enter detective Archetype of book");
            String detectiveArchetype= scanner.nextLine();
            while (HelperUtils.isNull(detectiveArchetype) || HelperUtils.checkIfStrIsBlankOrEmpty(detectiveArchetype)) {
                System.out.println("Invalied Input, Please write again");
                detectiveArchetype = scanner.nextLine();
            }
            mysteryNovelBook.setDetectiveArchetype(detectiveArchetype);

            System.out.println("Please, Enter central Crime of book");
            String centralCrime = scanner.nextLine();
            while (HelperUtils.isNull(centralCrime) || HelperUtils.checkIfStrIsBlankOrEmpty(centralCrime)) {
                System.out.println("Invalied Input, Please write again");
                centralCrime = scanner.nextLine();
            }
            mysteryNovelBook.setCentralCrime(centralCrime);

            System.out.println("Please, Enter The reveal Timing of book");
            String revealTiming = scanner.nextLine();
            while (HelperUtils.isNull(revealTiming) || HelperUtils.checkIfStrIsBlankOrEmpty(revealTiming)) {
                System.out.println("Invalied Input, Please write again");
                revealTiming = scanner.nextLine();
            }
            mysteryNovelBook.setRevealTiming(revealTiming);

            mysteryNovelBookList.add(mysteryNovelBook);

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
        for (MysteryNovel book : mysteryNovelBookList) {
            if (book.getiSBN().equals(iSBN)) {
                System.out.println("Which attribute would you like to edit?");
                System.out.println("""
                        1 - detective Archetype
                        2 - central Crime
                        3 - reveal Timing
                        4- Exit
                        """);
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> {
                        System.out.println("Enter new detective Archetype of the book");
                        String newDetectiveArchetype = scanner.nextLine();
                        book.setDetectiveArchetype(newDetectiveArchetype);
                        System.out.println("Detective Archetype updated successfully.");
                    }
                    case 2 -> {
                        System.out.println("Enter new central Crime");
                        String newCentralCrime = scanner.nextLine();
                        book.setCentralCrime(newCentralCrime);
                        System.out.println("central Crime updated successfully.");
                    }
                    case 3 -> {
                        System.out.println("Enter new reveal Timing");
                        String newRevealTiming = scanner.nextLine();
                        book.setRevealTiming(newRevealTiming);
                        System.out.println("reveal Timing updated successfully.");
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
        Boolean removed = mysteryNovelBookList.removeIf(book -> book.getiSBN().equals(iSBNToRemove));
        if (removed) {
            System.out.println("The the book is successfully removed");

        } else {
            System.out.println("There are no Book with this ISBN,Please Enter another ISBN");
            removeISBN = scanner.nextLine();
        }
    }


    public static void displayAllBook() {
        if (mysteryNovelBookList.isEmpty()) {
            System.out.println("There are no book Available");
            System.out.println("********************************************");
        }
        System.out.println("The List of The Book");
        System.out.println("********************************************");
        for (MysteryNovel book : mysteryNovelBookList) {
            System.out.println(book);
        }
    }




    public static Boolean checkIfBookISBNIsExit(String iSBNToCheck) {
        for (MysteryNovel book : mysteryNovelBookList) {
            if (book.getiSBN().equals(iSBNToCheck)) {
                return true;
            }
        }
        return false;
    }
}
