/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.docserver.dao;

import cz.muni.fi.pa165.docserver.entities.Document;
import java.util.List;

/**
 * Handles data access for <code>Document</code>, <code>DocumentFile</code> and
 * <code>Tag</code> entities
 * @author Matus
 */
public interface DocumentDao extends GenericDao<Document> {
     public List<Document> findByTags(String[] tags, String orderBy);
}
