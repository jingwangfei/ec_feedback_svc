package com.aspire.doms.ecintf.feedback.vo.ec;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.aspire.bossrouter.vo.ec package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.aspire.bossrouter.vo.ec
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Response }
     * 
     */
    public Response createResponse() {
        return new Response();
    }

    /**
     * Create an instance of {@link EcResponse }
     * 
     */
    public EcResponse createEcResponse() {
        return new EcResponse();
    }

    /**
     * Create an instance of {@link EcRequest }
     * 
     */
    public EcRequest createEcRequest() {
        return new EcRequest();
    }

    /**
     * Create an instance of {@link Routing }
     * 
     */
    public Routing createRouting() {
        return new Routing();
    }

}
