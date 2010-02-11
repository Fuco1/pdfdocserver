/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.docserver.service.impl;

import cz.muni.fi.pa165.docserver.dao.UserDao;
import cz.muni.fi.pa165.docserver.entities.User;
import cz.muni.fi.pa165.docserver.service.UserService;
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
}