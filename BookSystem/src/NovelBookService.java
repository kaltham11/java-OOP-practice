import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NovelBookService {

    public static List<NovelBook> novelBookList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void addBook() {
        Boolean continueInput = true;
        while (continueInput) {
            NovelBook novelBook = new NovelBook();
            System.out.println("Please, Enter The genre of book");
            String bookGenre = scanner.nextLine();
            while (HelperUtils.isNull(bookGenre) || HelperUtils.checkIfStrIsBlankOrEmpty(bookGenre)) {
                System.out.println("Invalid Input, Please write again");
                bookGenre = scanner.nextLine();
            }
            novelBook.setGenre(bookGenre);
            System.out.println("Please, Enter The International Standard Book Number(ISBN) of book");
            String iSBN = scanner.nextLine();
            while (HelperUtils.isNull(iSBN) || checkIfBookISBNIsExit(iSBN)|| checkIfBookISBNIsExit(iSBN)) {
                System.out.println("Invalid Input, Please write again");
                iSBN = scanner.nextLine();
            }
            novelBook.setiSBN(iSBN);

            System.out.println("Please, Enter The setting of the story book");
            String bookSetting = scanner.nextLine();
            while (HelperUtils.isNull(bookSetting) || HelperUtils.checkIfStrIsBlankOrEmpty(bookSetting)) {
                System.out.println("Invalid Input, Please write again");
                bookSetting = scanner.nextLine();
            }
            novelBook.setSetting(bookSetting);

            System.out.println("Please, Enter The True if book has Series OR False if hasn't");
            String isSeries = scanner.nextLine();
            while (!isSeries.equalsIgnoreCase("true") && !isSeries.equalsIgnoreCase("false")) {
                System.out.println("Invalid Input, Please write again");
                isSeries = scanner.nextLine();
            }
            Boolean isBookSeries = Boolean.parseBoolean(isSeries);
            novelBook.setSeries(isBookSeries);

            System.out.println("Please, Enter The True if book is Real OR False if isn't");
            String isReal = scanner.nextLine();
            while (!isReal.equalsIgnoreCase("true") && !isReal.equalsIgnoreCase("false")) {
                System.out.println("Invalid Input, Please write again");
                isReal = scanner.nextLine();
            }
            Boolean isBookReal = Boolean.parseBoolean(isReal);
            novelBook.setSeries(isBookReal);

            novelBookList.add(novelBook);
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
        for (NovelBook novelBook : novelBookList) {
            if (novelBook.getiSBN().equals(iSBN)) {
                System.out.println("Which attribute would you like to edit?");
                System.out.println("""
                        1 - genre
                        2 - setting
                        3 - is Series
                        4-  isReal
                        5- Exit
                        """);
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> {
                        System.out.println("Enter new genre of the book");
                        String newGenre = scanner.nextLine();
                        novelBook.setGenre(newGenre);
                        System.out.println("Genre for the story is updated successfully.");
                    }
                    case 2 -> {
                        System.out.println("Enter new Setting of the story");
                        String setting = scanner.nextLine();
                        novelBook.setSetting(setting);
                        System.out.println("Setting of the story is updated successfully.");
                    }
                    case 3 -> {
                        System.out.println("Enter the update for is Series(True/False)");
                        String isSeries = scanner.nextLine();
                        if (!isSeries.equalsIgnoreCase("true") && !isSeries.equalsIgnoreCase("false")) {
                            System.out.println("The input is invalid, please enter (true/false)");
                            isSeries = scanner.nextLine();
                        }

                        Boolean isBookSeries = Boolean.parseBoolean(isSeries);
                        novelBook.setSeries(isBookSeries);
                        System.out.println("is Book Series updated successfully");

                    }

                    case 4 -> {
                        System.out.println("Enter the update for is Real(True/False)");
                        String isReal = scanner.nextLine();
                        if (!isReal.equalsIgnoreCase("true") && !isReal.equalsIgnoreCase("false")) {
                            System.out.println("The input is invalid, please enter (true/false)");
                            isReal = scanner.nextLine();
                        }

                        Boolean isBookReal = Boolean.parseBoolean(isReal);
                        novelBook.setReal(isBookReal);
                        System.out.println("is Book Real updated successfully");

                    }

                    case 5 -> {
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
        Boolean removed = novelBookList.removeIf(book -> book.getiSBN().equals(iSBNToRemove));
        if (removed) {
            System.out.println("The the book is successfully removed");

        } else {
            System.out.println("There are no Book with this ISBN,Please Enter another ISBN");
            removeISBN = scanner.nextLine();
        }
    }

    public static void displayAllBook() {
        if (novelBookList.isEmpty()) {
            System.out.println("There are no book Available");
            System.out.println("********************************************");
        }
        System.out.println("The List of The Book");
        System.out.println("********************************************");
        for (NovelBook novelBook : novelBookList) {
            System.out.println(novelBook);
        }
    }


    public static Boolean checkIfBookISBNIsExit(String iSBNToCheck) {
        for (NovelBook novelBook : novelBookList) {
            if (novelBook.getiSBN().equals(iSBNToCheck)) {
                return true;
            }
        }
        return false;
    }
}

