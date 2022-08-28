/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package Socio.exceptions;

/**
 *
 * @author angel
 */
public class SocioNotExist extends Exception{

    /**
     * Creates a new instance of <code>SocioNotExist</code> without detail
     * message.
     */
    public SocioNotExist() {
    }

    /**
     * Constructs an instance of <code>SocioNotExist</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public SocioNotExist(String msg) {
        super(msg);
    }
}
