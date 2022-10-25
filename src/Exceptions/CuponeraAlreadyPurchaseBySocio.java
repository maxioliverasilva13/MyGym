/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package Exceptions;

/**
 *
 * @author rodrigo
 */
public class CuponeraAlreadyPurchaseBySocio extends Exception{

    /**
     * Creates a new instance of <code>CuponeraAlreadyPurchaseBySocio</code>
     * without detail message.
     */
    public CuponeraAlreadyPurchaseBySocio() {
    }

    /**
     * Constructs an instance of <code>CuponeraAlreadyPurchaseBySocio</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public CuponeraAlreadyPurchaseBySocio(String msg) {
        super(msg);
    }
}
