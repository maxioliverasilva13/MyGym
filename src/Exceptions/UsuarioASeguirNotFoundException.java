/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author Maximiliano Olivera
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class UsuarioASeguirNotFoundException extends RuntimeException { 
    public UsuarioASeguirNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}