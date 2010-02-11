/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.docserver.dao.impl;

import cz.muni.fi.pa165.docserver.dao.UserDao;
import cz.muni.fi.pa165.docserver.entities.User;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Matus
 */
@Repository("userDao")
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
}
