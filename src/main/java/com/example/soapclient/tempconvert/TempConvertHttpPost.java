
package com.example.soapclient.tempconvert;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "TempConvertHttpPost", targetNamespace = "https://www.w3schools.com/xml/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TempConvertHttpPost {


    /**
     * 
     * @param fahrenheit
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "FahrenheitToCelsius")
    @WebResult(name = "string", targetNamespace = "https://www.w3schools.com/xml/", partName = "Body")
    public String fahrenheitToCelsius(
        @WebParam(name = "string", targetNamespace = "http://www.w3.org/2001/XMLSchema", partName = "Fahrenheit")
        String fahrenheit);

    /**
     * 
     * @param celsius
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "CelsiusToFahrenheit")
    @WebResult(name = "string", targetNamespace = "https://www.w3schools.com/xml/", partName = "Body")
    public String celsiusToFahrenheit(
        @WebParam(name = "string", targetNamespace = "http://www.w3.org/2001/XMLSchema", partName = "Celsius")
        String celsius);

}
