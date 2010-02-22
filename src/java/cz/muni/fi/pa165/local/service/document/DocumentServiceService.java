/**
 * DocumentServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cz.muni.fi.pa165.local.service.document;

public interface DocumentServiceService extends javax.xml.rpc.Service {
    public java.lang.String getDocumentServiceAddress();

    public cz.muni.fi.pa165.local.service.document.DocumentService getDocumentService() throws javax.xml.rpc.ServiceException;

    public cz.muni.fi.pa165.local.service.document.DocumentService getDocumentService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
