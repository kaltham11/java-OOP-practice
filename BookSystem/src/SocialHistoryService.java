import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SocialHistoryService {
    public static List<SocialHistory> socialHistoryBookList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void addBook() {
        Boolean continueInput = true;
        while (continueInput) {
            SocialHistory socialHistorybook = new SocialHistory();
            System.out.println("Please, Enter The ISBN of book");
            String bookISBN = scanner.nextLine();
            while (HelperUtils.isNull(bookISBN) || HelperUtils.checkIfStrIsBlankOrEmpty(bookISBN)) {
                System.out.println("Invalid Input,Please try Again");
                bookISBN = scanner.nextLine();
            }
            socialHistorybook.setiSBN(bookISBN);
            scanner.nextLine();
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

            socialHistoryBookList.add(socialHistorybook);

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
        for (SocialHistory book : socialHistoryBookList) {
            if (book.getiSBN().equals(iSBN)) {
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
                        book.setCulturalFocus(newCulturalFocus);
                        System.out.println("cultural Focus updated successfully.");
                    }
                    case 2 -> {
                        System.out.println("Enter new time Period");
                        String newTimePeriod = scanner.nextLine();
                        book.setTimePeriod(newTimePeriod);
                        System.out.println("Time Period updated successfully.");
                    }
                    case 3 -> {
                        System.out.println("Enter new geographical Scope");
                        String newGeographicalScope = scanner.nextLine();
                        book.setCulturalArtifactsDiscussed(newGeographicalScope);
                        System.out.println("Geographical Scope updated successfully.");
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
        Boolean removed = socialHistoryBookList.removeIf(book -> book.getiSBN().equals(iSBNToRemove));
        if (removed) {
            System.out.println("The the book is successfully removed");

        } else {
            System.out.println("There are no Book with this ISBN,Please Enter another ISBN");
            removeISBN = scanner.nextLine();
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
