package com.library.transactions;

import com.library.model.User;

public interface LibraryUserService {
    //Yeni kullanıcı ekleme

    void addUser(User user);

    //Kullanıcı girişi
    boolean authenticateUser(String email, String password);

    //Kullanıcı silme
    void deleteUser(int userId);
}
