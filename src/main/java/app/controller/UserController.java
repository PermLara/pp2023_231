package app.controller;

import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String listUser(ModelMap model) {
        List<User> listUser = userService.listUser();
//        User newUser1 = new User("Ivan", "Ivanovich", "ivan@mail.ru");
//        User newUser2 = new User("Peter", "Ivanovich", "peter@mail.ru");
//        List<User> listUser = List.of(newUser1, newUser2);
        model.addAttribute("listUser", listUser);
        return "users";
    }
}
