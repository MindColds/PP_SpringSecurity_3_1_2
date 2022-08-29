package com.example.pp_springsecurity_3_1_2.service;

import com.example.pp_springsecurity_3_1_2.model.User;

import java.util.List;

public interface UserService {
    List<User> allUsers ();
    User getUserById (int id);
    void addUser (User user);
    void deleteUserById (int id);
    void updateUser (User user);
    User passwordCoder(User user);
}
