import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDriver {

    public static Scanner scanner = new Scanner(System.in);
    public static Integer mainMenuOption = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to Book System");
        while (mainMenuOption != 6) {
            showBookMune();
            System.out.println("Please enter a number from the menu");
            mainMenuOption = scanner.nextInt();
            scanner.nextLine();
            switch (mainMenuOption) {
                case 1 -> BookService.addBook();
                case 2 -> BookService.editBook();
                case 3 -> BookService.removeBook();
                case 4 -> BookService.displayAllBook();
                case 5 -> {
                    System.out.println("Exiting the Book System");
                    System.exit(0);
                }

                default -> System.out.println("Invalid option, please enter number from Menu");
            }
        }
    }

    public static void showBookMune() {
        System.out.println("""
                1- Add a New book
                2- Edit an Existing book
                3- Remove a book
                4- Display All books
                5- Exit
                """);
    }


}