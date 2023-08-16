package com.library.users;

import com.library.core.User;

import java.util.List;

public interface UserManager {
    void addUser(User userName);
    void deleteUser(User user);

    List<User> listUsers();

    User getUserByUsername(String username);
}
