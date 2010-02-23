/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.docserver.service.impl;

import cz.muni.fi.pa165.docserver.dao.DocumentDao;
import cz.muni.fi.pa165.docserver.dto.DocumentDto;
import cz.muni.fi.pa165.docserver.entities.Document;
import cz.muni.fi.pa165.docserver.entities.DocumentFile;
import cz.muni.fi.pa165.docserver.entities.Tag;
import cz.muni.fi.pa165.docserver.service.DocumentService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public boolean addDocument(DocumentDto document, String binaryData) {
        File doc = new File(document.getTitle() + "_" + document.getAuthor().getName() + "_" + new Date().getTime() + ".pdf");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(doc);
            fos.write(binaryData.getBytes());
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(DocumentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        DocumentFile df = new DocumentFile();
        df.setFilename(doc.getName());
        df.setCreationDate(new Date());
        DocumentFile[] files = {(df)};
        document.setFiles(files);
        docDao.persist(DtoToDocument(document));
        return true;
    }

    public boolean addDocumentRevision(long id, String fileName, String binaryData) {
        Document document = docDao.find(id);
        File doc = new File(document.getTitle() + "_" + document.getAuthor().getName() + "_" + new Date().getTime() + ".pdf");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(doc);
            fos.write(binaryData.getBytes());
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(DocumentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        DocumentFile df = new DocumentFile();
        df.setFilename(fileName);
        df.setCreationDate(new Date());
        document.getFiles().add(df);
        docDao.merge(document);
        return true;
    }

    public DocumentDto[] getDocumentsByUserId(long id, int from, int num, String orderBy) {
        List<Document> docs = docDao.executeNamedQuery("getDocumentsByUserId", from, num, id);
        DocumentDto[] ret = new DocumentDto[docs.size()];
        for (int i = 0; i < docs.size(); i++) {
            ret[i] = documentToDto(docs.get(i));
        }
        return ret;
    }

    public DocumentDto[] getDocumentsByTags(String[] tags, int from, int num, String orderBy) {
        List<Document> docs = docDao.findByTags(tags);

        DocumentDto[] ret = new DocumentDto[docs.size()];
        for (int i = 0; i < docs.size(); i++) {
            ret[i] = documentToDto(docs.get(i));
        }
        return ret;
    }

    public DocumentDto[] getDocumentsByFulltext(String[] query, int from, int num, String orderBy) {
        return getDocumentsByTags(query, from, num, orderBy);
    }

    public DocumentDto[] getDocuments(int id, int from, int num, String orderBy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getDocumentCountByUserId(long id) {
        return docDao.findByNamedQuery(Integer.class, "getDocumentCountByUserId", id);
    }

    public int getDocumentCountByTags(String[] tags) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getDocumentCountByFulltext(String[] query) {
        return getDocumentCountByTags(query);
    }

    public DocumentDto getDocumentById(long id) {
        return documentToDto(docDao.find(id));
    }

    public boolean removeDocument(long id) {
        Document doc = docDao.find(id);
        if (doc == null) {
            return false;
        }
        remove(doc);
        return true;
    }

    public boolean removeDocumentRevision(long docId, long revisionId) {
        DocumentDto doc = getDocumentById(docId);
        Document d = DtoToDocument(doc);
        boolean flag = false;
        for(DocumentFile df : d.getFiles()) {
            if(df.getId() == docId) {
                d.getFiles().remove(df);
                flag = true;
            }
        }
        docDao.merge(d);
        return flag;
    }

    public boolean changeMetaData(long id, String title, Tag[] tags, String description, boolean isPublic) {
        Document doc = docDao.find(id);
        if (doc == null) {
            return false;
        }
        doc.setTags(Arrays.asList(tags));
        doc.setDescription(description);
        doc.setIsPublic(isPublic);
        docDao.merge(doc);
        return true;
    }

    private DocumentDto documentToDto(Document doc) {
        Tag[] tags = new Tag[doc.getTags().size()];
        return new DocumentDto(doc.getId(), doc.getTitle(), doc.getAuthor(), doc.getCreationDate(), doc.getTags().toArray(tags), doc.getDescription(), doc.getFiles().toArray(new DocumentFile[0]), doc.isIsPublic());
    }

    private Document DtoToDocument(DocumentDto doc) {
        Document d = new Document();
        d.setId(doc.getId());
        d.setAuthor(doc.getAuthor());
        d.setIsPublic(doc.isIsPublic());
        d.setDescription(doc.getDescription());
        d.setCreationDate(doc.getCreationDate());
        List<Tag> tags = new ArrayList<Tag>();
        for (int i = 0; i < doc.getTags().length; i++) {
            tags.add(doc.getTags()[i]);
        }
        d.setTags(tags);
        List<DocumentFile> files = new ArrayList<DocumentFile>();
        for (int i = 0; i < doc.getFiles().length; i++) {
            files.add(doc.getFiles()[i]);
        }
        d.setFiles(files);
        d.setTitle(doc.getTitle());
        return d;
    }

    public byte[] getDocumentFile(long revisionId, long documentId) {
        return new byte[0];
    }
}
