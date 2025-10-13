import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BiographyService {
    public static List<Biography> biographyBookList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void addBook() {
        Boolean continueInput = true;
        while (continueInput) {
            Biography biographyBook = new Biography();
            System.out.println("Please, Enter The ID of book");
            Integer bookId = scanner.nextInt();
            while (HelperUtils.isNull(bookId) || bookId < 0 || checkIfBookIdIsExit(bookId)) {
                System.out.println("This Book ID is already exits in out Records," +
                        "Please Enter another ID");
                bookId = scanner.nextInt();
            }
            biographyBook.setId(bookId);
            scanner.nextLine();
            System.out.println("Please, Enter The subject Person of book");
            String bookSubjectPerson = scanner.nextLine();
            biographyBook.setSubjectPerson(bookSubjectPerson);


            System.out.println("Please, Enter The chronological Scope of the book");
            String chronologicalScope = scanner.nextLine();
            while (HelperUtils.isNull(chronologicalScope) || HelperUtils.checkIfStrIsBlankOrEmpty(chronologicalScope)) {
                System.out.println("Invalid Auother, Please write again");
                chronologicalScope = scanner.nextLine();
            }
            biographyBook.setChronologicalScope(chronologicalScope);

            System.out.println("Please, Enter The primary Source Use of the book");
            String primarySourceUse = scanner.nextLine();
            while (HelperUtils.isNull(primarySourceUse) || HelperUtils.checkIfStrIsBlankOrEmpty(primarySourceUse)) {
                System.out.println("Invalid publication Year, Please write again");
                primarySourceUse = scanner.nextLine();
            }
            biographyBook.setPrimarySourceUse(primarySourceUse);


            biographyBookList.add(biographyBook);
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
        for (Biography book : biographyBookList) {
            if (book.getiSBN().equals(iSBN)) {
                System.out.println("Which attribute would you like to edit?");
                System.out.println("""
                        1 - subject Person
                        2 - chronological Scope
                        3 - primary Source Use
                        4- Exit
                        """);
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> {
                        System.out.println("Enter new subject Person of the book");
                        String subjectPerson = scanner.nextLine();
                        book.setSubjectPerson(subjectPerson);
                        System.out.println("subject Person updated successfully.");
                    }
                    case 2 -> {
                        System.out.println("Enter chronological Scope");
                        String chronologicalScope = scanner.nextLine();
                        book.setChronologicalScope(chronologicalScope);
                        System.out.println("chronological Scope updated successfully.");
                    }
                    case 3 -> {
                        System.out.println("Enter the update primary Source Use");
                        String chronologicalScope = scanner.nextLine();
                        book.setChronologicalScope(chronologicalScope);
                        System.out.println("primary Source Use updated successfully.");
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
        Boolean removed = biographyBookList.removeIf(book -> book.getiSBN().equals(iSBNToRemove));
        if (removed) {
            System.out.println("The the book is successfully removed");

        } else {
            System.out.println("There are no Book with this ISBN,Please Enter another ISBN");
            removeISBN = scanner.nextLine();
        }
    }


    public static void displayAllBook() {
        if (biographyBookList.isEmpty()) {
            System.out.println("There are no book Available");
            System.out.println("********************************************");
        }
        System.out.println("The List of The Book");
        System.out.println("********************************************");
        for (Biography book : biographyBookList) {
            System.out.println(book);
        }
    }


    public static Boolean checkIfBookTitleIsExit(String titleToCheck) {
        for (Biography book : biographyBookList) {
            if (book.getTitle().equals(titleToCheck)) {
                return true;
            }
        }
        return false;
    }

    public static Boolean checkIfBookIdIsExit(Integer idToCheck) {
        for (Biography book : biographyBookList) {
            if (book.getId().equals(idToCheck)) {
                return true;
            }
        }
        return false;
    }

    public static Boolean checkIfBookISBNIsExit(String iSBNToCheck) {
        for (Biography book : biographyBookList) {
            if (book.getiSBN().equals(iSBNToCheck)) {
                return true;
            }
        }
        return false;
    }
}
