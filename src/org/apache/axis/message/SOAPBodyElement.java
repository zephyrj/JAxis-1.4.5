/*
 * Copyright 2001-2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.axis.message;

import org.apache.axis.AxisFault;
import org.apache.axis.InternalException;
import org.apache.axis.components.logger.LogFactory;
import org.apache.axis.encoding.DeserializationContext;
import org.apache.axis.utils.Messages;
import org.apache.axis.utils.XMLUtils;
import org.apache.commons.logging.Log;
import org.w3c.dom.*;
import org.xml.sax.Attributes;

import javax.xml.namespace.QName;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import java.io.InputStream;
import java.util.Iterator;

/** 
 * A Body element.
 */
public class SOAPBodyElement extends MessageElement
    implements javax.xml.soap.SOAPBodyElement {

    private static Log log =
        LogFactory.getLog(SOAPBodyElement.class.getName());

    public SOAPBodyElement(String namespace,
                           String localPart,
                           String prefix,
                           Attributes attributes,
                           DeserializationContext context)
        throws AxisFault 
    {
        super(namespace, localPart, prefix, attributes, context);
    }

    public SOAPBodyElement(Name name) 
    {
        super(name);
    }

    public SOAPBodyElement(QName qname)
    {
        super(qname);
    }

    public SOAPBodyElement(QName qname, Object value)
    {
        super(qname, value);
    }

    public SOAPBodyElement(Element elem)
    {
        super(elem);
    }
    
    public SOAPBodyElement() 
    {
    }

    public SOAPBodyElement(InputStream input) 
    {
        super( getDocumentElement(input) );
    }

    public SOAPBodyElement(String namespace, String localPart)
    {
        super(namespace, localPart);
    }

    private static Element getDocumentElement(InputStream input)
    {
        try {
            return XMLUtils.newDocument(input).getDocumentElement();
        } catch (Exception e) {
            throw new InternalException(e);
        }
    }

    public void setParentElement(SOAPElement parent) throws SOAPException {
        if(parent == null) {
            throw new IllegalArgumentException(Messages.getMessage("nullParent00")); 
        }
        // migration aid
        if (parent instanceof SOAPEnvelope) {
            log.warn(Messages.getMessage("bodyElementParent"));
            parent = ((SOAPEnvelope)parent).getBody();
        }
        if (!(parent instanceof SOAPBody) && !(parent instanceof RPCElement)) {
            throw new IllegalArgumentException(Messages.getMessage("illegalArgumentException00"));
        }
        
        super.setParentElement(parent);
    }

    public SOAPElement addChildElement(QName qname) throws SOAPException {
        return null;
    }

    public SOAPElement addAttribute(QName qname, String value) throws SOAPException {
        return null;
    }

    public String getAttributeValue(QName qname) {
        return null;
    }

    public Iterator getAllAttributesAsQNames() {
        return null;
    }

    public QName createQName(String localName, String prefix) throws SOAPException {
        return null;
    }

    public QName getElementQName() {
        return null;
    }

    public SOAPElement setElementQName(QName newName) throws SOAPException {
        return null;
    }

    public boolean removeAttribute(QName qname) {
        return false;
    }

    public TypeInfo getSchemaTypeInfo() {
        return null;
    }

    public void setIdAttribute(String name, boolean isId) throws DOMException {

    }

    public void setIdAttributeNS(String namespaceURI, String localName, boolean isId) throws DOMException {

    }

    public void setIdAttributeNode(Attr idAttr, boolean isId) throws DOMException {

    }

    public String getBaseURI() {
        return null;
    }

    public short compareDocumentPosition(Node other) throws DOMException {
        return 0;
    }

    public String getTextContent() throws DOMException {
        return null;
    }

    public void setTextContent(String textContent) throws DOMException {

    }

    public boolean isSameNode(Node other) {
        return false;
    }

    public String lookupPrefix(String namespaceURI) {
        return null;
    }

    public boolean isDefaultNamespace(String namespaceURI) {
        return false;
    }

    public String lookupNamespaceURI(String prefix) {
        return null;
    }

    public boolean isEqualNode(Node arg) {
        return false;
    }

    public Object getFeature(String feature, String version) {
        return null;
    }

    public Object setUserData(String key, Object data, UserDataHandler handler) {
        return null;
    }

    public Object getUserData(String key) {
        return null;
    }
}
