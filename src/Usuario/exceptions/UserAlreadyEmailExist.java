/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package Usuario.exceptions;

/**
 *
 * @author angel
 */
@SuppressWarnings("serial")
public class UserAlreadyEmailExist extends Exception {

    /**
     * Creates a new instance of <code>UserAlreadyEmailExist</code> without
     * detail message.
     */
    public UserAlreadyEmailExist() {
    }

    /**
     * Constructs an instance of <code>UserAlreadyEmailExist</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UserAlreadyEmailExist(String msg) {
        super(msg);
    }
}
