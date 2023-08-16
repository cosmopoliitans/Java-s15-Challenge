package com.library.main;

import com.library.data.Database;
import com.library.model.*;
import com.library.transactions.*;
import java.util.*;

public class LibraryApp {

    private static Scanner scanner = new Scanner(System.in);
    private static Database database = new Database();
    private static UserManager userManager = new UserManager(database);
    private static BookManager bookManager = new BookManager(database);
    private static User currentUser = null;

    public static void main(String[] args) {
        loginOrRegister();
    }

    private static void loginOrRegister(){
        while (true) {
            if (currentUser == null) {
                System.out.println("1. Login");
                System.out.println("2. New User");
                System.out.println("3. Exit");
                System.out.print("Select an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        currentUser = login();
                        if (currentUser != null) {
                            mainMenu();
                        }
                        break;
                    case 2:
                        newUser();
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            } else {
                mainMenu();
            }
        }
    }

    private static User login() {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (userManager.authenticateUser(email, password)) {
            System.out.println("Login successful!");
            mainMenu();
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
        return null;
    }

    private static void newUser() {
        System.out.print("Enter a new email: ");
        String email = scanner.nextLine();

        if (userManager.isEmailRegisteredBefore(email)) {
            System.out.println("This email is already registered. Please choose a different email.");
            return;
        }

        System.out.print("Enter a new password: ");
        String password = scanner.nextLine();

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your surname: ");
        String surname = scanner.nextLine();

        User newUser = new User(database.generateNewTransactionId(), name, surname, email, password, new ArrayList<>());
        userManager.addUser(newUser);

        System.out.println("New user registered successfully!");
    }

    private static void mainMenu() {
        while (true) {
            System.out.println("1. Add New Book");
            System.out.println("2. Select Book");
            System.out.println("10. Logout");
            System.out.println("11. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addNewBook();
                    break;
                case 2:
                    selectBook();
                    break;
                case 10:
                    System.out.println("Logging out...");
                    currentUser = null;
                    return;
                case 11:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void addNewBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author name: ");
        String authorName = scanner.nextLine();

        System.out.print("Enter author surname: ");
        String authorSurname = scanner.nextLine();

        System.out.print("Enter book category (HISTORY, SCIENCEFICTION, ...): ");
        Category category = Category.valueOf(scanner.nextLine());

        Author author = new Author(authorName, authorSurname);
        Book newBook = new Book(database.generateNewTransactionId(), title, author, category);
        bookManager.addBook(newBook);
    }
    private static void selectBook() {
        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Boşluğu oku

        Book selectedBook = bookManager.getBookById(bookId);
        if (selectedBook != null) {
            System.out.println("Selected Book: " + selectedBook);
        } else {
            System.out.println("Book not found.");
        }
    }

}
