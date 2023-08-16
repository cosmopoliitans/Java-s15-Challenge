package com.library.model;

public class Invoice {
    private User user;
    private Book book;
    private double totalFee;

    public Invoice(User user, Book book, double totalFee) {
        this.user = user;
        this.book = book;
        this.totalFee = totalFee;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public double getTotalFee() {
        return totalFee;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "user=" + user +
                ", book=" + book +
                ", totalFee=" + totalFee +
                '}';
    }
}
