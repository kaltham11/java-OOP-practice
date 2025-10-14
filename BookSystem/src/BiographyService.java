import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BiographyService {
    public static List<Biography> biographyBookList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static Biography addBookInput() {
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

            return biographyBook;
    }

    public static void save(Biography book){
        biographyBookList.add(book);
        System.out.println("The book data is successfully added");
    }


    public static Biography editBookInput() {
        if(biographyBookList.isEmpty()){
            System.out.println("No Book available to edit");
            return null;
        }

        System.out.println("Enter the ISBN of the book to edit");
        String iSBN = scanner.nextLine();
        while (HelperUtils.isNull(iSBN) || HelperUtils.checkIfStrIsBlankOrEmpty(iSBN) || !checkIfBookISBNIsExit(iSBN)) {
            System.out.println("Invalid Input, please write again");
            iSBN = scanner.nextLine();
        }
        Biography selectedBook=null;

        for (Biography book : biographyBookList) {
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
                        selectedBook.setSubjectPerson(subjectPerson);
                        System.out.println("subject Person updated successfully.");
                    }
                    case 2 -> {
                        System.out.println("Enter chronological Scope");
                        String chronologicalScope = scanner.nextLine();
                        selectedBook.setChronologicalScope(chronologicalScope);
                        System.out.println("chronological Scope updated successfully.");
                    }
                    case 3 -> {
                        System.out.println("Enter the update primary Source Use");
                        String chronologicalScope = scanner.nextLine();
                        selectedBook.setChronologicalScope(chronologicalScope);
                        System.out.println("primary Source Use updated successfully.");
                    }
                    case 4 -> {
                        System.out.println("Exiting edit menu...");
                        return selectedBook;
                    }
                    default -> System.out.println("Invalid option, Please Enter a number from Menu");
                }

        return selectedBook;
    }



    public static void update(Biography updatedBook) {
        if (updatedBook == null) {
            System.out.println("No updates to save");
            return;
        }

        for (int i = 0; i < biographyBookList.size(); i++) {
            if (biographyBookList.get(i).equals(updatedBook)) {
                biographyBookList.set(i, updatedBook);
                System.out.println("Book updated successfully.");
                return;
            }
        }
        System.out.println("Updated Book not found in list");
    }


    public static String getBookToRemove() {
        if (biographyBookList.isEmpty()) {
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
            biographyBookList.removeIf(book -> book.getiSBN().equals(removeBookByISBN));
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found");
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
