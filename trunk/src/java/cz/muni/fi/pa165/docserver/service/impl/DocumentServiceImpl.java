/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.docserver.service.impl;

import cz.muni.fi.pa165.docserver.dao.DocumentDao;
import cz.muni.fi.pa165.docserver.dto.DocumentDto;
import cz.muni.fi.pa165.docserver.entities.Document;
import cz.muni.fi.pa165.docserver.entities.Tag;
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

    public DocumentDto[] getDocumentsByUserId(long id, int from, int num) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public DocumentDto[] getDocumentsByTags(String[] tags, int from, int num) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public DocumentDto[] getDocumentsByFulltext(String[] query, int from, int num) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getDocumentCountByUserId(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getDocumentCountByTags(String[] tags) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getDocumentCountByFulltext(String[] query) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public DocumentDto getDocumentById(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean removeDocument(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean changeMetaData(long id, String title, Tag[] tags, String description, boolean isPublic) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
