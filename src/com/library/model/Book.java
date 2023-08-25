package com.library.model;

import java.util.Objects;

public class Book {
    private int book_id;
    private String title;
    Author author;
    Category category;
    boolean isBorrowed;
    private User borrower;

    public Book(int book_id, String title, Author author, Category category, boolean isBorrowed, User borrower) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isBorrowed = isBorrowed;
        this.borrower = borrower;
    }

    public Book(int book_id, String title, Author author, Category category) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.category = category;
    }
    public Book(int book_id, String title, Author author, Category category, boolean isBorrowed) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isBorrowed = isBorrowed;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }
    public User getBorrower() {
        return borrower;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return book_id == book.book_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(book_id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", category=" + category +
                ", isBorrowed=" + isBorrowed +
                '}';
    }
}
