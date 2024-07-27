package com.machine.ToDoGenie.dao;

import com.machine.ToDoGenie.entity.Todos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todos, Integer> {
    List<Todos> findByUserId(Long userId);
}
