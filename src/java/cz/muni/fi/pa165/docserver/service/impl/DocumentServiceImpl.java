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
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PipedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Matus
 */
@Service("documentService")
public class DocumentServiceImpl implements DocumentService {

    private static Logger log = Logger.getLogger(DocumentService.class);
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
        Date now = new Date();
        File doc = new File(document.getTitle() + "_" + document.getAuthor().getName() + "_" + now.getTime() + ".pdf");
        FileOutputStream fos = null;
        //log.debug(binaryData);
        try {
            fos = new FileOutputStream(doc);
            fos.write(binaryData.getBytes());
            fos.close();
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
        }


        DocumentFile df = new DocumentFile();
        df.setFilename(doc.getName());
        df.setCreationDate(now);

        document.setCreationDate(now);

        DocumentFile[] files = {(df)};
        document.setFiles(files);
        docDao.persist(DtoToDocument(document));
        return true;
    }

    public boolean addDocumentRevision(long id, String fileName, String binaryData) {
        Date now = new Date();
        Document document = docDao.find(id);
        File doc = new File(document.getTitle() + "_" + document.getAuthor().getName() + "_" + now.getTime() + ".pdf");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(doc);
            fos.write(binaryData.getBytes());
            fos.flush();
            fos.close();
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
        }
        DocumentFile df = new DocumentFile();
        df.setFilename(fileName);
        df.setCreationDate(now);
        document.getFiles().add(df);
        docDao.merge(document);
        return true;
    }

    public DocumentDto[] getDocumentsByUserId(long id, int from, int num, String orderBy) {
        List<Document> docs = null;
        if ("title".equals(orderBy)) {
            docs = docDao.executeNamedQuery("getDocumentsByUserId", from, num, id);
        }
        if ("date".equals(orderBy)) {
            docs = docDao.executeNamedQuery("getDocumentsByUserIdDate", from, num, id);
        }
        DocumentDto[] ret = new DocumentDto[docs.size()];
        for (int i = 0; i < docs.size(); i++) {
            ret[i] = documentToDto(docs.get(i));
        }
        return ret;
    }

    public DocumentDto[] getDocumentsByTags(String[] tags, int from, int num, String orderBy) {
        List<Document> docs = docDao.findByTags(tags, orderBy);

        DocumentDto[] ret = new DocumentDto[docs.size()];
        for (int i = 0; i < docs.size(); i++) {
            ret[i] = documentToDto(docs.get(i));
        }
        return ret;
    }

    public DocumentDto[] getDocumentsByFulltext(String[] query, int from, int num, String orderBy) {
        return getDocumentsByTags(query, from, num, orderBy);
    }

    public DocumentDto[] getDocuments(long id, int from, int num, String orderBy) {
        List<Document> docs = null;
        if (orderBy.equals("title")) {
            docs = docDao.executeNamedQuery("getVisible", from, num, id);
        }
        if (orderBy.equals("date")) {
            docs = docDao.executeNamedQuery("getVisibleByDate", from, num, id);
        }
        DocumentDto[] ret = new DocumentDto[docs.size()];
        for (int i = 0; i < docs.size(); i++) {
            ret[i] = documentToDto(docs.get(i));
        }
        return ret;
    }

    public int getDocumentCountByUserId(long id) {
        return docDao.findByNamedQuery(Long.class, "getDocumentCountByUserId", id).intValue();
    }

    public int getDocumentCountByTags(String[] tags) {
        return docDao.findByTags(tags, "title").size();
    }

    public int getDocumentCountByFulltext(String[] query) {
        return getDocumentCountByTags(query);
    }

    public int getDocumentCount(long id) {
        return docDao.findByNamedQuery(Long.class, "getVisibleCount", id).intValue();
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
        for (DocumentFile df : d.getFiles()) {
            if (df.getId() == docId) {
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
        doc.setTitle(title);
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

    public String getDocumentFile(long revisionId, long documentId) {
        Document document = docDao.find(documentId);
        DocumentFile file = null;
        for (DocumentFile df : document.getFiles()) {
            if (df.getId() == revisionId) {
                file = df;
            }
        }
        //File text = new File(document.getTitle() + "_" + document.getAuthor().getName() + "_" + file.getCreationDate().getTime() + ".pdf");
        File text = new File(file.getFilename());
        FileInputStream fis;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        String ret = "";
        try {
            fis = new FileInputStream(text);
            BufferedInputStream bis = new BufferedInputStream(fis);
            byte[] bytes = new byte[16384];
            int read = 0;
            while ((read = bis.read(bytes)) != -1) {
                buffer.write(bytes, 0, read);
            }
            //bis.read(bytes);
            //ret = new String(bytes);
            ret = new String(buffer.toByteArray());
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
        }
        return ret;
    }
}
