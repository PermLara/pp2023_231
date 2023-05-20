package app.dao;

import app.model.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> listUser() {
        User newUser = new User("Ivan", "Ivanov", "ivan@mail.ru");
        updateUser(newUser);
        return entityManager.createQuery("FROM User u", User.class)
                .getResultList();

    }

    @Override
    public void removeUser(User user) {
        entityManager.remove(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
}
