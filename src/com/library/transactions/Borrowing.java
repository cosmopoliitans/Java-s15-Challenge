package com.library.transactions;

import com.library.core.Book;
import com.library.core.User;

import java.util.List;

public interface Borrowing {
    void borrowBook(User user, Book book);
    boolean isBookBorrowed(Book book);
    void returnBook(User user, Book book);
    List<Book> getBorrowedBooks(User user);
}
