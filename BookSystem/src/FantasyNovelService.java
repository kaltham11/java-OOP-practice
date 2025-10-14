import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FantasyNovelService {
    public static List<FantasyNovel> fantasyNovelbookList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static FantasyNovel addBookInput() {
            FantasyNovel fantasyNovelBook = new FantasyNovel();
            System.out.println("Please, Enter The International Standard Book Number(ISBN) of book");
            String iSBN = scanner.nextLine();
            while (HelperUtils.isNull(iSBN) || HelperUtils.checkIfStrIsBlankOrEmpty(iSBN) || checkIfBookISBNIsExit(iSBN)) {
                System.out.println("This Book ISBN is already exits in out Records," +
                        "Please Enter another ISBN");
                iSBN = scanner.nextLine();
            }
            fantasyNovelBook.setiSBN(iSBN);

            System.out.println("Please, Enter The magic System Rules of book");
            String magicSystemRules = scanner.nextLine();
            while (HelperUtils.isNull(magicSystemRules) || HelperUtils.checkIfStrIsBlankOrEmpty(magicSystemRules)) {
                System.out.println("Invalid Input, please enter again");
                magicSystemRules = scanner.nextLine();
            }
            fantasyNovelBook.setMagicSystemRules(magicSystemRules);
            System.out.println("Please, Enter The world Building Depth book");
            String worldBuildingDepth = scanner.nextLine();
            while (HelperUtils.isNull(worldBuildingDepth) || HelperUtils.checkIfStrIsBlankOrEmpty(worldBuildingDepth)) {
                System.out.println("Invalid Input, please enter again");
                worldBuildingDepth = scanner.nextLine();
            }
            fantasyNovelBook.setWorldBuildingDepth(worldBuildingDepth);

            System.out.println("Please, Enter (true/false) of the mythical Creature Presence");
            String mythicalCreaturePresence = scanner.nextLine();
            while (!mythicalCreaturePresence.equalsIgnoreCase("true") && !mythicalCreaturePresence.equalsIgnoreCase("false")) {
                System.out.println("Invalid Input, Please write again");
                mythicalCreaturePresence = scanner.nextLine();
            }
            Boolean hasMythicalCreaturePresence = Boolean.parseBoolean(mythicalCreaturePresence);
            fantasyNovelBook.setMythicalCreaturePresence(hasMythicalCreaturePresence);

            return fantasyNovelBook;
    }

    public static void save(FantasyNovel book) {
        fantasyNovelbookList.add(book);
        System.out.println("The book data is successfully added");
    }
    public static FantasyNovel editBookInput() {
        if (fantasyNovelbookList.isEmpty()) {
            System.out.println("No Book available to edit");
            return null;
        }

        System.out.println("Enter the ISBN of the book to edit");
        String iSBN = scanner.nextLine();
        while (HelperUtils.isNull(iSBN) || HelperUtils.checkIfStrIsBlankOrEmpty(iSBN) || !checkIfBookISBNIsExit(iSBN)) {
            System.out.println("Invalid Input, please write again");
            iSBN = scanner.nextLine();
        }
        FantasyNovel selectedBook = null;

        for (FantasyNovel book : fantasyNovelbookList) {
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
                        1 - magic System Rules
                        2 - world Building Depth
                        3 - mythical Creature Presence
                        4- Exit
                        """);
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> {
                        System.out.println("Enter new magic System Rules of the book");
                        String magicSystemRules = scanner.nextLine();
                        selectedBook.setMagicSystemRules(magicSystemRules);
                        System.out.println("magic System Rules updated successfully.");
                    }
                    case 2 -> {
                        System.out.println("Enter new world Building Depth of the book");
                        String worldBuildingDepth = scanner.nextLine();
                        selectedBook.setWorldBuildingDepth(worldBuildingDepth);
                        System.out.println("world Building Depth updated successfully of the book");
                    }
                    case 3 -> {
                        System.out.println("Enter the update for mythical Creature Presence(True/False)");
                        String mythicalCreaturePresence = scanner.nextLine();
                        if (mythicalCreaturePresence.equalsIgnoreCase("true") || mythicalCreaturePresence.equalsIgnoreCase("false")) {
                            Boolean isMythicalCreaturePresence = Boolean.parseBoolean(mythicalCreaturePresence);
                            selectedBook.setMythicalCreaturePresence(isMythicalCreaturePresence);
                            System.out.println("mythical Creature Presence updated successfully");
                        }
                        System.out.println("The input is invalid, please enter (true/false)");
                        mythicalCreaturePresence = scanner.nextLine();

                    }

                    case 4 -> {
                        System.out.println("Exiting edit menu...");
                        return selectedBook;
                    }
                    default -> System.out.println("Invalid option, Please Enter a number from Menu");
                }

                return selectedBook;
    }

    public static void update(FantasyNovel updatedBook) {
        if (updatedBook == null) {
            System.out.println("No updates to save");
            return;
        }

        for (int i = 0; i < fantasyNovelbookList.size(); i++) {
            if (fantasyNovelbookList.get(i).equals(updatedBook)) {
                fantasyNovelbookList.set(i, updatedBook);
                System.out.println("Book updated successfully.");
                return;
            }
        }
        System.out.println("Updated Book not found in list");
    }


    public static String getBookToRemove() {
        if (fantasyNovelbookList.isEmpty()) {
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
            fantasyNovelbookList.removeIf(book -> book.getiSBN().equals(removeBookByISBN));
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found");
        }
    }


    public static void displayAllBook() {
        if (fantasyNovelbookList.isEmpty()) {
            System.out.println("There are no book Available");
            System.out.println("********************************************");
        }
        System.out.println("The List of The Book");
        System.out.println("********************************************");
        for (FantasyNovel book : fantasyNovelbookList) {
            System.out.println(book);
        }
    }

    public static Boolean checkIfBookISBNIsExit(String iSBNToCheck) {
        for (FantasyNovel book : fantasyNovelbookList) {
            if (book.getiSBN().equals(iSBNToCheck)) {
                return true;
            }
        }
        return false;
    }
}
