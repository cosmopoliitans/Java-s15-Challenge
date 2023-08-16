package com.library.books;

import com.library.core.Author;
import com.library.core.Book;
import com.library.core.Category;

import java.util.ArrayList;
import java.util.List;

import static com.library.main.LibrarySystem.desiredAuthor;
import static com.library.main.LibrarySystem.desiredCategory;

public class BookManager implements Library {
    private boolean isBookAlreadyInLibrary(int bookId) {
        for (Book book : library.listBooks()) {
            if (book.getBookId() == bookId) {
                return true;
            }
        }
        return false;
    }


    private List<Book> books;
    public BookManager(List<Book> books){
        this.books = books;
    }
    @Override
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    @Override
    public void selectBook(Book book) {
        if (books.contains(book)) {
            System.out.println("Selected book: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }

    @Override
    public void updateBookInfo(Book book) {
        if (books.contains(book)) {
            // Kitap bilgilerini güncelleme işlemi, kullanıcıdan gerekli bilgileri alabilirsiniz
            System.out.println("Book information updated.");
        } else {
            System.out.println("Book not found.");
        }
    }

    @Override
    public void deleteBook(Book book) {
        if (books.remove(book)) {
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    @Override
    public List<Book> listBooksByCategory() {
        List<Book> booksInCategory = new ArrayList<>();
        // Kategoriye göre kitapları listeleme işlemi, filtrelemek gerekebilir
        for (Book book : books) {
            if (book.getCategory() == desiredCategory) {
                booksInCategory.add(book);
            }
        }
        return booksInCategory;
    }

    @Override
    public List<Book> listBooksByAuthor() {
        List<Book> booksByAuthor = new ArrayList<>();
        // Yazarına göre kitapları listeleme işlemi, filtrelemek gerekebilir
        for (Book book : books) {
            if (book.getAuthor().equals(desiredAuthor)) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }


    /*public void addBook(int bookId, String bookName, Author author, Category category) {
        // Kütüphaneye aynı bookId ile daha önce eklenmiş bir kitap olup olmadığını kontrol et
        if (!isBookAlreadyInLibrary(bookId)) {
            Book book = new Book(bookId, bookName, author, category, false); // isBorrowed varsayılan olarak false
            BookManager library;
            library.addBook(book);
            System.out.println("Kitap başarıyla eklendi.");
        } else {
            System.out.println("Bu kitap zaten kütüphanede mevcut.");
        }
    }*/


}
