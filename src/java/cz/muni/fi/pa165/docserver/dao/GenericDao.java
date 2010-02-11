/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.docserver.dao;

import java.util.List;

/**
 *
 * @author Matus
 */
public interface GenericDao<T> {

    void persist(T entity);

    void remove(T entity);

    <T> T merge(T entity);

    T find(Long id);

    List<T> findAll();

    List<T> executeNamedQuery(String query, Object... values);

    <T> List<T> executeNamedQuery(Class<?> T, String query, Object... values);

    List<T> executeNamedQuery(String query, int start, int num, Object... values);

    int executeUpdate(String name, Object... values);

    <T> T findByNamedQuery(Class<T> type, String query, Object... values);
}
