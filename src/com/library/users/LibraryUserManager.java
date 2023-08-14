package com.library.users;
import com.library.core.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LibraryUserManager implements UserManager{
    private List<User> users;

    public LibraryUserManager() {
        users = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void deleteUser(User userToDelete) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getUserId() == userToDelete.getUserId()) {
                iterator.remove();
                break;
            }
        }
    }


    @Override
    public List<User> listUsers() {
        return new ArrayList<>(users);
    }
}
