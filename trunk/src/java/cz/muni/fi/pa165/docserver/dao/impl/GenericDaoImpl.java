/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.docserver.dao.impl;

import cz.muni.fi.pa165.docserver.dao.GenericDao;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Matus
 */
public abstract class GenericDaoImpl<T> extends JpaDaoSupport implements GenericDao<T> {

    private static Logger log = Logger.getLogger(GenericDao.class);
    private Class<T> persistentClass;

    public GenericDaoImpl() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Transactional
    public void persist(T entity) {
        getJpaTemplate().persist(entity);
        getJpaTemplate().flush();
    }

    @Transactional
    public void remove(T entity) {
        entity = getJpaTemplate().merge(entity);
        getJpaTemplate().remove(entity);
        getJpaTemplate().flush();
    }

    @Transactional
    public <T> T merge(T entity) {
        T re = getJpaTemplate().merge(entity);
        getJpaTemplate().flush();
        return re;
    }

    public T find(Long id) {
        T re = null;
        try {
            re = getJpaTemplate().getReference(persistentClass, id);
        } catch (Exception ex) {
            log.error("Error when retrieving entity of type " + persistentClass, ex);
        }
        return re;
    }

    public List<T> findAll() {
        try {
            return getJpaTemplate().find("SELECT p FROM " + persistentClass.getSimpleName() + " p");
        } catch (Exception ex) {
            log.error("Error when retrieving all entities of type " + persistentClass, ex);
            return null;
        }
    }

    public List<T> executeNamedQuery(String query, Object... values) {
        return getJpaTemplate().findByNamedQuery(query, values);
    }

    public <T> List<T> executeNamedQuery(Class<?> T, String query, Object... values) {
        return (List<T>) getJpaTemplate().findByNamedQuery(query, values);
    }

    public List<T> executeNamedQuery(String query, int start, int num, Object... values) {
        EntityManager em = getJpaTemplate().getEntityManagerFactory().createEntityManager();
        Query q = em.createNamedQuery(query).setFirstResult(start).setMaxResults(num);
        int i = 1;
        for (Object p : values) {
            q.setParameter(i, p);
            i++;
        }
        return q.getResultList();
    }

    @Transactional
    public int executeUpdate(String name, Object... values) {
        EntityManager em = getJpaTemplate().getEntityManagerFactory().createEntityManager();
        Query q = em.createNamedQuery(name);
        for (int i = 0; i < values.length; i++) {
            q.setParameter(i + 1, values[i]);
        }
        em.getTransaction().begin();
        int re = q.executeUpdate();
        em.getTransaction().commit();
        return re;
    }

    public <T> T findByNamedQuery(Class<T> type, String query, Object... values) {
        List list = getJpaTemplate().findByNamedQuery(query, values);
        if (list.size() == 1) {
            return (T) list.get(0);
        }
        else {
            return null;
        }
    }
}
