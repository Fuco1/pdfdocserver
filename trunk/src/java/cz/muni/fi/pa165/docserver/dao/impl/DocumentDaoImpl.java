/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.docserver.dao.impl;

import cz.muni.fi.pa165.docserver.dao.DocumentDao;
import cz.muni.fi.pa165.docserver.entities.Document;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Matus
 */
@Repository("documentDao")
public class DocumentDaoImpl extends GenericDaoImpl<Document> implements DocumentDao {
}
