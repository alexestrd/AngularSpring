package com.backend.backend.dao;

import com.backend.backend.models.UserModel;

import java.util.List;

public interface UserDao {

    List<UserModel> getUsers();

    void deleteUser(Long id);

    UserModel getUser(Long id);

    void postUser(UserModel user);

    UserModel obtenerUser(UserModel user);
}
