package com.library.model;

import com.library.data.Database;
import com.library.transactions.LibraryUserService;

public class UserManager implements LibraryUserService {
private Database database;
public UserManager(Database database){
    this.database = database;
}

    @Override
    public void addUser(User user){
    database.addUser(user);
    }
    @Override
    public boolean authenticateUser(String email, String password) {
        User user = database.getUserByEmail(email);
        return user != null && user.getPassword().equals(password);
    }

    @Override
    public void deleteUser(int userId) {
        database.deleteUser(userId);
    }
    public boolean isEmailRegisteredBefore(String email){
        User user= database.getUserByEmail(email);
        return user != null;
    }

}
