package com.library.transactions;

import com.library.core.Book;
import com.library.core.User;

import java.util.List;

public interface Invoice {
    double calculateLateFee(User user, Book book);
    void generateInvoice(User user, List<Book> borrowedBooks);
    void printInvoice(User user);
}
