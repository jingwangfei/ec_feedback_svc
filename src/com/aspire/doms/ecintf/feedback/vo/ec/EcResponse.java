package com.aspire.doms.ecintf.feedback.vo.ec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProcID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TransIDO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TransIDOTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TransIDH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransIDHTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}Response"/>
 *         &lt;element name="SvcCont" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "procID",
    "transIDO",
    "transIDOTime",
    "transIDH",
    "transIDHTime",
    "response",
    "svcCont"
})
@XmlRootElement(name = "EcResponse")
public class EcResponse {

    @XmlElement(name = "ProcID", required = true)
    protected String procID;
    @XmlElement(name = "TransIDO", required = true)
    protected String transIDO;
    @XmlElement(name = "TransIDOTime", required = true)
    protected String transIDOTime;
    @XmlElement(name = "TransIDH")
    protected String transIDH;
    @XmlElement(name = "TransIDHTime")
    protected String transIDHTime;
    @XmlElement(name = "Response", required = true)
    protected Response response;
    @XmlCDATA
    @XmlElement(name = "SvcCont")
    protected String svcCont;

    /**
     * Gets the value of the procID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcID() {
        return procID;
    }

    /**
     * Sets the value of the procID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcID(String value) {
        this.procID = value;
    }

    /**
     * Gets the value of the transIDO property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransIDO() {
        return transIDO;
    }

    /**
     * Sets the value of the transIDO property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransIDO(String value) {
        this.transIDO = value;
    }

    /**
     * Gets the value of the transIDOTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransIDOTime() {
        return transIDOTime;
    }

    /**
     * Sets the value of the transIDOTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransIDOTime(String value) {
        this.transIDOTime = value;
    }

    /**
     * Gets the value of the transIDH property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransIDH() {
        return transIDH;
    }

    /**
     * Sets the value of the transIDH property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransIDH(String value) {
        this.transIDH = value;
    }

    /**
     * Gets the value of the transIDHTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransIDHTime() {
        return transIDHTime;
    }

    /**
     * Sets the value of the transIDHTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransIDHTime(String value) {
        this.transIDHTime = value;
    }

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link Response }
     *     
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link Response }
     *     
     */
    public void setResponse(Response value) {
        this.response = value;
    }

    /**
     * Gets the value of the svcCont property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSvcCont() {
        return svcCont;
    }

    /**
     * Sets the value of the svcCont property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSvcCont(String value) {
        this.svcCont = value;
    }

}
