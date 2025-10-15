import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PictureBookService {
    public static List<PictureBook> pictureBookList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static PictureBook addBookInput() {
        PictureBook picturebook = new PictureBook();
        System.out.println("Please, Enter The ISBN of book");
        String bookISBN = scanner.nextLine();
        while (HelperUtils.isNull(bookISBN) || HelperUtils.checkIfStrIsBlankOrEmpty(bookISBN) || checkIfBookISBNIsExit(bookISBN)) {
            System.out.println("Invalid Input,Please try Again");
            bookISBN = scanner.nextLine();
        }
        picturebook.setiSBN(bookISBN);

        System.out.println("Please, Enter illustrator Style of book");
        String illustratorStyle = scanner.nextLine();
        while (HelperUtils.isNull(illustratorStyle) || HelperUtils.checkIfStrIsBlankOrEmpty(illustratorStyle)) {
            System.out.println("Invalied Input, Please write again");
            illustratorStyle = scanner.nextLine();
        }
        picturebook.setIllustratorStyle(illustratorStyle);

        System.out.println("Please, Enter The target Age Range of book");
        String targetAgeRange = scanner.nextLine();
        while (HelperUtils.isNull(targetAgeRange) || HelperUtils.checkIfStrIsBlankOrEmpty(targetAgeRange)) {
            System.out.println("Invalied Input, Please write again");
            targetAgeRange = scanner.nextLine();
        }
        picturebook.setTargetAgeRange(targetAgeRange);

        System.out.println("Please, Enter The word Count Per Page of book");
        Integer wordCountPerPage = scanner.nextInt();
        while (HelperUtils.isNull(wordCountPerPage) || wordCountPerPage < 0) {
            System.out.println("Invalid Input, Please write again");
            wordCountPerPage = scanner.nextInt();
        }
        picturebook.setWordCountPerPage(wordCountPerPage);
        scanner.nextLine();

        return picturebook;
    }

    public static void save(PictureBook book) {
        pictureBookList.add(book);
        System.out.println("The book data is successfully added");
    }

    public static PictureBook editBookInput() {
        if (pictureBookList.isEmpty()) {
            System.out.println("No Book available to edit");
            return null;
        }

        System.out.println("Enter the ISBN of the book to edit");
        String iSBN = scanner.nextLine();
        while (HelperUtils.isNull(iSBN) || HelperUtils.checkIfStrIsBlankOrEmpty(iSBN) || !checkIfBookISBNIsExit(iSBN)) {
            System.out.println("Invalid Input, please write again");
            iSBN = scanner.nextLine();
        }
        PictureBook selectedBook = null;

        for (PictureBook book : pictureBookList) {
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
                1 - illustrator Style
                2 - target Age Range
                3 - word Count Per Page
                4- Exit
                """);
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1 -> {
                System.out.println("Enter new illustrator Style of the book");
                String newIllustratorStyle = scanner.nextLine();
                selectedBook.setIllustratorStyle(newIllustratorStyle);
                System.out.println("Illustrator Style updated successfully.");
            }
            case 2 -> {
                System.out.println("Enter new target Age Range");
                String newTargetAgeRange = scanner.nextLine();
                selectedBook.setTargetAgeRange(newTargetAgeRange);
                System.out.println("target Age Range updated successfully.");
            }
            case 3 -> {
                System.out.println("Enter new word Count Per Page");
                Integer newWordCountPerPage = scanner.nextInt();
                scanner.nextLine();
                selectedBook.setWordCountPerPage(newWordCountPerPage);
                System.out.println("Word Count Per Page updated successfully.");
            }
            case 4 -> {
                System.out.println("Exiting edit menu...");
                return selectedBook;
            }
            default -> System.out.println("Invalid option, Please Enter a number from Menu");
        }
        return selectedBook;
    }

    public static void update(PictureBook updatedBook) {
        if (updatedBook == null) {
            System.out.println("No updates to save");
            return;
        }

        for (int i = 0; i < pictureBookList.size(); i++) {
            if (pictureBookList.get(i).getiSBN().equals(updatedBook.getiSBN())) {
                pictureBookList.set(i, updatedBook);
                System.out.println("Book updated successfully.");
                return;
            }
        }
        System.out.println("Updated Book not found in list");
    }


    public static String getBookToRemove() {
        if (pictureBookList.isEmpty()) {
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
            pictureBookList.removeIf(book -> book.getiSBN().equals(removeBookByISBN));
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found");
        }
    }


    public static void displayAllBook() {
        if (pictureBookList.isEmpty()) {
            System.out.println("There are no book Available");
            System.out.println("********************************************");
        }
        System.out.println("The List of The Book");
        System.out.println("********************************************");
        for (PictureBook book : pictureBookList) {
            System.out.println(book);
        }
    }


    public static Boolean checkIfBookISBNIsExit(String iSBNToCheck) {
        for (PictureBook book : pictureBookList) {
            if (book.getiSBN().equals(iSBNToCheck)) {
                return true;
            }
        }
        return false;
    }

}
