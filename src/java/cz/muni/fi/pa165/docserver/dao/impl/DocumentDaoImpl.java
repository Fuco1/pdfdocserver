/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.docserver.dao.impl;

import cz.muni.fi.pa165.docserver.dao.DocumentDao;
import cz.muni.fi.pa165.docserver.entities.Document;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Matus
 */
@Repository("documentDao")
public class DocumentDaoImpl extends GenericDaoImpl<Document> implements DocumentDao {

    public List<Document> findByTags(String[] tags) {
        EntityManager em = getJpaTemplate().getEntityManagerFactory().createEntityManager();
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for(int i = 0;i<tags.length;i++) {
            sb.append(" \"" + tags[i] + "\"");
            if (i!=tags.length-1) sb.append(",");
        }
        sb.append(")");
        String query = "SELECT d.* FROM (Document d INNER JOIN document_tag it ON d.id = it.document_id) INNER JOIN Tag t ON it.tags_id = t.id WHERE (tag in " + sb.toString() + ") GROUP BY d.id";
        Query q = em.createNativeQuery(query, Document.class);
        List<Document> list = (List<Document>) q.getResultList();
        return list;
    }
}
