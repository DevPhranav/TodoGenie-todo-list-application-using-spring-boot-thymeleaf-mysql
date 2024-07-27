package com.machine.ToDoGenie.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/loginPage")
    public String showLoginPage()
    {
        return "login-page";
    }

    @GetMapping("/rloginPage")
    public String showrLoginPage(){
        return "rlogin-page";
    }

    @GetMapping("/")
    public String showRoot()
    {
        return "redirect:/todos/list";
    }


}
