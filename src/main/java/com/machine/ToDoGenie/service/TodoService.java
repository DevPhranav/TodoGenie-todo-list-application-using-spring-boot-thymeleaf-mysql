package com.machine.ToDoGenie.service;

import com.machine.ToDoGenie.entity.Todos;

import java.util.List;

public interface TodoService {

    List<Todos> findAll();

    Todos findById(int theId);

    Todos save(Todos theTodo);

    void deleteById(int theId);
    public List<Todos> findByUserId(Long userId);
}
