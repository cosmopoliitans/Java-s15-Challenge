package com.library.main;
import com.library.books.BookManager;
import com.library.books.Library;
import com.library.core.Author;
import com.library.core.Category;
import com.library.core.User;
import com.library.users.LibraryUserManager;
import com.library.users.UserManager;

import java.util.List;
import java.util.Scanner;

public class LibrarySystem {
    private static Scanner scanner = new Scanner(System.in);
    private static UserManager userManager = new LibraryUserManager(); // Kullanıcı yöneticisi
    public static Category desiredCategory;
    public static Author desiredAuthor;

    public static Library library = new BookManager();
    public static User currentUser;


    public static void main(String[] args) {
        loginOrRegister();
        while (true){
            System.out.println("1. Add New Book");
            System.out.println("2. Select Book by ID, Name, or Author");
            System.out.println("3. Update Book Info");
            System.out.println("4. Delete Book");
            System.out.println("5. List Books in a Category");
            System.out.println("6. List Books by an Author");
            System.out.println("7. Borrow a Book");
            System.out.println("8. Return a Book");
            System.out.println("9. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Boşluğu oku

            switch (choice) {
                case 1:
                    library.addBook();
                    break;
                case 2:
                    library.selectBook();
                    break;
                case 3:
                    library.updateBookInfo();
                    break;
                case 4:
                    library.deleteBook();
                    break;
                case 5:
                    listBooksByCategory();
                    break;
                case 6:
                    listBooksByAuthor();
                    break;
                case 7:
                    borrowBook();
                    break;
                case 8:
                    returnBook();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }



    }
    private static void loginOrRegister(){
        while (true) {
            System.out.println("1. Login");
            System.out.println("2. New User");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Boşluğu oku

            switch (choice) {
                case 1:
                    login();
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
        }
    }

    private static void login() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Burada kullanıcının varlığı ve doğruluğunu kontrol etmek için bir yöntem kullanabilirsiniz.
        // userManager.login(username, password);

        // Örnek bir giriş işlemi
        User user = userManager.getUserByUsername(username);
        if (user != null && user.getUserPassword().equals(password)) {
            System.out.println("Login successful!");
            // Diğer işlemleri burada gerçekleştirebilirsiniz.
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
    }

    private static void newUser() {
        System.out.println("Enter a username: ");
        String username = scanner.nextLine();
        if(userManager.getUserByUsername(username) != null){
            System.out.println("Username already exists. Please choose a different username.");
            return;
        }
        System.out.println("Enter a password: ");
        String password = scanner.nextLine();

        System.out.println("Enter a name: ");
        String name = scanner.nextLine();

        System.out.println("Enter a surname: ");
        String surname = scanner.nextLine();

        System.out.println("Enter a email: ");
        String email = scanner.nextLine();

        User newUser = new User(User.generateUserId(), name, surname, password, email);
        userManager.addUser(newUser);
        System.out.println("New user created successfully!");

    }
}