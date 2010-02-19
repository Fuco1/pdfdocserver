/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.docserver.service.impl;

import cz.muni.fi.pa165.docserver.dao.UserDao;
import cz.muni.fi.pa165.docserver.entities.User;
import cz.muni.fi.pa165.docserver.service.UserService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Matus
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void persist(User entity) {
        userDao.persist(entity);
    }

    public User merge(User entity) {
        return userDao.merge(entity);
    }

    public void remove(User entity) {
        userDao.remove(entity);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUserById(long id) {
        return userDao.find(id);
    }

    public User getUserByName(String name) {
        return userDao.findByNamedQuery(User.class, "getUserByName", name);
    }

    public User addUser(String name, String password) {
        if (getUserByName(name) != null) {
            return null;
        }
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setRegDate(new Date());
        userDao.persist(user);
        return user;
    }

    public boolean changePassword(long id, String oldPassword, String newPassword) {
        User user = userDao.find(id);
        if (user == null) {
            return false;
        }
        if (user.getPassword().equals(oldPassword)) {
            user.setPassword(newPassword);
            userDao.persist(user);
            return true;
        }
        else {
            return false;
        }

    }
}
