/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.docserver.service.soap;

import cz.muni.fi.pa165.docserver.dto.DocumentDto;
import cz.muni.fi.pa165.docserver.entities.Document;
import cz.muni.fi.pa165.docserver.entities.Tag;
import cz.muni.fi.pa165.docserver.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.jaxrpc.ServletEndpointSupport;

/**
 *
 * @author Matus
 */
public class DocumentWebService extends ServletEndpointSupport implements DocumentService {

    @Autowired
    private DocumentService logic;

    @Override
    protected final void onInit() {
        this.logic = (DocumentService) getWebApplicationContext().getBean("documentService");
    }

    public boolean addDocument(DocumentDto document, String binaryData) {
        return logic.addDocument(document, binaryData);
    }

    public boolean addDocumentRevision(long id, String fileName, String binaryData) {
        return logic.addDocumentRevision(id, fileName, binaryData);
    }

    public DocumentDto[] getDocumentsByUserId(long id, int from, int num, String orderBy) {
        return logic.getDocumentsByUserId(id, from, num, orderBy);
    }

    public DocumentDto[] getDocumentsByTags(String[] tags, int from, int num, String orderBy) {
        return logic.getDocumentsByTags(tags, from, num, orderBy);
    }

    public DocumentDto[] getDocumentsByFulltext(String[] query, int from, int num, String orderBy) {
        return logic.getDocumentsByFulltext(query, from, num, orderBy);
    }

    public DocumentDto[] getDocuments(int id, int from, int num, String orderBy) {
        return logic.getDocuments(id, from, num, orderBy);
    }

    public int getDocumentCountByUserId(long id) {
        return logic.getDocumentCountByUserId(id);
    }

    public int getDocumentCountByTags(String[] tags) {
        return logic.getDocumentCountByTags(tags);
    }

    public int getDocumentCountByFulltext(String[] query) {
        return logic.getDocumentCountByFulltext(query);
    }

    public DocumentDto getDocumentById(long id) {
        return getDocumentById(id);
    }

    public boolean removeDocument(long id) {
        return logic.removeDocument(id);
    }

    public boolean removeDocumentRevision(long docId, long revisionId) {
        return logic.removeDocumentRevision(docId, revisionId);
    }

    public boolean changeMetaData(long id, String title, Tag[] tags, String description, boolean isPublic) {
        return logic.changeMetaData(id, title, tags, description, isPublic);
    }

    public void persist(Document entity) {
        logic.persist(entity);
    }

    public Document merge(Document entity) {
        return logic.merge(entity);
    }

    public void remove(Document entity) {
        logic.remove(entity);
    }

    public String getDocumentFile(long revisionId, long documentId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
