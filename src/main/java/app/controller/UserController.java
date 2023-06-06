package app.controller;

import app.model.User;
import app.service.UserService;
import app.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//должна быть страница, на которую выводятся все юзеры с возможностью
//добавлять, удалять и изменять юзера

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String listUser(Model model) {
        List<User> listUser = userService.listUser();
        model.addAttribute("listUser", listUser);
        return "users";
    }

    @PostMapping("/users")
    public String saveUser(Model model, @ModelAttribute("user") User user) {
        try {
            userService.updateUser(user);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        return "redirect:/users";
    }


    //не работает, HTTP Status 405 – Method Not Allowed - Request method 'POST' not supported
    @PatchMapping("/users/{id}")
    public String editById(Model model, @PathVariable("id") Long id) {
        try {
            userService.updateById(id);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        return "redirect:/users";
    }

    //не работает, HTTP Status 405 – Method Not Allowed - Request method 'POST' not supported
    @DeleteMapping("/users/{id}")
    public String deleteById(Model model, @PathVariable("id") Long id) {
        try {
            userService.removeById(id);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        return "redirect:/users";
    }

    @GetMapping("/users/create")
    public String createUser(@ModelAttribute("user") User user) {
        return "create";
    }

    @GetMapping("/users/{id}")
    public String getById(Model model, @PathVariable("id") Long id) {
        try {
            User user = userService.findById(id);
            model.addAttribute("user", user);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        return "user";
    }

    @GetMapping("/users/{id}/delete")
    public String showDeleteById(Model model, @PathVariable("id") Long id) {
        try {
            User user = userService.findById(id);
            model.addAttribute("allowDelete", true);
            model.addAttribute("user", user);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        return "user";
    }

    @GetMapping("/users/{id}/edit")
    public String showEditById(Model model, @PathVariable("id") Long id) {
        try {
            User user = userService.findById(id);
            model.addAttribute("user", user);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        return "edit";
    }
}
