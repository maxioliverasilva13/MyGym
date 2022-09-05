/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author maximilianooliverasilva
 */
public class SocioAlreadyAreInClass extends RuntimeException { 
    public SocioAlreadyAreInClass(String errorMessage) {
        super(errorMessage);
    }
}