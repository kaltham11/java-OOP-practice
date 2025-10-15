import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MysteryNovelService {
    public static List<MysteryNovel> mysteryNovelBookList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static MysteryNovel addBookInput() {
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
                System.out.println("Invalid Input, Please write again");
                centralCrime = scanner.nextLine();
            }
            mysteryNovelBook.setCentralCrime(centralCrime);

            System.out.println("Please, Enter The reveal Timing of book");
            String revealTiming = scanner.nextLine();
            while (HelperUtils.isNull(revealTiming) || HelperUtils.checkIfStrIsBlankOrEmpty(revealTiming)) {
                System.out.println("Invalid Input, Please write again");
                revealTiming = scanner.nextLine();
            }
            mysteryNovelBook.setRevealTiming(revealTiming);

            return mysteryNovelBook;
    }

    public static void save(MysteryNovel book) {
        mysteryNovelBookList.add(book);
        System.out.println("The book data is successfully added");
    }

    public static MysteryNovel editBookInput() {
        if (mysteryNovelBookList.isEmpty()) {
            System.out.println("No Book available to edit");
            return null;
        }

        System.out.println("Enter the ISBN of the book to edit");
        String iSBN = scanner.nextLine();
        while (HelperUtils.isNull(iSBN) || HelperUtils.checkIfStrIsBlankOrEmpty(iSBN) || !checkIfBookISBNIsExit(iSBN)) {
            System.out.println("Invalid Input, please write again");
            iSBN = scanner.nextLine();
        }
        MysteryNovel selectedBook = null;

        for (MysteryNovel book : mysteryNovelBookList) {
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
                        selectedBook.setDetectiveArchetype(newDetectiveArchetype);
                        System.out.println("Detective Archetype updated successfully.");
                    }
                    case 2 -> {
                        System.out.println("Enter new central Crime");
                        String newCentralCrime = scanner.nextLine();
                        selectedBook.setCentralCrime(newCentralCrime);
                        System.out.println("central Crime updated successfully.");
                    }
                    case 3 -> {
                        System.out.println("Enter new reveal Timing");
                        String newRevealTiming = scanner.nextLine();
                        selectedBook.setRevealTiming(newRevealTiming);
                        System.out.println("reveal Timing updated successfully.");
                    }
                    case 4 -> {
                        System.out.println("Exiting edit menu...");
                        return selectedBook;
                    }
                    default -> System.out.println("Invalid option, Please Enter a number from Menu");
                }

                return selectedBook;
    }

    public static void update(MysteryNovel updatedBook) {
        if (updatedBook == null) {
            System.out.println("No updates to save");
            return;
        }

        for (int i = 0; i < mysteryNovelBookList.size(); i++) {
            if (mysteryNovelBookList.get(i).getiSBN().equals(updatedBook.getiSBN())) {
                mysteryNovelBookList.set(i, updatedBook);
                System.out.println("Book updated successfully.");
                return;
            }
        }
        System.out.println("Updated Book not found in list");
    }


    public static String getBookToRemove() {
        if (mysteryNovelBookList.isEmpty()) {
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
            mysteryNovelBookList.removeIf(book -> book.getiSBN().equals(removeBookByISBN));
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found");
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
