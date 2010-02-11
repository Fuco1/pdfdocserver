/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.docserver.service.impl;

import cz.muni.fi.pa165.docserver.dao.DocumentDao;
import cz.muni.fi.pa165.docserver.entities.Document;
import cz.muni.fi.pa165.docserver.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Matus
 */
@Service("documentService")
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentDao docDao;

    public void persist(Document entity) {
        docDao.persist(entity);
    }

    public Document merge(Document entity) {
        return docDao.merge(entity);
    }

    public void remove(Document entity) {
        docDao.remove(entity);
    }

    public void setDocDao(DocumentDao docDao) {
        this.docDao = docDao;
    }
}
