package com.library.data;

import com.library.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Database {
    private AtomicInteger transactionIdCounter = new AtomicInteger(1);
    public int generateNewTransactionId() {
        return transactionIdCounter.getAndIncrement();
    }

    private Map<Integer, Book> books;
    private Map<Integer, User> users;
    private Map<Integer, Transaction> transactions;
    private Map<String, Author> authors;



    public Database(){
        books = new HashMap<>();
        users = new HashMap<>();
        authors = new HashMap<>();
        transactions = new HashMap<>();

        User user1 = new User(1, "Elif", "Koyun", "elif@gmail.com", "1234",new ArrayList<>());
        User user2 = new User(2, "John", "Doe", "john@example.com", "password", new ArrayList<>());
        User user3 = new User(3, "Jane", "Smith", "jane@example.com", "pass123", new ArrayList<>());

        users.put(user1.getUser_id(), user1);
        users.put(user2.getUser_id(), user2);
        users.put(user3.getUser_id(), user3);

        Author author1 = new Author("J.K.", "Rowling", new ArrayList<>());
        Author author2 = new Author("George", "Orwell", new ArrayList<>());

        authors.put(author1.getName(), author1);
        authors.put(author2.getName(), author1);


    }
    public void addBook(Book book){
        books.put(book.getBook_id(), book);
    }
    public Book getBookById(int id){
        return books.get(id);
    }
    public List<Book> getBooksByTitle(String title) {
        return books.values().stream() // tüm kitap nesnelerinin akışını oluşturur.
                .filter(book -> book.getTitle().equals(title)).collect(Collectors.toList()); // filtrelenen kitap nesnelerini bir liste olarak toplar ve döndürür.
    }
    public List<Book> getBooksByAuthor(String authorName) {
        return books.values().stream().filter(book -> book.getAuthor().equals(authorName)).collect(Collectors.toList());
    }
    public void updateBook(Book book) {
        if(books.containsKey(book)){
            books.put(book.getBook_id(), book);
            System.out.println("Book information updated.");
        }
        else {
            System.out.println("Book not found.");
        }

    }
    public void deleteBook(int id) {
        if (books.containsKey(id)) {
            books.remove(id);
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }
    public List<Book> getBooksByCategory(Category category) {
        return books.values().stream().filter(book -> book.getCategory().equals(category)).collect(Collectors.toList());
    }

    public List<Book> getBooksByAuthor(Author author) {
        return books.values().stream().filter(book -> book.getAuthor().equals(author)).collect(Collectors.toList());
    }

    public void borrowBook(User user, Book book) { // ?? tekrar bak

        int newTransactionId = generateNewTransactionId();
        Transaction transaction = new Transaction(newTransactionId, user, book, false);
        transactions.put(transaction.getId(), transaction);
        user.getBorrowedBooks().add(book);
        books.put(transaction.getId(), book);

    }

    public void returnBook(User user, Book book) { // ?? tekrar bak
        int newTransactionId = generateNewTransactionId();
        Transaction transaction = transactions.get(book.getBook_id());
        transaction.setReturned(true);
        user.getBorrowedBooks().remove(book);
    }


    //USER METHODS

    public void addUser(User user){
        users.put(user.getUser_id(), user);
    }
    public User getUserById(int id) {
        return users.get(id);
    }
    public User getUserByEmail(String email) {
        return users.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }
    public void updateUser(User user) {
        users.put(user.getUser_id(), user);
    }

    public void deleteUser(int id) {
        users.remove(id);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public String toString() {
        return "LibraryDatabase{" + "books=" + books + ", users=" + users + ", transactions=" + transactions + '}';
    }
}
