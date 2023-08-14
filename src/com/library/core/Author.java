package com.library.core;

import java.awt.print.Book;
import java.util.List;

public class Author {
    private String authorName;
    private String authorSurname;
    List<Book> books;

    public Author(String authorName, String authorSurname, List<Book> books) {
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.books = books;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorName='" + authorName + '\'' +
                ", authorSurname='" + authorSurname + '\'' +
                ", books=" + books +
                '}';
    }
}
