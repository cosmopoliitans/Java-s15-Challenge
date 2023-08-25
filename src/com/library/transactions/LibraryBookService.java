package com.library.transactions;

import com.library.model.Author;
import com.library.model.Book;
import com.library.model.Category;
import com.library.model.User;

import java.util.List;

public interface LibraryBookService {

    void addBook(Book book); //yeni kitap ekleme

    Book getBookById(int id);

    List<Book> getBooksByTitle(String title); //kitap adına göre listeleme

    List<Book> getBooksByAuthor(String authorName); //kitap yazarına göre listeleme

    void updateBook(Book book); //kitap bilgilerini güncelleme

    void deleteBook(int id); //kitap silme
    List<Book> getAllBooks();

    List<Book> getBooksByCategory(Category category); //kategoriye göre listeleme

    List<Book> getBooksByAuthor(Author author);

    void borrowBook(User user, Book book);

    void returnBook(User user, Book book);

   /* void generateInvoice(User user, Book book);*/
}
