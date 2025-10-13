import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PictureBookService {
    public static List<PictureBook> pictureBookList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void addBook() {
        Boolean continueInput = true;
        while (continueInput) {
            PictureBook picturebook = new PictureBook();
            System.out.println("Please, Enter The ISBN of book");
            String bookISBN = scanner.nextLine();
            while (HelperUtils.isNull(bookISBN) || HelperUtils.checkIfStrIsBlankOrEmpty(bookISBN)) {
                System.out.println("Invalid Input,Please try Again");
                bookISBN = scanner.nextLine();
            }
            picturebook.setiSBN(bookISBN);

            System.out.println("Please, Enter illustrator Style of book");
            String illustratorStyle= scanner.nextLine();
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
            while (HelperUtils.isNull(wordCountPerPage) || wordCountPerPage>0) {
                System.out.println("Invalied Input, Please write again");
                wordCountPerPage = scanner.nextInt();
            }
            picturebook.setWordCountPerPage(wordCountPerPage);
            scanner.nextLine();

            pictureBookList.add(picturebook);

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
        for (PictureBook book : pictureBookList) {
            if (book.getiSBN().equals(iSBN)) {
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
                        book.setIllustratorStyle(newIllustratorStyle);
                        System.out.println("Illustrator Style updated successfully.");
                    }
                    case 2 -> {
                        System.out.println("Enter new target Age Range");
                        String newTargetAgeRange = scanner.nextLine();
                        book.setTargetAgeRange(newTargetAgeRange);
                        System.out.println("target Age Range updated successfully.");
                    }
                    case 3 -> {
                        System.out.println("Enter new word Count Per Page");
                        Integer newWordCountPerPage = scanner.nextInt();
                        scanner.nextLine();
                        book.setWordCountPerPage(newWordCountPerPage);
                        System.out.println("Word Count Per Page updated successfully.");
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
        Boolean removed = pictureBookList.removeIf(book -> book.getiSBN().equals(iSBNToRemove));
        if (removed) {
            System.out.println("The the book is successfully removed");

        } else {
            System.out.println("There are no Book with this ISBN,Please Enter another ISBN");
            removeISBN = scanner.nextLine();
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
