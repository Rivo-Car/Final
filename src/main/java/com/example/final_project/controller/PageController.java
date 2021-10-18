package com.example.final_project.controller;

import com.example.final_project.entity.RoleType;
import java.util.List;
import com.example.final_project.exception.UserException;
import com.example.final_project.service.UserService;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.final_project.entity.User;
import com.example.final_project.repository.UserRepository;

@Controller
@RequestMapping("/")
public class PageController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/")
    String index() {
        return "index";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setRole(RoleType.ROLE_USER);

        if(userService.saveNewUser(user)){
            return "util/register_success";
        }else{
            return "util/register_fail";
        }
    }
    @GetMapping("/page1")
    String page1() {
        return "page1";
    }



    @GetMapping("/signup")
    String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration/register";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
       // List<User> listUsers = userRepo.findAll();
        //model.addAttribute("listUsers", listUsers);

        return "user/userpage";
    }

}