/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.docserver.service;

import cz.muni.fi.pa165.docserver.dto.DocumentDto;
import cz.muni.fi.pa165.docserver.entities.Document;
import cz.muni.fi.pa165.docserver.entities.DocumentFile;
import cz.muni.fi.pa165.docserver.entities.Tag;

/**
 *
 * @author Matus
 */
public interface DocumentService extends GenericEntityService<Document> {

    /**
     * 
     * @param document Information about document, including the base DocumentFile
     * data about revision 1
     * @param binaryData Base64 encoded binary data of the document
     * @return true if document was added or false otherwise
     */
    boolean addDocument(DocumentDto document, String binaryData);

    /**
     * Add new revision to the document. Revisions are simply indetified by date
     * of submission.
     *
     * @param id Id of the document to which we're adding the revision
     * @param docFile Revision data
     * @param binaryData Base64 encoded binary data of the document
     * @return true if document was added or false otherwise
     */
    boolean addDocumentRevision(long id, String fileName, String binaryData); // missing the binary data

    /**
     * Return all public documents of given user.
     *
     * @param id Id of user whom documents we want to view
     * @param from Offset of the resultset
     * @param num Number of documents returned
     * @return Serializable representation of {@code Document[]}
     */
    DocumentDto[] getDocumentsByUserId(long id, int from, int num);

    /**
     * Return all public documents of given user.
     *
     * @param tags Tags by which we look for documents
     * @param from Offset of the resultset
     * @param num Number of documents returned
     * @return Serializable representation of {@code Document[]}
     */
    DocumentDto[] getDocumentsByTags(String[] tags, int from, int num);

    /**
     * Return all public documents of given user.
     *
     * @param query Fulltext query by which we look for documents
     * @param from Offset of the resultset
     * @param num Number of documents returned
     * @return Serializable representation of {@code Document[]}
     */
    DocumentDto[] getDocumentsByFulltext(String[] query, int from, int num);

    /**
     * Utility method used to calculate pagination. PageCount = TotalCount/PerPage
     * 
     * @param id Id of user whom documents we want to count
     * @return Total count of all documents owned by this user
     */
    int getDocumentCountByUserId(long id);

    /**
     * Utility method used to calculate pagination. PageCount = TotalCount/PerPage
     *
     * @param tags Tags by which we look for documents
     * @return Total number of documents with given tags
     */
    int getDocumentCountByTags(String[] tags);

    /**
     * Utility method used to calculate pagination. PageCount = TotalCount/PerPage
     *
     * @param query Fulltext query by which we look for documents
     * @return Total number of documents found by given fulltext query
     */
    int getDocumentCountByFulltext(String[] query);

    /**
     * Return the document with all revisions
     *
     * @param id Id of the document
     * @return Serializable representation of {@code Document}
     */
    DocumentDto getDocumentById(long id);

    /**
     * Remove the document and all of its revisions
     * @param id Id of the document
     * @return true if removed, false otherwise
     */
    boolean removeDocument(long id);

    /**
     * Remove specific revision from document
     *
     * @param docId Id of the document
     * @param revisionId Id of the revision
     * @return true if removed, false otherwise
     */
    boolean removeDocumentRevision(long docId, long revisionId);

    /**
     * Changes meta-data about the document. <b>All</b> parameters are reflected to
     * data storage media. If you want to change only some of them, you have to
     * set the rest to the original ("old") value.
     *
     * @param id Id of the document we want to change
     * @param title New title of the document
     * @param tags New tags of the document
     * @param description New description of the document
     * @param isPublic New public/private status for the document
     * @return True if all changes are succesfuly reflected, or false otherwise
     */
    boolean changeMetaData(long id, String title, Tag[] tags, String description, boolean isPublic);

}
