package com.machine.ToDoGenie.Controller;

import com.machine.ToDoGenie.dao.UserRepository;
import com.machine.ToDoGenie.entity.Todos;
import com.machine.ToDoGenie.entity.Users;
import com.machine.ToDoGenie.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    public TodoController(TodoService todoService, UserRepository userRepository) {
        this.todoService = todoService;
        this.userRepository = userRepository;
    }

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/list")
    public String listTodos(Model theModel)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        Users user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        Long userId = user.getId();
        List<Todos> theTodos = todoService.findByUserId(userId);

        theModel.addAttribute("todos",theTodos);
        return "todos-list";
    }

    @GetMapping("/addTodo")
    public String addTodo(Model theModel) {
        Todos theTodo = new Todos();
        theModel.addAttribute("todo", theTodo);
        return "todo-add-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("todoId") int theId,Model theModel)
    {
        // get the employee from the service
        Todos theTodo = todoService.findById(theId);

        // set todo in the model to prepopulate the form
        theModel.addAttribute("todo",theTodo);

        // send over to our form
        return "todo-add-form";
    }



    @PostMapping("/save")
    public String addTodo(@ModelAttribute("todo") Todos theTodo) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        Users user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        Long userId = user.getId();
        theTodo.setUserId(userId);
        if (theTodo.getUserId() == null) {
            throw new RuntimeException("User ID is missing");
        }
        todoService.save(theTodo);
        return "redirect:/todos/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("todoId") int theId)
    {
        // delete the Employee
        todoService.deleteById(theId);

        // redirect to the /employees/list
        return "redirect:/todos/list";
    }



}
