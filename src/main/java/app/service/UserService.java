package app.service;

import app.model.User;

import java.util.List;

public interface UserService {
    List<User> listUser();
    void removeUser(User user);
    void updateUser(User user);
}
