/**
 * CartaoService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4.1-SNAPSHOT Nov 07, 2023 (07:57:58 UTC) WSDL2Java emitter.
 */

package com.patrickriibeiro.ws;

public interface CartaoService extends javax.xml.rpc.Service {
    public java.lang.String getCartaoAddress();

    public com.patrickriibeiro.ws.Cartao getCartao() throws javax.xml.rpc.ServiceException;

    public com.patrickriibeiro.ws.Cartao getCartao(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
