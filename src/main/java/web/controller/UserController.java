package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import web.entity.User;
import web.service.UserService;

@Controller
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/")
    public String allUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping(value =  "/{id}")
    public String User(@PathVariable("id") int id,
                             ModelMap model) {
    return userService.getUserById(id).map(user -> {
                model.addAttribute("user", user);
                return "user";
                })
            .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/create")
    public String create(@ModelAttribute("user") User user) {
        return "add";
    }

    @PostMapping(value = "/create/add")
    public String add(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users" + user.getId();
    }

    @PostMapping(value = "/{id}/update")
    public String update(@PathVariable("id") int id, @ModelAttribute User user) {
        userService.updateUser(id, user);
        return "redirect:/users/{id}";
    }

    @PostMapping(value = "/{id}/delete")
    public String delete(@PathVariable("id") int id ) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

}