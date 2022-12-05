/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package Exceptions;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author rodrigo
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ProfesorNoDictaClaseException extends Exception{

    /**
     * Creates a new instance of <code>ProfesorNoDictaClase</code> without
     * detail message.
     */
    public ProfesorNoDictaClaseException() {
    }

    /**
     * Constructs an instance of <code>ProfesorNoDictaClase</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ProfesorNoDictaClaseException(String msg) {
        super(msg);
    }
}
