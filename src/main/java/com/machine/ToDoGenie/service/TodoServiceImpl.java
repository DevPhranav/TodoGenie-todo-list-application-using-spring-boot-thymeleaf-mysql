package com.machine.ToDoGenie.service;

import com.machine.ToDoGenie.dao.TodoRepository;
import com.machine.ToDoGenie.entity.Todos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{


    private TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository theTodoRepository){
        todoRepository=theTodoRepository;
    }
    @Override
    public List<Todos> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todos findById(int theId) {
        Optional<Todos> result= todoRepository.findById(theId);

        Todos theTodo = null;
        if(result.isPresent())
        {
            theTodo=result.get();
        }
        else{
            throw new RuntimeException("Did not find Todo id- "+theId);
        }

        return theTodo;
    }

    @Override
    public List<Todos> findByUserId(Long userId) {
        return todoRepository.findByUserId(userId);
    }

    @Override
    public Todos save(Todos theTodo) {
       return todoRepository.save(theTodo);
    }

    @Override
    public void deleteById(int theId) {
            todoRepository.deleteById(theId);
    }
}
