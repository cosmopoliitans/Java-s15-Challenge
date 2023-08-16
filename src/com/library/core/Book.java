package com.library.core;


import java.util.Objects;

public class Book {
    private int bookId;
    private String bookName;
    Author author;
    Category category;
    private boolean isBorrowed;


    public Book(String bookName, Author author, Category category) {
        this.bookName = bookName;
        this.author = author;
        this.category = category;
    }

    public Book(int bookId, String bookName, Author author, Category category, boolean isBorrowed) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.category = category;
        this.isBorrowed = isBorrowed;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author=" + author +
                ", category=" + category +
                ", isBorrowed=" + isBorrowed +
                '}';
    }

}
