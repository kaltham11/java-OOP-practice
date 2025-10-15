import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SocialHistoryService {
    public static List<SocialHistory> socialHistoryBookList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static SocialHistory addBookInput() {
            SocialHistory socialHistorybook = new SocialHistory();
            System.out.println("Please, Enter The ISBN of book");
            String bookISBN = scanner.nextLine();
            while (HelperUtils.isNull(bookISBN) || HelperUtils.checkIfStrIsBlankOrEmpty(bookISBN)||checkIfBookISBNIsExit(bookISBN)) {
                System.out.println("Invalid Input,Please try Again");
                bookISBN = scanner.nextLine();
            }
            socialHistorybook.setiSBN(bookISBN);
            System.out.println("Please, Enter cultural Focus of book");
            String culturalFocus= scanner.nextLine();
            while (HelperUtils.isNull(culturalFocus) || HelperUtils.checkIfStrIsBlankOrEmpty(culturalFocus)) {
                System.out.println("Invalied Input, Please write again");
                culturalFocus = scanner.nextLine();
            }
            socialHistorybook.setCulturalFocus(culturalFocus);
            System.out.println("Please, Enter The time Period of book");
            String timePeriod = scanner.nextLine();
            while (HelperUtils.isNull(timePeriod) || HelperUtils.checkIfStrIsBlankOrEmpty(timePeriod)) {
                System.out.println("Invalied Input, Please write again");
                timePeriod = scanner.nextLine();
            }
            socialHistorybook.setTimePeriod(timePeriod);

            System.out.println("Please, Enter The geographical Scope of book");
            String geographicalScope = scanner.nextLine();
            while (HelperUtils.isNull(geographicalScope) || HelperUtils.checkIfStrIsBlankOrEmpty(geographicalScope)) {
                System.out.println("Invalied Input, Please write again");
                geographicalScope = scanner.nextLine();
            }
            socialHistorybook.setCulturalArtifactsDiscussed(geographicalScope);

            return socialHistorybook;
    }

    public static void save(SocialHistory book){
        socialHistoryBookList.add(book);
        System.out.println("The book data is successfully added");
    }

    public static SocialHistory editBookInput() {
        if (socialHistoryBookList.isEmpty()) {
            System.out.println("No Book available to edit");
            return null;
        }

        System.out.println("Enter the ISBN of the book to edit");
        String iSBN = scanner.nextLine();
        while (HelperUtils.isNull(iSBN) || HelperUtils.checkIfStrIsBlankOrEmpty(iSBN) || !checkIfBookISBNIsExit(iSBN)) {
            System.out.println("Invalid Input, please write again");
            iSBN = scanner.nextLine();
        }
        SocialHistory selectedBook = null;

        for (SocialHistory book : socialHistoryBookList) {
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
                        1 - culturalFocus
                        2 - timePeriod
                        3 - geographicalScope
                        4- Exit
                        """);
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> {
                        System.out.println("Enter new cultural Focus of the book");
                        String newCulturalFocus = scanner.nextLine();
                        selectedBook.setCulturalFocus(newCulturalFocus);
                        System.out.println("cultural Focus updated successfully.");
                    }
                    case 2 -> {
                        System.out.println("Enter new time Period");
                        String newTimePeriod = scanner.nextLine();
                        selectedBook.setTimePeriod(newTimePeriod);
                        System.out.println("Time Period updated successfully.");
                    }
                    case 3 -> {
                        System.out.println("Enter new geographical Scope");
                        String newGeographicalScope = scanner.nextLine();
                        selectedBook.setCulturalArtifactsDiscussed(newGeographicalScope);
                        System.out.println("Geographical Scope updated successfully.");
                    }
                    case 4 -> {
                        System.out.println("Exiting edit menu...");
                        return selectedBook;
                    }
                    default -> System.out.println("Invalid option, Please Enter a number from Menu");
                }

        return selectedBook;
    }

    public static void update(SocialHistory updatedBook) {
        if (updatedBook == null) {
            System.out.println("No updates to save");
            return;
        }

        for (int i = 0; i < socialHistoryBookList.size(); i++) {
            if (socialHistoryBookList.get(i).getiSBN().equals(updatedBook.getiSBN())) {
                socialHistoryBookList.set(i, updatedBook);
                System.out.println("Book updated successfully.");
                return;
            }
        }
        System.out.println("Updated Book not found in list");
    }


    public static String getBookToRemove() {
        if (socialHistoryBookList.isEmpty()) {
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
            socialHistoryBookList.removeIf(book -> book.getiSBN().equals(removeBookByISBN));
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found");
        }
    }


    public static void displayAllBook() {
        if (socialHistoryBookList.isEmpty()) {
            System.out.println("There are no book Available");
            System.out.println("********************************************");
        }
        System.out.println("The List of The Book");
        System.out.println("********************************************");
        for (SocialHistory book : socialHistoryBookList) {
            System.out.println(book);
        }
    }




    public static Boolean checkIfBookISBNIsExit(String iSBNToCheck) {
        for (SocialHistory book : socialHistoryBookList) {
            if (book.getiSBN().equals(iSBNToCheck)) {
                return true;
            }
        }
        return false;
    }

}
