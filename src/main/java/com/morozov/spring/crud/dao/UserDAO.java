package com.morozov.spring.crud.dao;

import com.morozov.spring.crud.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(int id);

    void deleteUser(int id);


}
