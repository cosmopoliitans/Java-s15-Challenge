package com.library.model;

import com.library.data.Database;
import com.library.transactions.LibraryBookService;

import java.util.ArrayList;
import java.util.List;

public class BookManager implements LibraryBookService {

    private Database database;
    public BookManager(Database database){
        this.database = database;
    }
    @Override
    public void addBook(Book book){
        database.addBook(book);
        System.out.println("Book added successfully.");
    }
    @Override
    public Book getBookById(int id){
        return database.getBookById(id);
    }
    @Override
    public List<Book> getBooksByTitle(String title){
        return database.getBooksByTitle(title);
    }
    @Override
    public List<Book> getBooksByAuthor(String authorName){
        return database.getBooksByAuthor(authorName);
    }
    @Override
    public void updateBook(Book book){
        if(database.getBooksByTitle(book.getTitle()).equals(book.getTitle())){
            database.updateBook(book);
            System.out.println("Book information updated.");
        }else {
            System.out.println("Book not found.");
        }
    }
    @Override
    public void deleteBook(int id){
        database.deleteBook(id);
    }
    @Override
    public List<Book> getBooksByCategory(Category category) {
        return database.getBooksByCategory(category);
    }
    @Override
    public List<Book> getBooksByAuthor(Author author) {
        return database.getBooksByAuthor(author);
    }
    @Override
    public void borrowBook(User user, Book book) {
        if (user.getBorrowedBooks().size() < 5) {
            if (book.isBorrowed()) {
                database.borrowBook(user, book);
            } else {
                System.out.println("Book is already borrowed by another user.");
            }
        } else {
            System.out.println("User has reached the borrowing limit.");
        }
    }
    @Override
    public void returnBook(User user, Book book) {
        database.returnBook(user, book);
    }
    private double calculateFee(Book book) {
        double baseFee = 5.0; // Temel ücret
        double additionalFee = 2.0; // Ek ücret (örneğin kategorisine göre)

        if (book.getCategory() == Category.HISTORY) {
            additionalFee = 3.0;
        } else if (book.getCategory() == Category.SCIENCEFICTION) {
            additionalFee = 4.0;
        }

        // Toplam ücreti hesapla
        return baseFee + additionalFee;
    }
    private static List<Invoice> invoices = new ArrayList<>();

    public void generateInvoice(User user, Book book) {
        double totalFee = calculateFee(book);
        Invoice invoice = new Invoice(user, book, totalFee);
        System.out.println("Invoice Details:");
        System.out.println("User: " + user.getName());
        System.out.println("Book: " + book.getTitle());
        System.out.println("Total Fee: " + totalFee);
        invoices.add(invoice);
    }

}
