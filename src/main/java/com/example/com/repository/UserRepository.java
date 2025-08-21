package com.example.com.repository;

import com.example.com.model.Seed;
import com.example.com.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public User login(String username, String password) {
        try {
            User user = (User) entityManager.createQuery("select u from User u where u.userName = :username and u.password = :password")
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
            return user;


        } catch (Exception e) {
            return null;
        }
    }

    public boolean checkExistUsername(String username) {
        Long count = entityManager.createQuery("select count(id) from  User where userName = :username", Long.class)
                .setParameter("username",username).getSingleResult();
        if (count > 0) {
            return true;
        }else {
            return false;
        }
    }
    @Transactional
    public boolean save(User user) {
        try {
            entityManager.persist(user);
            return true;
        }catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }
}
