package com.machine.ToDoGenie.service;


import com.machine.ToDoGenie.dao.UserRepository;
import com.machine.ToDoGenie.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(Users user) {
        userRepository.save(user);
    }

    @Override
    public Users findByEmail(String email)
    {
       return   userRepository.findByEmail(email);
    }



}
