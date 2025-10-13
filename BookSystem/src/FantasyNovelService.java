import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FantasyNovelService {
    public static List<FantasyNovel> fantasyNovelbookList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void addBook() {
        Boolean continueInput = true;
        while (continueInput) {
            FantasyNovel book = new FantasyNovel();
            System.out.println("Please, Enter The International Standard Book Number(ISBN) of book");
            String iSBN = scanner.nextLine();
            while (HelperUtils.isNull(iSBN) || HelperUtils.checkIfStrIsBlankOrEmpty(iSBN) || checkIfBookISBNIsExit(iSBN)) {
                System.out.println("This Book ISBN is already exits in out Records," +
                        "Please Enter another ISBN");
                iSBN = scanner.nextLine();
            }
            book.setiSBN(iSBN);

            System.out.println("Please, Enter The magic System Rules of book");
            String magicSystemRules = scanner.nextLine();
            while (HelperUtils.isNull(magicSystemRules) || HelperUtils.checkIfStrIsBlankOrEmpty(magicSystemRules)) {
                System.out.println("Invalid Input, please enter again");
                magicSystemRules = scanner.nextLine();
            }
            book.setMagicSystemRules(magicSystemRules);
            System.out.println("Please, Enter The world Building Depth book");
            String worldBuildingDepth = scanner.nextLine();
            while (HelperUtils.isNull(worldBuildingDepth) || HelperUtils.checkIfStrIsBlankOrEmpty(worldBuildingDepth)) {
                System.out.println("Invalid Input, please enter again");
                worldBuildingDepth = scanner.nextLine();
            }
            book.setWorldBuildingDepth(worldBuildingDepth);

            System.out.println("Please, Enter (true/false) of the mythical Creature Presence");
            String mythicalCreaturePresence = scanner.nextLine();
            while (!mythicalCreaturePresence.equalsIgnoreCase("true") && !mythicalCreaturePresence.equalsIgnoreCase("false")) {
                System.out.println("Invalid Input, Please write again");
                mythicalCreaturePresence = scanner.nextLine();
            }
            Boolean hasMythicalCreaturePresence = Boolean.parseBoolean(mythicalCreaturePresence);
            book.setMythicalCreaturePresence(hasMythicalCreaturePresence);
            fantasyNovelbookList.add(book);
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
        for (FantasyNovel book : fantasyNovelbookList) {
            if (book.getiSBN().equals(iSBN)) {
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
                        book.setMagicSystemRules(magicSystemRules);
                        System.out.println("magic System Rules updated successfully.");
                    }
                    case 2 -> {
                        System.out.println("Enter new world Building Depth of the book");
                        String worldBuildingDepth = scanner.nextLine();
                        book.setWorldBuildingDepth(worldBuildingDepth);
                        System.out.println("world Building Depth updated successfully of the book");
                    }
                    case 3 -> {
                        System.out.println("Enter the update for mythical Creature Presence(True/False)");
                        String mythicalCreaturePresence = scanner.nextLine();
                        if (mythicalCreaturePresence.equalsIgnoreCase("true") && mythicalCreaturePresence.equalsIgnoreCase("false")) {
                            Boolean isMythicalCreaturePresence = Boolean.parseBoolean(mythicalCreaturePresence);
                            book.setMythicalCreaturePresence(isMythicalCreaturePresence);
                            System.out.println("mythical Creature Presence updated successfully");
                        }
                        System.out.println("The input is invalid, please enter (true/false)");
                        mythicalCreaturePresence = scanner.nextLine();

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
        Boolean removed = fantasyNovelbookList.removeIf(book -> book.getiSBN().equals(iSBNToRemove));
        if (removed) {
            System.out.println("The the book is successfully removed");

        } else {
            System.out.println("There are no Book with this ISBN,Please Enter another ISBN");
            removeISBN = scanner.nextLine();
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
