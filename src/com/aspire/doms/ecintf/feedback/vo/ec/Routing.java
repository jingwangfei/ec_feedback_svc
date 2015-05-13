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
 *         &lt;element name="RouteType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RouteValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "routeType",
    "routeValue"
})
@XmlRootElement(name = "Routing")
public class Routing {

    @XmlElement(name = "RouteType", required = true)
    protected String routeType;
    @XmlElement(name = "RouteValue", required = true)
    protected String routeValue;

    /**
     * Gets the value of the routeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRouteType() {
        return routeType;
    }

    /**
     * Sets the value of the routeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRouteType(String value) {
        this.routeType = value;
    }

    /**
     * Gets the value of the routeValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRouteValue() {
        return routeValue;
    }

    /**
     * Sets the value of the routeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRouteValue(String value) {
        this.routeValue = value;
    }

}
