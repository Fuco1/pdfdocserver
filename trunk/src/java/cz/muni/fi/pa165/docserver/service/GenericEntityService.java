/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.docserver.service;

/**
 *
 * @author Matus
 */
public interface GenericEntityService<T> {

    void persist(T entity);

    T merge(T entity);

    void remove(T entity);
}
