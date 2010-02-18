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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.junit.Assert.*;

/**
 *
 * @author Matus
 */
public class DocumentServiceImplTest {

    private DocumentServiceImpl instance;

    public DocumentServiceImplTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"web/WEB-INF/applicationContext.xml"});
        instance = (DocumentServiceImpl) context.getBean("documentService");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of persist method, of class DocumentServiceImpl.
     */
    @Test
    public void testPersist() {
        System.out.println("persist");
        Document entity = null;
        instance.persist(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of merge method, of class DocumentServiceImpl.
     */
    @Test
    public void testMerge() {
        System.out.println("merge");
        Document entity = null;
        Document expResult = null;
        Document result = instance.merge(entity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class DocumentServiceImpl.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Document entity = null;
        instance.remove(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDocDao method, of class DocumentServiceImpl.
     */
    @Test
    public void testSetDocDao() {
        System.out.println("setDocDao");
        DocumentDao docDao = null;
        instance.setDocDao(docDao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addDocument method, of class DocumentServiceImpl.
     */
    @Test
    public void testAddDocument() {
        System.out.println("addDocument");
        DocumentDto document = null;
        String binaryData = "";
        boolean expResult = false;
        boolean result = instance.addDocument(document, binaryData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addDocumentRevision method, of class DocumentServiceImpl.
     */
    @Test
    public void testAddDocumentRevision() {
        System.out.println("addDocumentRevision");
        long id = 0L;
        DocumentFile docFile = null;
        String binaryData = "";
        boolean expResult = false;
        boolean result = instance.addDocumentRevision(id, docFile, binaryData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDocumentsByUserId method, of class DocumentServiceImpl.
     */
    @Test
    public void testGetDocumentsByUserId() {
        System.out.println("getDocumentsByUserId");
        long id = 0L;
        int from = 0;
        int num = 0;
        DocumentDto[] expResult = null;
        DocumentDto[] result = instance.getDocumentsByUserId(id, from, num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDocumentsByTags method, of class DocumentServiceImpl.
     */
    @Test
    public void testGetDocumentsByTags() {
        System.out.println("getDocumentsByTags");
        String[] tags = null;
        int from = 0;
        int num = 0;
        DocumentDto[] expResult = null;
        DocumentDto[] result = instance.getDocumentsByTags(tags, from, num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDocumentsByFulltext method, of class DocumentServiceImpl.
     */
    @Test
    public void testGetDocumentsByFulltext() {
        System.out.println("getDocumentsByFulltext");
        String[] query = null;
        int from = 0;
        int num = 0;
        DocumentDto[] expResult = null;
        DocumentDto[] result = instance.getDocumentsByFulltext(query, from, num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDocumentCountByUserId method, of class DocumentServiceImpl.
     */
    @Test
    public void testGetDocumentCountByUserId() {
        System.out.println("getDocumentCountByUserId");
        long id = 0L;
        int expResult = 0;
        int result = instance.getDocumentCountByUserId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDocumentCountByTags method, of class DocumentServiceImpl.
     */
    @Test
    public void testGetDocumentCountByTags() {
        System.out.println("getDocumentCountByTags");
        String[] tags = null;
        int expResult = 0;
        int result = instance.getDocumentCountByTags(tags);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDocumentCountByFulltext method, of class DocumentServiceImpl.
     */
    @Test
    public void testGetDocumentCountByFulltext() {
        System.out.println("getDocumentCountByFulltext");
        String[] query = null;
        int expResult = 0;
        int result = instance.getDocumentCountByFulltext(query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDocumentById method, of class DocumentServiceImpl.
     */
    @Test
    public void testGetDocumentById() {
        System.out.println("getDocumentById");
        long id = 0L;
        DocumentDto expResult = null;
        DocumentDto result = instance.getDocumentById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeDocument method, of class DocumentServiceImpl.
     */
    @Test
    public void testRemoveDocument() {
        System.out.println("removeDocument");
        long id = 0L;
        boolean expResult = false;
        boolean result = instance.removeDocument(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeDocumentRevision method, of class DocumentServiceImpl.
     */
    @Test
    public void testRemoveDocumentRevision() {
        System.out.println("removeDocumentRevision");
        long docId = 0L;
        long revisionId = 0L;
        boolean expResult = false;
        boolean result = instance.removeDocumentRevision(docId, revisionId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeMetaData method, of class DocumentServiceImpl.
     */
    @Test
    public void testChangeMetaData() {
        System.out.println("changeMetaData");
        long id = 0L;
        String title = "";
        Tag[] tags = null;
        String description = "";
        boolean isPublic = false;
        boolean expResult = false;
        boolean result = instance.changeMetaData(id, title, tags, description, isPublic);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of documentToDto method, of class DocumentServiceImpl.
     */
    @Test
    public void testDocumentToDto() {
        System.out.println("documentToDto");
        Document doc = null;
        DocumentDto expResult = null;
        DocumentDto result = instance.documentToDto(doc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DtoToDocument method, of class DocumentServiceImpl.
     */
    @Test
    public void testDtoToDocument() {
        System.out.println("DtoToDocument");
        DocumentDto doc = null;
        Document expResult = null;
        Document result = instance.DtoToDocument(doc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
