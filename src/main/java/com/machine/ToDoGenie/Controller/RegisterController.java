package com.machine.ToDoGenie.Controller;

import com.machine.ToDoGenie.entity.Users;
import com.machine.ToDoGenie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registerPage")
    public String showRegisterPage(Model theModel) {
        Users user = new Users();
        theModel.addAttribute("user", user);
        return "register-page";
    }

    @PostMapping("/registerSubmit")
    public String registerUser(@ModelAttribute("user") Users user) {
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            return "redirect:/registerPage?error";
        }
        user.setPassword("{noop}"+user.getPassword());
        System.out.println(user.getPassword());
        user.setRole("ROLE_USER");
        user.setEnabled(1);

        Users existUser = userService.findByEmail(user.getEmail());
        if(existUser == null) {
            userService.save(user);
            return "redirect:/rloginPage?registerSuccess=true";
        } else {
            return "redirect:/registerPage?alreadyExist=true";
        }
    }


}
