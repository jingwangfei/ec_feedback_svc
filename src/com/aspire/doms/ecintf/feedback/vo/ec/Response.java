package com.aspire.doms.ecintf.feedback.vo.ec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="RspType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RspCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RspDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "rspType",
    "rspCode",
    "rspDesc"
})
@XmlRootElement(name = "Response")
public class Response {

    @XmlElement(name = "RspType", required = true)
    protected String rspType;
    @XmlElement(name = "RspCode", required = true)
    protected String rspCode;
    @XmlElement(name = "RspDesc", required = true)
    protected String rspDesc;

    /**
     * Gets the value of the rspType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRspType() {
        return rspType;
    }

    /**
     * Sets the value of the rspType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRspType(String value) {
        this.rspType = value;
    }

    /**
     * Gets the value of the rspCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRspCode() {
        return rspCode;
    }

    /**
     * Sets the value of the rspCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRspCode(String value) {
        this.rspCode = value;
    }

    /**
     * Gets the value of the rspDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRspDesc() {
        return rspDesc;
    }

    /**
     * Sets the value of the rspDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRspDesc(String value) {
        this.rspDesc = value;
    }

}
