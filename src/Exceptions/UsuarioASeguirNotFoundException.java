/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author Maximiliano Olivera
 */
public class UsuarioASeguirNotFoundException extends RuntimeException { 
    public UsuarioASeguirNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}