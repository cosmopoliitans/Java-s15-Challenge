package com.library.books;

import com.library.core.Author;
import com.library.core.Book;
import com.library.core.Category;

import java.util.List;

public class BookManager {
    private Library library;

    public BookManager(Library library) {
        this.library = library;
    }
    private boolean isBookAlreadyInLibrary(int bookId) {
        for (Book book : library.listBooks()) {
            if (book.getBookId() == bookId) {
                return true;
            }
        }
        return false;
    }

    public void addBook(int bookId, String bookName, Author author, Category category) {
        // Kütüphaneye aynı bookId ile daha önce eklenmiş bir kitap olup olmadığını kontrol et
        if (!isBookAlreadyInLibrary(bookId)) {
            Book book = new Book(bookId, bookName, author, category, false); // isBorrowed varsayılan olarak false
            library.addBook(book);
            System.out.println("Kitap başarıyla eklendi.");
        } else {
            System.out.println("Bu kitap zaten kütüphanede mevcut.");
        }
    }


    public void removeBook(int id) {
        library.removeBook(id);
    }

    public List<Book> listBooks() {
        return library.listBooks();
    }
}
