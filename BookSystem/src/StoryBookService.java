import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StoryBookService {

    public static List<StoryBook> storyBookList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static StoryBook addBookInput() {
        StoryBook storyBook = new StoryBook();
        System.out.println("Please, Enter The main Character of book");
        String mainChar = scanner.nextLine();
        while (HelperUtils.isNull(mainChar) || HelperUtils.checkIfStrIsBlankOrEmpty(mainChar)) {
            System.out.println("Invalid Input Please Enter Again");
            mainChar = scanner.nextLine();
        }
        storyBook.setMainCharacter(mainChar);
        System.out.println("Please, Enter How many chapters in the book");
        Integer chaptersNum = scanner.nextInt();
        while (HelperUtils.isNull(chaptersNum) || chaptersNum > 0) {
            System.out.println("Invalid Input Please Enter Again");
            chaptersNum = scanner.nextInt();
        }
        storyBook.setChapters(chaptersNum);
        scanner.nextLine();
        System.out.println("Please, Enter The moral Lesson of the Story");
        String moralLesson = scanner.nextLine();
        while (HelperUtils.isNull(moralLesson) || checkIfBookISBNIsExit(moralLesson)) {
            System.out.println("Invalid Input Please Enter Again");
            moralLesson = scanner.nextLine();
        }
        storyBook.setMoralLesson(moralLesson);
        System.out.println("Please, Enter The True if the book has Illustrations or false if hasn't");
        String hasIllustrations = scanner.nextLine();
        while (!hasIllustrations.equalsIgnoreCase("true") && !hasIllustrations.equalsIgnoreCase("false")) {
            System.out.println("Invalid Input, Please write again");
            hasIllustrations = scanner.nextLine();
        }
        Boolean isContainIllustrations = Boolean.parseBoolean(hasIllustrations);
        storyBook.setHasIllustrations(isContainIllustrations);

        return storyBook;
    }

    public static void save(StoryBook storyBook) {
        storyBookList.add(storyBook);
        System.out.println("The book data is successfully added");
    }

    public static StoryBook editBookInput() {
        if (storyBookList.isEmpty()) {
            System.out.println("No Book available to edit");
            return null;
        }

        System.out.println("Enter the ISBN of the book to edit");
        String iSBN = scanner.nextLine();
        while (HelperUtils.isNull(iSBN) || HelperUtils.checkIfStrIsBlankOrEmpty(iSBN) || !checkIfBookISBNIsExit(iSBN)) {
            System.out.println("Invalid Input, please write again");
            iSBN = scanner.nextLine();
        }
        StoryBook selectedBook = null;

        for (StoryBook book : storyBookList) {
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
                1 - mainCharacter
                2 - chapters
                3 - hasIllustrations
                4- moralLesson
                5- Exit
                """);
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1 -> {
                System.out.println("Enter new main Character of the  story book");
                String newMainCharacter = scanner.nextLine();
                selectedBook.setMainCharacter(newMainCharacter);
                System.out.println("new Main Character updated successfully.");
            }
            case 2 -> {
                System.out.println("Enter new chapters");
                Integer chapters = scanner.nextInt();
                selectedBook.setChapters(chapters);
                scanner.nextLine();
                System.out.println("chapters updated successfully");
            }
            case 3 -> {
                System.out.println("Enter the update for has Illustrations(True/False)");
                String hasIllustrations = scanner.nextLine();
                if (!hasIllustrations.equalsIgnoreCase("true") && !hasIllustrations.equalsIgnoreCase("false")) {
                    System.out.println("The input is invalid, please enter (true/false)");
                    hasIllustrations = scanner.nextLine();
                }
                Boolean hasBookIllustrations = Boolean.parseBoolean(hasIllustrations);
                selectedBook.setHasIllustrations(hasBookIllustrations);
                System.out.println("Has Illustrations updated successfully");


            }
            case 4 -> {
                System.out.println("Enter new moral Lesson of the  story book");
                String newMoralLesson = scanner.nextLine();
                selectedBook.setMoralLesson(newMoralLesson);
                System.out.println("New Moral Lesson updated successfully.");
            }

            case 5 -> {
                System.out.println("Exiting edit menu...");
                return selectedBook;
            }
            default -> System.out.println("Invalid option, Please Enter a number from Menu");
        }
        return selectedBook;
    }

    public static void update(StoryBook updatedBook) {
        if (updatedBook == null) {
            System.out.println("No updates to save");
            return;
        }

        for (int i = 0; i < storyBookList.size(); i++) {
            if (storyBookList.get(i).equals(updatedBook)) {
                storyBookList.set(i, updatedBook);
                System.out.println("Book updated successfully.");
                return;
            }
        }
        System.out.println("Updated Book not found in list");
    }

    public static void removeBook() {
        System.out.println("Please, Enter The International Standard Book Number(ISBN) of book to remove it");
        String removeISBN = scanner.nextLine();
        while (HelperUtils.isNull(removeISBN) || HelperUtils.checkIfStrIsBlankOrEmpty(removeISBN)) {
            System.out.println("Invalid ISBN ,Please Enter another ISBN");
            removeISBN = scanner.nextLine();
        }
        final String iSBNToRemove = removeISBN;
        Boolean removed = storyBookList.removeIf(book -> book.getiSBN().equals(iSBNToRemove));
        if (removed) {
            System.out.println("The the book is successfully removed");

        } else {
            System.out.println("There are no Book with this ISBN,Please Enter another ISBN");
            removeISBN = scanner.nextLine();
        }
    }

    public static String getBookToRemove() {
        if (storyBookList.isEmpty()) {
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
            storyBookList.removeIf(book -> book.getiSBN().equals(removeBookByISBN));
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found");
        }
    }

    public static void displayAllBook() {
        if (storyBookList.isEmpty()) {
            System.out.println("There are no book Available");
            System.out.println("********************************************");
        }
        System.out.println("The List of The Book");
        System.out.println("********************************************");
        for (StoryBook storyBook : storyBookList) {
            System.out.println(storyBook);
        }
    }


    public static Boolean checkIfBookISBNIsExit(String iSBNToCheck) {
        for (StoryBook storyBook : storyBookList) {
            if (storyBook.getiSBN().equals(iSBNToCheck)) {
                return true;
            }
        }
        return false;
    }
}


