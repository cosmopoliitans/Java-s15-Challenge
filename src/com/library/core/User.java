package com.library.core;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private static final AtomicInteger idCounter = new AtomicInteger(1);
    private int userId;
    private String userName;
    private String userSurname;
    private String userPassword;
    private String userEmail;
    private int borrowedBooks;

    public User(String userEmail, String userPassword) {
        this.userPassword = userPassword;
        this.userEmail = userEmail;
    }

    public User(int userId, String userName, String userSurname, String userPassword, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
    }

    public User(int userId, String userName, String userSurname, String userPassword, String userEmail, int borrowedBooks) {
        this.userId = userId;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.borrowedBooks = borrowedBooks;
    }
    public static int generateUserId() {
        return idCounter.getAndIncrement();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(int borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}
