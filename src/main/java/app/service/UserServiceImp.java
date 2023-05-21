package app.service;

import app.dao.UserDao;
import app.dao.UserDaoImp;
import app.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    public final UserDao dao = new UserDaoImp();

    @Transactional
    @Override
    public List<User> listUser() {

        //todo удалить
        User newUser1 = new User("Ivan", "Ivanovich", "ivan@mail.ru");
        User newUser2 = new User("Peter", "Ivanovich", "peter@mail.ru");
        updateUser(newUser1);
        updateUser(newUser2);

        return dao.listUser();
    }

    @Transactional
    @Override
    public void removeUser(User user) {
        dao.removeUser(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }
}
