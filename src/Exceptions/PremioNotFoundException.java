/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package Exceptions;

/**
 *
 * @author rodrigo
 */
public class PremioNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>MaxClasesForCuponera</code> without
     * detail message.
     */
    public PremioNotFoundException() {
    }

    /**
     * Constructs an instance of <code>MaxClasesForCuponera</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PremioNotFoundException(String msg) {
        super(msg);
    }
}
