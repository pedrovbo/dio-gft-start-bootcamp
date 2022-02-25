package com.pedrovbo.emprestimolivros.service;

import com.pedrovbo.emprestimolivros.model.User;

import java.util.List;

public interface UserService {

    User addUser(User user);
    List<User> getAllUsers();

}
