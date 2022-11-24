/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author mandi
 */
public class ActividadEstaFinalizada extends RuntimeException {
    public ActividadEstaFinalizada(String errorMessage) {
        super(errorMessage);
    }
}
