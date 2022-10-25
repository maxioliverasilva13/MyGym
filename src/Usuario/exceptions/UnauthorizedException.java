/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package Usuario.exceptions;

/**
 *
 * @author rodrigo
 */
public class UnauthorizedException extends Exception {

    /**
     * Creates a new instance of <code>UnauthorizedException</code> without
     * detail message.
     */
    public UnauthorizedException() {
    }

    /**
     * Constructs an instance of <code>UnauthorizedException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UnauthorizedException(String msg) {
        super(msg);
    }
}
