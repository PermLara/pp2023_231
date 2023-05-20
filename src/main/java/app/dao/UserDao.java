package app.dao;

import app.model.User;

import java.util.List;

public interface UserDao {
    List<User> listUser();
    void removeUser(User user);
    void updateUser(User user);
}
