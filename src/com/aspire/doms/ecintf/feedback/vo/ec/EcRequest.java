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
 *         &lt;element name="BIPCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ActivityCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OrigDomain" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HomeDomain" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}Routing"/>
 *         &lt;element name="ProcID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransIDO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransIDOTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SvcCont" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "bipCode",
    "activityCode",
    "origDomain",
    "homeDomain",
    "routing",
    "procID",
    "transIDO",
    "transIDOTime",
    "svcCont"
})
@XmlRootElement(name = "EcRequest")
public class EcRequest {

    @XmlElement(name = "BIPCode", required = true)
    protected String bipCode;
    @XmlElement(name = "ActivityCode", required = true)
    protected String activityCode;
    @XmlElement(name = "OrigDomain")
    protected String origDomain;
    @XmlElement(name = "HomeDomain")
    protected String homeDomain;
    @XmlElement(name = "Routing", required = true)
    protected Routing routing;
    @XmlElement(name = "ProcID")
    protected String procID;
    @XmlElement(name = "TransIDO")
    protected String transIDO;
    @XmlElement(name = "TransIDOTime")
    protected String transIDOTime;
    @XmlCDATA
    @XmlElement(name = "SvcCont", required = true)
    protected String svcCont;

    /**
     * Gets the value of the bipCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBIPCode() {
        return bipCode;
    }

    /**
     * Sets the value of the bipCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBIPCode(String value) {
        this.bipCode = value;
    }

    /**
     * Gets the value of the activityCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityCode() {
        return activityCode;
    }

    /**
     * Sets the value of the activityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityCode(String value) {
        this.activityCode = value;
    }

    /**
     * Gets the value of the origDomain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigDomain() {
        return origDomain;
    }

    /**
     * Sets the value of the origDomain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigDomain(String value) {
        this.origDomain = value;
    }

    /**
     * Gets the value of the homeDomain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeDomain() {
        return homeDomain;
    }

    /**
     * Sets the value of the homeDomain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeDomain(String value) {
        this.homeDomain = value;
    }

    /**
     * Gets the value of the routing property.
     * 
     * @return
     *     possible object is
     *     {@link Routing }
     *     
     */
    public Routing getRouting() {
        return routing;
    }

    /**
     * Sets the value of the routing property.
     * 
     * @param value
     *     allowed object is
     *     {@link Routing }
     *     
     */
    public void setRouting(Routing value) {
        this.routing = value;
    }

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
