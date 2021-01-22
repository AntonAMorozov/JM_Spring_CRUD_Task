package com.morozov.spring.crud.controllers;

import com.morozov.spring.crud.entity.User;
import com.morozov.spring.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showAllUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        return "all-users";
    }

    @GetMapping("addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("newUser", user);
        return "user-info";
    }

    @PostMapping("saveUser")
    public String saveUser(@Valid @ModelAttribute("newUser") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user-info";
        } else {
            String pN = user.getPhoneNumber();
            if (!pN.startsWith("+7")) {
                user.setPhoneNumber("+7 " + pN);
            }
            userService.saveUser(user);
        }
        return "redirect:/";
    }

    @GetMapping("updateUser/{id}")
    public String updateUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("newUser", userService.getUser(id));
        return "user-info";
    }

    @GetMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }


}
