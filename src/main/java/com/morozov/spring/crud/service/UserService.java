package com.morozov.spring.crud.service;

import com.morozov.spring.crud.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(int id);

    void deleteUser(int id);
}
