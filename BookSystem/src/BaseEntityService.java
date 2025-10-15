import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BaseEntityService {

    public static List<BaseEntity> baseEntityList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void addBook() {
        Boolean continueInput = true;
        while (continueInput) {
            BaseEntity bookEntity = new BaseEntity();
            System.out.println("Please, Enter The ID of book");
            Integer bookId = scanner.nextInt();
            while (HelperUtils.isNull(bookId) || bookId < 0 || checkIfBookIdIsExit(bookId)) {
                System.out.println("This Book ID is already exits in out Records," +
                        "Please Enter another ID");
                bookId = scanner.nextInt();
            }
            bookEntity.setId(bookId);
            scanner.nextLine();
            System.out.println("Please, Enter The International Standard Book Number(ISBN) of book");
            String iSBN = scanner.nextLine();
            while (HelperUtils.isNull(iSBN) || HelperUtils.checkIfStrIsBlankOrEmpty(iSBN) || checkIfBookISBNIsExit(iSBN)) {
                System.out.println("This Book ISBN is already exits in out Records," +
                        "Please Enter another ISBN");
                iSBN = scanner.nextLine();
            }
            bookEntity.setiSBN(iSBN);
            bookEntity.setCreatedDate(new Date().toString());
            baseEntityList.add(bookEntity);
            System.out.println("The book data is successfully added " + bookEntity.getCreatedDate());
            System.out.println("**************************************************");
            System.out.println("Press (q)+followed by Enter to quite, otherwise press Enter to continue");
            String exitFlag = scanner.nextLine();
            if (exitFlag.equalsIgnoreCase("q")) {
                continueInput = false;
            }
        }
    }

    public static void editBook() {
        BaseEntity base = null;
        System.out.println("Enter the ISBN of the book to edit");
        String iSBN = scanner.nextLine();
        while (HelperUtils.isNull(iSBN) || HelperUtils.checkIfStrIsBlankOrEmpty(iSBN) || !checkIfBookISBNIsExit(iSBN)) {
            System.out.println("Invalid Input, please write again");
            iSBN = scanner.nextLine();
        }
        String newISBN = scanner.nextLine();
        base.setUpdatedDate(new Date().toString());

    }


    public static void removeBook() {
        System.out.println("Please, Enter The International Standard Book Number(ISBN) of book to remove it");
        String removeISBN = scanner.nextLine();
        while (HelperUtils.isNull(removeISBN) || HelperUtils.checkIfStrIsBlankOrEmpty(removeISBN)) {
            System.out.println("Invalid ISBN ,Please Enter another ISBN");
            removeISBN = scanner.nextLine();
        }
        final String iSBNToRemove = removeISBN;
        Boolean removed = baseEntityList.removeIf(book -> book.getiSBN().equals(iSBNToRemove));
        if (removed) {
            System.out.println("The the book is successfully removed");

        } else {
            System.out.println("There are no Book with this ISBN,Please Enter another ISBN");
            removeISBN = scanner.nextLine();
        }
    }


    public static void displayAllBook() {
        if (baseEntityList.isEmpty()) {
            System.out.println("There are no book Available");
            System.out.println("********************************************");
        }
        System.out.println("The List of The Book");
        System.out.println("********************************************");
        for (BaseEntity book : baseEntityList) {
            System.out.println(book);
        }
    }


    public static Boolean checkIfBookIdIsExit(Integer idToCheck) {
        for (BaseEntity book : baseEntityList) {
            if (book.getId().equals(idToCheck)) {
                return true;
            }
        }
        return false;
    }

    public static Boolean checkIfBookISBNIsExit(String iSBNToCheck) {
        for (BaseEntity book : baseEntityList) {
            if (book.getiSBN().equals(iSBNToCheck)) {
                return true;
            }
        }
        return false;
    }
}
