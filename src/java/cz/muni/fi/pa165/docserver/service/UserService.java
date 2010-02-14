/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.docserver.service;

import cz.muni.fi.pa165.docserver.entities.User;
import cz.muni.fi.pa165.docserver.exceptions.UserCannotBeCreatedException;

/**
 *
 * @author Matus
 */
public interface UserService extends GenericEntityService<User> {

    /**
     * Return instance of the {@code User}. Search by ID.
     *
     * @param id Unique ID of the user
     * @return User with the given ID, or null if user not found
     */
    User getUserById(long id);

    /**
     * Return instance of the {@code User}. Search by Name. Each
     * user has unique name.
     *
     * @param name Unique name of the user
     * @return User with the given name, or null if user not found
     */
    User getUserByName(String name);

    /**
     * Create new {@code User} and reflect changes into persistence media.
     *
     * @param name Name of new user
     * @param password Password of new user
     * @return Instance of the user just created
     * @throws UserCannotBeCreatedException
     *         If user with {@code name} already exists or if there was an error
     *         during persisting the instance.
     */
    User addUser(String name, String password) throws UserCannotBeCreatedException;

    /**
     * Change password of the user.
     *
     * @param id Id of the user whom we want to change the password
     * @param oldPassword Old password for verification
     * @param newPassword New password
     * @return true if password is changed, false otherwise
     */
    boolean changePassword(long id, String oldPassword, String newPassword);
}
