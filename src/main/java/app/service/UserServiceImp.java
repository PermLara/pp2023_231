package app.service;

import app.dao.UserDao;
import app.dao.UserDaoImp;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceImp implements UserService {

    private UserDao dao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.dao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUser() {
        return dao.listUser();
    }

    @Transactional
    @Override
    public void removeUser(User user) {
        dao.removeUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(Long id) {
        return dao.findById(id);
    }

    @Transactional
    @Override
    public void updateById(Long id) {
        dao.updateById(id);
    }

    @Transactional
    @Override
    public void removeById(Long id) {
        dao.removeById(id);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }
}
