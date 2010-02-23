/**
 * DocumentService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cz.muni.fi.pa165.local.service.document;

public interface DocumentService extends java.rmi.Remote {
    public void remove(cz.muni.fi.pa165.docserver.entities.Document entity) throws java.rmi.RemoteException;
    public cz.muni.fi.pa165.docserver.entities.Document merge(cz.muni.fi.pa165.docserver.entities.Document entity) throws java.rmi.RemoteException;
    public boolean addDocument(cz.muni.fi.pa165.local.dto.DocumentDto document, java.lang.String binaryData) throws java.rmi.RemoteException;
    public void persist(cz.muni.fi.pa165.docserver.entities.Document entity) throws java.rmi.RemoteException;
    public boolean addDocumentRevision(long id, java.lang.String fileName, java.lang.String binaryData) throws java.rmi.RemoteException;
    public cz.muni.fi.pa165.local.dto.DocumentDto[] getDocumentsByUserId(long id, int from, int num, java.lang.String orderBy) throws java.rmi.RemoteException;
    public cz.muni.fi.pa165.local.dto.DocumentDto[] getDocumentsByTags(java.lang.String[] tags, int from, int num, java.lang.String orderBy) throws java.rmi.RemoteException;
    public cz.muni.fi.pa165.local.dto.DocumentDto[] getDocumentsByFulltext(java.lang.String[] query, int from, int num, java.lang.String orderBy) throws java.rmi.RemoteException;
    public cz.muni.fi.pa165.local.dto.DocumentDto[] getDocuments(int id, int from, int num, java.lang.String orderBy) throws java.rmi.RemoteException;
    public int getDocumentCountByUserId(long id) throws java.rmi.RemoteException;
    public int getDocumentCountByTags(java.lang.String[] tags) throws java.rmi.RemoteException;
    public int getDocumentCountByFulltext(java.lang.String[] query) throws java.rmi.RemoteException;
    public cz.muni.fi.pa165.local.dto.DocumentDto getDocumentById(long id) throws java.rmi.RemoteException;
    public boolean removeDocument(long id) throws java.rmi.RemoteException;
    public boolean removeDocumentRevision(long docId, long revisionId) throws java.rmi.RemoteException;
    public boolean changeMetaData(long id, java.lang.String title, cz.muni.fi.pa165.local.dto.Tag[] tags, java.lang.String description, boolean isPublic) throws java.rmi.RemoteException;
    public java.lang.String getDocumentFile(long revisionId, long documentId) throws java.rmi.RemoteException;
}
