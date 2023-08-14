package com.library.transactions;

import com.library.core.Book;
import com.library.core.User;

public interface Return {
    void returnBook(User user, Book book);
    double calculateLateFee(User user, Book book);
}
