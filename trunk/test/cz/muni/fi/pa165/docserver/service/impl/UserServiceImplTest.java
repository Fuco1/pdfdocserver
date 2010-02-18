/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.docserver.service.impl;

import cz.muni.fi.pa165.docserver.dao.UserDao;
import cz.muni.fi.pa165.docserver.entities.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.junit.Assert.*;

/**
 *
 * @author Matus
 */
public class UserServiceImplTest {

    private UserServiceImpl instance;

    public UserServiceImplTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"web/WEB-INF/applicationContext.xml"});
        instance = (UserServiceImpl) context.getBean("userService");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of persist method, of class UserServiceImpl.
     */
    @Test
    public void testPersist() {
        System.out.println("persist");
        User entity = null;
        instance.persist(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of merge method, of class UserServiceImpl.
     */
    @Test
    public void testMerge() {
        System.out.println("merge");
        User entity = null;
        User expResult = null;
        User result = instance.merge(entity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class UserServiceImpl.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        User entity = null;
        instance.remove(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserDao method, of class UserServiceImpl.
     */
    @Test
    public void testSetUserDao() {
        System.out.println("setUserDao");
        UserDao userDao = null;
        instance.setUserDao(userDao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserById method, of class UserServiceImpl.
     */
    @Test
    public void testGetUserById() {
        System.out.println("getUserById");
        long id = 0L;
        User expResult = null;
        User result = instance.getUserById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserByName method, of class UserServiceImpl.
     */
    @Test
    public void testGetUserByName() {
        System.out.println("getUserByName");
        String name = "";
        User expResult = null;
        User result = instance.getUserByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUser method, of class UserServiceImpl.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        String name = "";
        String password = "";
        User expResult = null;
        User result = instance.addUser(name, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePassword method, of class UserServiceImpl.
     */
    @Test
    public void testChangePassword() {
        System.out.println("changePassword");
        long id = 0L;
        String oldPassword = "";
        String newPassword = "";
        boolean expResult = false;
        boolean result = instance.changePassword(id, oldPassword, newPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}