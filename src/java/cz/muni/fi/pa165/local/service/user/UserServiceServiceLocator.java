/**
 * UserServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cz.muni.fi.pa165.local.service.user;

public class UserServiceServiceLocator extends org.apache.axis.client.Service implements cz.muni.fi.pa165.local.service.user.UserServiceService {

    public UserServiceServiceLocator() {
    }


    public UserServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public UserServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for UserService
    private java.lang.String UserService_address = "http://localhost:8080//DocServer/services/UserService";

    public java.lang.String getUserServiceAddress() {
        return UserService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String UserServiceWSDDServiceName = "UserService";

    public java.lang.String getUserServiceWSDDServiceName() {
        return UserServiceWSDDServiceName;
    }

    public void setUserServiceWSDDServiceName(java.lang.String name) {
        UserServiceWSDDServiceName = name;
    }

    public cz.muni.fi.pa165.local.service.user.UserService getUserService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(UserService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getUserService(endpoint);
    }

    public cz.muni.fi.pa165.local.service.user.UserService getUserService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cz.muni.fi.pa165.local.service.user.UserServiceSoapBindingStub _stub = new cz.muni.fi.pa165.local.service.user.UserServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getUserServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setUserServiceEndpointAddress(java.lang.String address) {
        UserService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cz.muni.fi.pa165.local.service.user.UserService.class.isAssignableFrom(serviceEndpointInterface)) {
                cz.muni.fi.pa165.local.service.user.UserServiceSoapBindingStub _stub = new cz.muni.fi.pa165.local.service.user.UserServiceSoapBindingStub(new java.net.URL(UserService_address), this);
                _stub.setPortName(getUserServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("UserService".equals(inputPortName)) {
            return getUserService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:kb-ws-SiteUS", "UserServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:kb-ws-SiteUS", "UserService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("UserService".equals(portName)) {
            setUserServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
