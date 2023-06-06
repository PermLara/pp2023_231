package app.dao;

import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> listUser() {
        return entityManager.createQuery("FROM User u", User.class)
                .getResultList();
    }

    @Override
    public void removeById(Long id) {
        removeUser(findById(id));
    }

    @Override
    public void removeUser(User user) {
        try {
            //entityManager.merge(user);
            entityManager.remove(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void updateUser(User user) {
        try {
            entityManager.merge(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateById(Long id) {
        updateUser(findById(id));
    }

    @Override
    public User findById(Long id) {
        String hql = "from User where id = :id";
        Query query = entityManager.createQuery(hql);
        query.setParameter("id", id);
        return (User) query.getSingleResult();
    }
}
