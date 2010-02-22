/**
 * UserService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cz.muni.fi.pa165.local.service.user;

public interface UserService extends java.rmi.Remote {
    public void remove(cz.muni.fi.pa165.local.dto.User entity) throws java.rmi.RemoteException;
    public void remove(java.lang.Object x0) throws java.rmi.RemoteException;
    public java.lang.Object merge(java.lang.Object x0) throws java.rmi.RemoteException;
    public cz.muni.fi.pa165.local.dto.User merge(cz.muni.fi.pa165.local.dto.User entity) throws java.rmi.RemoteException;
    public void persist(cz.muni.fi.pa165.local.dto.User entity) throws java.rmi.RemoteException;
    public void persist(java.lang.Object x0) throws java.rmi.RemoteException;
    public void setUserDao(java.lang.Object userDao) throws java.rmi.RemoteException;
    public cz.muni.fi.pa165.local.dto.User getUserById(long id) throws java.rmi.RemoteException;
    public cz.muni.fi.pa165.local.dto.User getUserByName(java.lang.String name) throws java.rmi.RemoteException;
    public cz.muni.fi.pa165.local.dto.User addUser(java.lang.String name, java.lang.String password) throws java.rmi.RemoteException;
    public boolean changePassword(long id, java.lang.String oldPassword, java.lang.String newPassword) throws java.rmi.RemoteException;
}
