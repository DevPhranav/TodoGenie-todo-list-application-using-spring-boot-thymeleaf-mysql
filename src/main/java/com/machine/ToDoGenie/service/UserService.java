package com.machine.ToDoGenie.service;


import com.machine.ToDoGenie.entity.Users;

public interface UserService {
    void save(Users theUser);

    Users findByEmail(String email);

}
