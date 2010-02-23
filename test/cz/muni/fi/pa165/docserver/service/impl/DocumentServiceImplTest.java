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
import cz.muni.fi.pa165.docserver.entities.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
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
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"beans.xml"});
        instance = (DocumentServiceImpl) context.getBean("documentService");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addDocument method, of class DocumentServiceImpl.
     */
    //@Test
    public void testAddDocument() {
        System.out.println("addDocument");
        DocumentDto document = new DocumentDto();
        User user = new User();
        user.setId(2L);
        user.setName("Fero");
        user.setPassword("pass");
        document.setAuthor(user);
        document.setCreationDate(new Date());
        document.setDescription("testovaci doc...");
        document.setFiles(new DocumentFile[0]);
        document.setIsPublic(true);
        document.setTitle("Skripta");
        Tag[] taggs = new Tag[2];
        Tag t = new Tag();
        t.setId(Long.MIN_VALUE);
        t.setTag("byFero");
        taggs[0] = t;
        Tag t2 = new Tag();
        t2.setId(Long.MIN_VALUE);
        t2.setTag("skripta");
        taggs[1] = t2;
        document.setTags(taggs);
        String binaryData = "";
        boolean expResult = false;
        boolean result = true;
        instance.addDocument(document, binaryData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addDocumentRevision method, of class DocumentServiceImpl.
     */
    //@Test
    public void testAddDocumentRevision() {
        System.out.println("addDocumentRevision");
        long id = 152L;
        DocumentFile docFile = null;
        String binaryData = "";
        boolean expResult = false;
        boolean result = instance.addDocumentRevision(id, "lol", binaryData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDocumentsByUserId method, of class DocumentServiceImpl. TESTED
     */
    //@Test
    public void testGetDocumentsByUserId() {
        System.out.println("getDocumentsByUserId");
        long id = 2L;
        int from = 0;
        int num = 2;
        DocumentDto[] expResult = null;
        DocumentDto[] result = instance.getDocumentsByUserId(id, from, num, "");
        System.out.println(result[1].getFiles().length + " " + result[1].getTitle());
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
        String[] tags = {"byFero"};
        int from = 0;
        int num = 2;
        DocumentDto[] expResult = null;
        DocumentDto[] result = instance.getDocumentsByTags(tags, from, num, "");
        System.out.println(result[0].getTitle());
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of getDocumentsByFulltext method, of class DocumentServiceImpl.
//     */
//    @Test
//    public void testGetDocumentsByFulltext() {
//        System.out.println("getDocumentsByFulltext");
//        String[] query = null;
//        int from = 0;
//        int num = 0;
//        DocumentDto[] expResult = null;
//        DocumentDto[] result = instance.getDocumentsByFulltext(query, from, num);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getDocumentCountByUserId method, of class DocumentServiceImpl.
//     */
//    @Test
//    public void testGetDocumentCountByUserId() {
//        System.out.println("getDocumentCountByUserId");
//        long id = 0L;
//        int expResult = 0;
//        int result = instance.getDocumentCountByUserId(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getDocumentCountByTags method, of class DocumentServiceImpl.
//     */
//    @Test
//    public void testGetDocumentCountByTags() {
//        System.out.println("getDocumentCountByTags");
//        String[] tags = null;
//        int expResult = 0;
//        int result = instance.getDocumentCountByTags(tags);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getDocumentCountByFulltext method, of class DocumentServiceImpl.
//     */
//    @Test
//    public void testGetDocumentCountByFulltext() {
//        System.out.println("getDocumentCountByFulltext");
//        String[] query = null;
//        int expResult = 0;
//        int result = instance.getDocumentCountByFulltext(query);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getDocumentById method, of class DocumentServiceImpl.
//     */
//    @Test
//    public void testGetDocumentById() {
//        System.out.println("getDocumentById");
//        long id = 0L;
//        DocumentDto expResult = null;
//        DocumentDto result = instance.getDocumentById(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of removeDocument method, of class DocumentServiceImpl.
//     */
//    @Test
//    public void testRemoveDocument() {
//        System.out.println("removeDocument");
//        long id = 0L;
//        boolean expResult = false;
//        boolean result = instance.removeDocument(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of removeDocumentRevision method, of class DocumentServiceImpl.
//     */
//    @Test
//    public void testRemoveDocumentRevision() {
//        System.out.println("removeDocumentRevision");
//        long docId = 0L;
//        long revisionId = 0L;
//        boolean expResult = false;
//        boolean result = instance.removeDocumentRevision(docId, revisionId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of changeMetaData method, of class DocumentServiceImpl.
//     */
//    @Test
//    public void testChangeMetaData() {
//        System.out.println("changeMetaData");
//        long id = 0L;
//        String title = "";
//        Tag[] tags = null;
//        String description = "";
//        boolean isPublic = false;
//        boolean expResult = false;
//        boolean result = instance.changeMetaData(id, title, tags, description, isPublic);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of documentToDto method, of class DocumentServiceImpl.
//     */
//    @Test
//    public void testDocumentToDto() {
//        System.out.println("documentToDto");
//        Document doc = null;
//        DocumentDto expResult = null;
//        DocumentDto result = instance.documentToDto(doc);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of DtoToDocument method, of class DocumentServiceImpl.
//     */
//    @Test
//    public void testDtoToDocument() {
//        System.out.println("DtoToDocument");
//        DocumentDto doc = null;
//        Document expResult = null;
//        Document result = instance.DtoToDocument(doc);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    static String pdftoText(String fileName) {
        PDFParser parser;
        String parsedText = null;
        PDFTextStripper pdfStripper = null;
        PDDocument pdDoc = null;
        COSDocument cosDoc = null;
        File file = new File(fileName);
        if (!file.isFile()) {
            System.err.println("File " + fileName + " does not exist.");
            return null;
        }
        try {
            parser = new PDFParser(new FileInputStream(file));
        } catch (IOException e) {
            System.err.println("Unable to open PDF Parser. " + e.getMessage());
            return null;
        }
        try {
            parser.parse();
            cosDoc = parser.getDocument();
            pdfStripper = new PDFTextStripper();
            pdDoc = new PDDocument(cosDoc);
            pdfStripper.setStartPage(1);
            pdfStripper.setEndPage(500);
            parsedText = pdfStripper.getText(pdDoc);
        } catch (Exception e) {
            System.err.println("An exception occured in parsing the PDF Document." + e.getMessage());
        } finally {
            try {
                if (cosDoc != null) {
                    cosDoc.close();
                }
                if (pdDoc != null) {
                    pdDoc.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return parsedText;
    }
}
