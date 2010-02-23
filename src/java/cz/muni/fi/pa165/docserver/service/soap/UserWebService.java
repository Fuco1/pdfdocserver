/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.docserver.service.soap;

import cz.muni.fi.pa165.docserver.entities.User;
import cz.muni.fi.pa165.docserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.jaxrpc.ServletEndpointSupport;

/**
 *
 * @author Matus
 */
public class UserWebService extends ServletEndpointSupport implements UserService {

    @Autowired
    private UserService logic;

    @Override
    protected final void onInit() {
        this.logic = (UserService) getWebApplicationContext().getBean("userService");
    }

    public User getUserById(long id) {
        return logic.getUserById(id);
    }

    public User getUserByName(String name) {
        return logic.getUserByName(name);
    }

    public User addUser(String name, String password) {
        return logic.addUser(name, password);
    }

    public boolean changePassword(long id, String oldPassword, String newPassword) {
        return logic.changePassword(id, oldPassword, newPassword);
    }

    public void persist(User entity) {
        logic.persist(entity);
    }

    public User merge(User entity) {
        return logic.merge(entity);
    }

    public void remove(User entity) {
        logic.remove(entity);
    }
}
