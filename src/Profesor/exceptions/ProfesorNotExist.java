/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package Profesor.exceptions;

/**
 *
 * @author angel
 */
public class ProfesorNotExist extends RuntimeException {

    /**
     * Creates a new instance of <code>ProfesorNotExist</code> without detail
     * message.
     */
    public ProfesorNotExist() {
    }

    /**
     * Constructs an instance of <code>ProfesorNotExist</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ProfesorNotExist(String msg) {
        super(msg);
    }
}
